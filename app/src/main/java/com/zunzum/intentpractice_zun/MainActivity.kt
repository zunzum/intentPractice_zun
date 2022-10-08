package com.zunzum.intentpractice_zun

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAM = 1005
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsBtn.setOnClickListener {
            val inputPhoneNumber = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNumber}")
            val myintent = Intent(Intent.ACTION_SENDTO, myUri)
            myintent.putExtra("sms_body", "미리 내용 입력")
            startActivity(myintent)
        }

        //CALL 액션 예제
        callBtn.setOnClickListener {
            //phoneNumEdt에 입력한 전화번호를 받아서 => 해당 번호에 전화 연결
            val inputPhoneNumber = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNumber}")

            val myintent = Intent(Intent.ACTION_CALL, myUri)

            startActivity(myintent)
        }

        //Dial 액션 예제
        dialBtn.setOnClickListener {
            //phoneNumEdt에 입력한 전화번호를 받아서 => 해당 번호에 전화 연결
            val inputPhoneNumber = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNumber}")

            val myintent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myintent)
        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if (requestCode == REQUEST_FOR_NICKNAM) {
            //추가질문 : 확인을 눌러서 돌아온게 맞는지?
            if(resultCode == RESULT_OK) {
                //실제 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영
                val newNickname = data?.getStringExtra("ncikname")
                nicknameTxt.text = newNickname
            }
        }
    }
}