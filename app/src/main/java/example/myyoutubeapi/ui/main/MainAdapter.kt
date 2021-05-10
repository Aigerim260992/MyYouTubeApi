package example.myyoutubeapi.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutubeapi.R
import example.myyoutubeapi.extentions.loadImage
import example.myyoutubeapi.model.Items
import example.myyoutubeapi.model.PlayList
import kotlinx.android.synthetic.main.item_view.view.*

class MainAdapter(private var playList: PlayList, private var itemOnClick: ItemOnClick) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList.items[position], itemOnClick)
    }

    override fun getItemCount(): Int {
        return playList.items.size
    }

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun onBind(items: Items, itemOnClick: ItemOnClick) {
            itemView.textTitle.setText(items.snippet.title)
            itemView.subTitle.setText(items.snippet.description)
            itemView.imageView.loadImage(items.snippet.thumbnails.medium.url)
            itemView.setOnClickListener {
                itemOnClick.onClick(items.id)
            }
        }
    }

    interface ItemOnClick {
        fun onClick(id: String)
    }
}