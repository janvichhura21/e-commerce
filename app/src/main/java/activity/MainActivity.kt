package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.vardhmanjewellers.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    Handler(Looper.getMainLooper()).postDelayed({
        val intent=Intent(this, otpverification::class.java)
        intent.putExtra("name","9340469602")
startActivity(intent)

    },2000)
    }
}