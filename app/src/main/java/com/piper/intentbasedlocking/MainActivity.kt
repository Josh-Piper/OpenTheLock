package com.piper.intentbasedlocking

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var lockButton: ImageView
    lateinit var askForName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lockButton = findViewById(R.id.lockBtn)
        askForName = findViewById(R.id.askForNameBtn)

        val resource = intent.getIntExtra("drawable", R.drawable.lock_locked_foreground)
        val drawable: Drawable? = getDrawable(resource)
        lockButton.setImageDrawable(drawable)

        lockButton.setOnClickListener {
            val openLock = Intent(this, OpenLockActivity::class.java).apply {
                putExtra("name", askForName.text.toString())
            }
            startActivity(openLock)
        }

        lockButton.setOnLongClickListener {
            lockButton.setImageDrawable(getDrawable(R.drawable.lock_locked_foreground))
            true
        }


    }
}