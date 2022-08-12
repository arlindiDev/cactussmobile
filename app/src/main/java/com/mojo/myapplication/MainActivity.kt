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

        val animals = listOf(
            Dog("Bubi", R.drawable.dog, "qen i mir", "3 vet"),
            Dog("Reksi", R.drawable.dog1, "qen i mir", "4 vet"),
            Dog("Sharri", R.drawable.dog2, "qen i mir", "1 vet"),
            Dog("Haski", R.drawable.dog3, "qen i mir", "2 muj"),
            Dog("Meksi", R.drawable.dog4, "qen i mir", "3 vet"),
            Dog("Lacy", R.drawable.dog5, "qen i mir", "1 vet"),
        )

        for(animal in animals) {
            val animalItem = layoutInflater.inflate(R.layout.animal_item, null)

            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageView>(R.id.animalImage)

            animalNameText.text = animal.name
            animalImage.setImageResource(animal.image)

            content.addView(animalItem)
        }
    }
}

data class Dog(
    val name: String,
    val image: Int,
    val description: String,
    val age: String,
)
