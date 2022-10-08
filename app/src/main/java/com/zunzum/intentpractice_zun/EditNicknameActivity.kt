package com.zunzum.intentpractice_zun

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        okBtn.setOnClickListener {
            //입력한 새 닉네임은 뭔지 변수로 저장 inputNewNickname이 변수이름
            val inputNewNickname = newNicknameEdt.text.toString()

            //입력한 닉네임을 가지고 메인으로 복귀

            //아래는 입력한 닉네임을 담아주기 위한 용도로만 사용하는 Intent
            val resultIntent = Intent()
            resultIntent.putExtra("ncikname", inputNewNickname)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()


        }


    }
}