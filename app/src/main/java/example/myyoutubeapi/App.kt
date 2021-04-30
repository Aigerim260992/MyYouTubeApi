package example.myyoutubeapi

import android.app.Application
import example.myyoutubeapi.repository.Repository

class App: Application(){

    companion object {
        val repo = Repository()
    }

}