package com.example.provafirebase02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun registrazione(view: View){

        startActivity(Intent(this, RegisterActivity::class.java ))
    }

    fun login(view: View){
        startActivity(Intent(this, LoginActivity::class.java ))
    }
}