package com.zunzum.intentpractice_zun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAM = 1005
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editNicknameBtn.setOnClickListener {
            val myIntent = Intent(this,EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQUEST_FOR_NICKNAM)
        }


        sendMessageBtn.setOnClickListener {
            val inputMessage = messageEdit.text.toString()
            val myIntent = Intent(this,MessageActivity::class.java)
            myIntent.putExtra("message",inputMessage)
            startActivity(myIntent)
        }

        moveToOtherBtn.setOnClickListener {
            val myIntent = Intent(this,OtherActivity::class.java)
            startActivity(myIntent)
        }
    }
}