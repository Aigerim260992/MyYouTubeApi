package example.myyoutubeapi.ui.playlistdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubeapi.R
import example.myyoutubeapi.core.network.result.Status
import example.myyoutubeapi.extentions.showToast
import example.myyoutubeapi.model.PlayList
import kotlinx.android.synthetic.main.activity_playlist_details.*

class PlaylistDetailsActivity : AppCompatActivity() {

      private lateinit var playlistId: String
      private lateinit var viewModel: PlaylistDetailsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var playlistDetailsAdapter: PlaylistDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_details)
        pl_back.setOnClickListener {
            finish()
        }
        loadIntent()
        initLiveData()
    }

    private fun initRecyclerView(data: PlayList) {
        recyclerView = rv_details
        playlistDetailsAdapter = PlaylistDetailsAdapter()
        playlistDetailsAdapter.addItems(data)
        recyclerView.adapter = playlistDetailsAdapter
    }

    private fun initLiveData() {
        viewModel = ViewModelProvider(this).get(PlaylistDetailsViewModel::class.java)
        viewModel.fetchPlaylistItems(playlistId).observe(this, Observer {
         when(it.status){
             Status.SUCCESS ->{
                 it.data?.let { it1 -> initRecyclerView(it1) }
             }
             Status.ERROR ->{
                 //error
             }
             Status.LOADING->{
                 //loading
             }
         }
        })
    }

    private fun loadIntent() {
        playlistId = intent.getStringExtra("keyId").toString()
    }

}