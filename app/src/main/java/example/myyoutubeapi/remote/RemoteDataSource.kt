package exaple.myyoutubeapi.remote

import example.myyoutubeapi.constants.Constants

import example.myyoutubeapi.core.network.BaseDataSource
import example.myyoutubeapi.core.network.RetrofitClient
import example.myyoutubeapi.remote.YouTubeApi


class RemoteDataSource: BaseDataSource() {

    private var apiService: YouTubeApi =RetrofitClient.create()

    suspend fun fetchPlaylist() = getResult {
        apiService.fetchPlayList(Constants.PART, Constants.CHANNEL_ID,Constants.API_KEY, Constants.MAX_RESULTS)
    }

    suspend fun fetchPlaylistItems(playlistId: String) = getResult {
        apiService.fetchPlayListItems(Constants.PART, playlistId, Constants.API_KEY, 5 )
    }





}