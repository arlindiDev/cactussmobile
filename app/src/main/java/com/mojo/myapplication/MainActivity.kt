package com.mojo.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

    lateinit var content: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)

        val animals = listOf(
            Cat("Maculka", R.drawable.cat, "e urte", "1 vjet", true),
            Dog("Bubi", R.drawable.dog, "qen i mir", "3 vet"),
            Dog("Reksi", R.drawable.dog1, "qen i mir", "4 vet"),
            Dog("Sharri", R.drawable.dog2, "qen i mir", "1 vet"),
            Cat("Maca", R.drawable.cat, "e urte", "1 vjet", false),
            Dog("Haski", R.drawable.dog3, "qen i mir", "2 muj"),
            Dog("Meksi", R.drawable.dog4, "qen i mir", "3 vet"),
            Dog("Lacy", R.drawable.dog5, "qen i mir", "1 vet"),
        )

        for (animal in animals) {
            val animalItem: View = layoutInflater.inflate(R.layout.animal_item, null)

            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageView>(R.id.animalImage)
            val animalDescription = animalItem.findViewById<TextView>(R.id.descriptionText)
            val ageText = animalItem.findViewById<TextView>(R.id.ageText)
            val cuteText = animalItem.findViewById<TextView>(R.id.cuteText)

            animalNameText.text = animal.name
            animalImage.setImageResource(animal.image)
            animalDescription.text = animal.description
            ageText.text = animal.age

            if(animal is Cat && animal.isCute) {
                cuteText.visibility = View.VISIBLE
            }

            content.addView(animalItem)
        }
    }
}

open class Animal(
    val name: String,
    @DrawableRes val image: Int,
    val description: String,
    val age: String,
)

class Dog(
    name: String,
    image: Int,
    description: String,
    age: String,
) : Animal(name, image, description, age)

class Cat(
    name: String,
    image: Int,
    description: String,
    age: String,
    val isCute: Boolean
) : Animal(name, image, description, age)

