package com.example.provafirebase02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import java.util.*
import kotlin.concurrent.schedule

class LoginActivity : AppCompatActivity() {

    lateinit var mailText : EditText
    lateinit var passText : EditText
    lateinit var loginButt : Button
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mailText = findViewById(R.id.loginMailText)
        passText = findViewById(R.id.loginPassText)
        loginButt = findViewById(R.id.loginButt)
        firebaseAuth = FirebaseAuth.getInstance()

        loginButt.setOnClickListener{

            loginUser()
        }
    }

    fun cheat(view: View){

        mailText.setText("test.firebase@gmail.com")
        passText.setText("123456")
    }

    private fun loginUser(){

        val mail = mailText.text.toString().trim()
        val pass = passText.text.toString().trim()

        if (TextUtils.isEmpty(mail))
            Toast.makeText(applicationContext, "Mail mancante", Toast.LENGTH_LONG).show()
        else {
            if (TextUtils.isEmpty(pass))
                Toast.makeText(applicationContext, "Pass mancante", Toast.LENGTH_LONG).show()
            else {

                firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(object: OnCompleteListener<AuthResult>{

                    override fun onComplete(task01: Task<AuthResult>) {
                        if(task01.isSuccessful){

                            Toast.makeText(applicationContext, "Loggato Bomber!", Toast.LENGTH_LONG).show()

                            Timer("Loggando", false).schedule(2000) {
                                startActivity(Intent(this@LoginActivity, DashActivity::class.java))
                            }
                        }else{
                            Toast.makeText(applicationContext, "Errore nel login: "+task01.exception?.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }


                })

            }

        }
    }
}