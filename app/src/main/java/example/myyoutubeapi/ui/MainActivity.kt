@file:Suppress("DEPRECATION")

package example.myyoutubeapi.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubeapi.R
import example.myyoutubeapi.FirstActivity
import example.myyoutubeapi.NetworkCheker
import example.myyoutubeapi.extentions.showToast
import example.myyoutubeapi.model.PlayList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainAdapter.ItemOnClick {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private var mainViewModel: MainViewModel? = null
    private lateinit var networkCheker: NetworkCheker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNetWork()
    }

    private fun checkNetWork() {
        networkCheker = NetworkCheker(this)
        if (!isNetworkAvaible()) {
            startActivity(Intent(this, FirstActivity::class.java))
        }
        networkCheker.observe(this, Observer {
            if (it) {
                initLiveData()
            } else {
                startActivity(Intent(this, FirstActivity::class.java))
            }
        })
    }

    private fun initLiveData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel!!.fetchPlayList().observe(this, Observer {
            if (it != null) {
                recyclerView = rv_main
                mainAdapter = MainAdapter(it.body()!!, this)
                recyclerView.adapter = mainAdapter
            }
        })
    }

    private fun isNetworkAvaible(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    override fun onClick(id: String) {
        showToast(this, id)
    }

}