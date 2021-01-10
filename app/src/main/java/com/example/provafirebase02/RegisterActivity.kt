package com.example.provafirebase02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import java.util.*
import kotlin.concurrent.schedule

class RegisterActivity : AppCompatActivity() {

    lateinit var mailText: EditText
    lateinit var passText: EditText
    lateinit var registButt: Button
    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mailText = findViewById(R.id.registerMailText)
        passText = findViewById(R.id.registerPassText)
        registButt = findViewById(R.id.registButt)
        firebaseAuth = FirebaseAuth.getInstance()

        registButt.setOnClickListener {

            registerUser()
        }
    }


    private fun registerUser() {

        val mail = mailText.text.toString().trim()
        val pass = passText.text.toString().trim()

        if (TextUtils.isEmpty(mail))
            Toast.makeText(applicationContext, "Mail mancante", Toast.LENGTH_LONG).show()
        else {
            if (TextUtils.isEmpty(pass))
                Toast.makeText(applicationContext, "Pass mancante", Toast.LENGTH_LONG).show()
            else {   //qui si fa la registrazione in firebase

                firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task01: Task<AuthResult>) {
                        if (task01.isSuccessful) {

                            Toast.makeText(applicationContext, "Account creato", Toast.LENGTH_LONG).show()


                            Timer("SettingUp", false).schedule(5000) {
                                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                            }
                        } else {

                            Toast.makeText(applicationContext, "Errore nella creazione dell'account: " + task01.exception?.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                })
            }
        }
    }
}