package com.mojo.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

    lateinit var content: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)

        val animals = mapOf(
            "Bubi" to R.drawable.dog,
            "Haski" to R.drawable.dog1,
            "Sharri" to R.drawable.dog2,
            "Reksi" to R.drawable.dog3,
            "Dobermani" to R.drawable.dog4,
            "Qeni" to R.drawable.dog5
        )

        for(animal in animals) {
            val animalItem = layoutInflater.inflate(R.layout.animal_item, null)

            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageView>(R.id.animalImage)

            animalNameText.text = animal.key
            animalImage.setImageResource(animal.value)

            content.addView(animalItem)
        }
    }
}
