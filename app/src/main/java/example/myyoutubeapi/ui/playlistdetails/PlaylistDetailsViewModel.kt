package example.myyoutubeapi.ui.playlistdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.myyoutubeapi.App
import example.myyoutubeapi.core.network.result.Resource
import example.myyoutubeapi.model.PlayList

class PlaylistDetailsViewModel: ViewModel() {
     fun fetchPlaylistItems(playlistId: String): LiveData<Resource<PlayList>>{
         return App.repo.fetchYouTubeApiPlayListDetails(playlistId)
     }
}