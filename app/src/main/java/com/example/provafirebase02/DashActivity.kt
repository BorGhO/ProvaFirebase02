package com.example.provafirebase02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        val lesson01 = "https://firebasestorage.googleapis.com/v0/b/provafirebase02.appspot.com/o/barbero01.mp4?alt=media&token=ba333bd1-4c86-460b-995b-2c23e03587d2"
        val lesson02 = "https://firebasestorage.googleapis.com/v0/b/provafirebase02.appspot.com/o/barbero01.mp4?alt=media&token=ba333bd1-4c86-460b-995b-2c23e03587d2"
        val lesson03 = "https://firebasestorage.googleapis.com/v0/b/provafirebase02.appspot.com/o/bran01.mp4?alt=media&token=3f8755b0-e4b0-435b-a1e6-18030f8515bb"
        val lesson04 = "https://firebasestorage.googleapis.com/v0/b/provafirebase02.appspot.com/o/eastermountain.mp4?alt=media&token=7b860bb7-12f6-4847-8ee7-24a2662f87c7"

        val lezioni = ArrayList<Lesson>()

        lezioni.add(Lesson("pri Titolo", "pri Desc", lesson01))
        lezioni.add(Lesson("sec Titolo", "sec Desc", lesson02))
        lezioni.add(Lesson("ter Titolo", "ter Desc", lesson03))
        lezioni.add(Lesson("qua Titolo", "qua Desc", lesson04))

        val adapter = Adapter(lezioni,applicationContext)



        val list = findViewById<RecyclerView>(R.id.mainRecy)
        list.layoutManager = GridLayoutManager(applicationContext, 1)


        list.adapter = adapter


    }
}