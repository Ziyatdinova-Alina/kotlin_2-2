package ru.myitschool.lab22toast

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var rotationCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("rotate_create", rotationCount.toString())
        if (savedInstanceState != null){
            rotationCount = savedInstanceState.getInt("сount")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast(R.string.ncreate)

    }

    override fun onStart() {
        super.onStart()
        showToast(R.string.nstart)
    }

    override fun onResume() {
        super.onResume()
        showToast(R.string.nresume)
    }

    override fun onDestroy() {
        rotationCount++
        super.onDestroy()
        if (rotationCount % 2 == 0) {
            showToast(R.string.ndestroy)
        }

        Log.d("rotate_destroy", rotationCount.toString())
    }

    override fun onRestart() {
        super.onRestart()
        showToast(R.string.nrestart)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("rotate_save", rotationCount.toString())
        outState.putInt("сount", rotationCount)
    }

    private fun showToast(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
