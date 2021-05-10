package example.myyoutubeapi

import android.app.Application

import example.myyoutubeapi.repository.Repository
import exaple.myyoutubeapi.remote.RemoteDataSource

class App: Application(){

    companion object {
        val repo = Repository(RemoteDataSource())
    }

}