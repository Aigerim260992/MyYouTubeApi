package example.myyoutubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import example.myyoutubeapi.model.PlayList
import example.myyoutubeapi.core.network.result.Resource
import exaple.myyoutubeapi.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class Repository( private val dataSource: RemoteDataSource) {


    fun fetchYouTubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchPlaylist()
        emit(response)
    }

    fun fetchYouTubeApiPlayListDetails(playListId: String): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchPlaylistItems(playListId)
        emit(response)
    }


}