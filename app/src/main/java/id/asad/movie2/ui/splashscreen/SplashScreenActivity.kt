package id.asad.movie2.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.asad.movie2.R
import id.asad.movie2.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    private val delayMillis : Long = 2000
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        handler.postDelayed(Runnable {
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }, delayMillis)
    }
}