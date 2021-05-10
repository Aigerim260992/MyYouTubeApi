package example.myyoutubeapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.myyoutubeapi.App
import example.myyoutubeapi.core.network.result.Resource
import example.myyoutubeapi.model.PlayList
import example.myyoutubeapi.remote.YouTubeApi
import retrofit2.Response

class MainViewModel : ViewModel() {

    fun fetchPlayList(): LiveData<Resource<PlayList>> {
        return App.repo. fetchYouTubeApiPlayList()
    }
}