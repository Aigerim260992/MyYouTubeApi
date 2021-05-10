package example.myyoutubeapi.ui.playlistdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubeapi.R
import example.myyoutubeapi.extentions.loadImage
import example.myyoutubeapi.model.Items
import example.myyoutubeapi.model.PlayList
import example.myyoutubeapi.ui.main.MainAdapter
import kotlinx.android.synthetic.main.item_view.view.*

class PlaylistDetailsAdapter: RecyclerView.Adapter<PlaylistDetailsAdapter.ViewHolder>() {

    private lateinit var playList: PlayList
    private var list: List<Items> = listOf()

     fun addItems(playList: PlayList){
         this.playList = playList
         list = playList.items
         notifyDataSetChanged()
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.onBind(list[position])
    }

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {


        fun onBind(items: Items) {
            itemView.container_view.visibility = View.INVISIBLE
            itemView.container_tv.visibility = View.INVISIBLE
            itemView.textTitle.setText(items.snippet.title)
            itemView.subTitle.setText(items.snippet.description)
            itemView.imageView.loadImage(items.snippet.thumbnails.medium.url)
        }

    }
}