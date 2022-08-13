package com.mojo.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var content: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)

        val animals = listOf(
            Cat("Maculka", R.drawable.cat, "e urte", "1 vjet", isCute = true, likesCount = 0),
            Dog("Bubi", R.drawable.dog, "qen i mir", "3 vjet", 0),
            Dog("Reksi", R.drawable.dog1, "qen i mir", "4 vjet", 0),
            Dog("Sharri", R.drawable.dog2, "qen i mir", "1 vjet", 0),
            Cat("Maca", R.drawable.cat, "e urte", "1 vjet", 0, isCute = false),
            Dog("Haski", R.drawable.dog3, "qen i mir", "2 muj", 0),
            Dog("Meksi", R.drawable.dog4, "qen i mir", "3 vjet", 0),
            Dog("Lacy", R.drawable.dog5, "qen i mir", "1 vjet", 0),
        )

        for (animal in animals) {
            val animalItem: View = layoutInflater.inflate(R.layout.animal_item, null)
            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageView>(R.id.animalImage)
            val animalDescription = animalItem.findViewById<TextView>(R.id.descriptionText)
            val ageText = animalItem.findViewById<TextView>(R.id.ageText)
            val cuteText = animalItem.findViewById<TextView>(R.id.cuteText)
            var showLikes = animalItem.findViewById<TextView>(R.id.likesNumber)
            val likeButton = animalItem.findViewById<Button>(R.id.likeButton)
            val dislikeButton = animalItem.findViewById<Button>(R.id.dislikeButton)

            animalNameText.text = animal.name
            animalImage.setImageResource(animal.image)
            animalDescription.text = animal.description
            ageText.text = animal.age
            showLikes.text = animal.likesCount.toString()

            content.addView(animalItem)

            animalImage.setOnClickListener() {
                animalDescription.isVisible = true
                ageText.isVisible = true
                animalNameText.isVisible = true
                if (animal is Cat && animal.isCute) {
                    cuteText.visibility = View.VISIBLE
                }

            }

            likeButton.setOnClickListener() {
                animal.likesCount++
                showLikes.text = animal.likesCount.toString()
                likeButton.setBackgroundColor(Color.BLUE)
            }
            dislikeButton.setOnClickListener() {
                animal.likesCount = animal.likesCount - 1
                showLikes.text = animal.likesCount.toString()
                dislikeButton.setBackgroundColor(Color.RED)
            }

        }
    }
}

open class Animal(
    val name: String,
    @DrawableRes val image: Int,
    val description: String,
    val age: String,
    var likesCount: Int
)

class Dog(
    name: String,
    image: Int,
    description: String,
    age: String,
    likesCount: Int
) : Animal(name, image, description, age, likesCount)

class Cat(
    name: String,
    image: Int,
    description: String,
    age: String,
    likesCount: Int,
    val isCute: Boolean
) : Animal(name, image, description, age, likesCount)

