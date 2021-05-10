package example.myyoutubeapi.ui.connection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myyoutubeapi.R
import example.myyoutubeapi.extentions.showToast
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    private lateinit var networkChecker: NetworkCheker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        networkChecker = NetworkCheker(this)
        try_again_button.setOnClickListener {
            if (isNetworkAvaible()) {
                finish()
            } else {
                showToast(this, "Not connected")
            }
        }


    }

    private fun isNetworkAvaible(): Boolean {
        var isAvaible = false
        networkChecker.observe(this, Observer {
            isAvaible = it
        })
        return isAvaible
    }
}