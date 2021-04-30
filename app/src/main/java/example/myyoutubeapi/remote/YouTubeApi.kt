package example.myyoutubeapi.remote

import example.myyoutubeapi.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface YouTubeApi {

    @GET("playlists")
    suspend fun fetchPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String
    ): Response<PlayList>
}