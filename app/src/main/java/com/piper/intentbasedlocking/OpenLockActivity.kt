package com.piper.intentbasedlocking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class OpenLockActivity : AppCompatActivity() {


    lateinit var openLockButton: ImageView
    lateinit var openLockText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lock_open)

        openLockButton = findViewById(R.id.openBtn)
        openLockText = findViewById(R.id.accessDoorTextView)

        fun checkNullOrEmpty(value: String?): String =
            if (value.isNullOrEmpty()) "Alrighty then" else value

        val possibleName = intent.getStringExtra("name")
        val name = checkNullOrEmpty(possibleName)

        openLockText.text = "$name, would you like to open the lock?"

        openLockButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("drawable", R.drawable.lock_open_foreground)
                addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            }
            startActivity(intent)
            finish()
        }


    }
}