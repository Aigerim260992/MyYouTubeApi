package example.myyoutubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import example.myyoutubeapi.constants.Constants
import example.myyoutubeapi.model.PlayList
import example.myyoutubeapi.network.RetrofitClient
import example.myyoutubeapi.remote.YouTubeApi
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {

    private var youTubeApi: YouTubeApi = RetrofitClient.create()

    fun fetchYouTubeApiPlayList(): LiveData<Response<PlayList>> = liveData(Dispatchers.IO) {
        val response =
            youTubeApi.fetchPlayList(Constants.PART, Constants.CHANNEL_ID, Constants.API_KEY)
        emit(response)
    }
}