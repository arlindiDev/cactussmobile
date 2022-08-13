package com.mojo.myapplication

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

    lateinit var content: LinearLayoutCompat


    open class Animal(
        val name: String,
        @DrawableRes var image: Int,
        val age: String,
        val description: String,
    )

    class Dog(
        name: String,
        image: Int,
        age: String,
        description: String
    ) : Animal(name, image, age, description)


    class Cat(
        name: String,
        image: Int,
        age: String,
        description: String,
        val isCute: Boolean
    ) : Animal(name, image, age, description)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)




        val animals = listOf(
            Dog("Bubi", R.drawable.dog, "Mosha: 6 muaj", "Bubi eshte nje Laborador Retriever, shume i embel."),
            Dog("Reksi", R.drawable.dog1, "Mosha: 1 vjet", "Reksi eshte nje Kerry Beagle dhe i ka shume qef lojrat."),
            Dog("Tokyo", R.drawable.dog2, "Mosha: 5 vjet", "Tokyo eshte nje Golden Retriever dhe i do te gjithe."),
            Cat("Lara", R.drawable.cat, "Mosha: 3 muaj", "Lara eshte nje Munchkin. Eshte lozonjare dhe e dashur.", true)
        )


        for (animal in animals) {
            val animalItem = layoutInflater.inflate(R.layout.animal_item, null)

            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageButton>(R.id.animalImage)
            val descriptionText = animalItem.findViewById<TextView>(R.id.descriptionText)
            val ageText = animalItem.findViewById<TextView>(R.id.ageText)
            val cuteText = animalItem.findViewById<TextView>(R.id.isCute)
            val likeButoni= animalItem.findViewById<ImageView>(R.id.likeButton)
            val tekstiTeButoni = animalItem.findViewById<TextView>(R.id.tekstiTeButoni)

                likeButoni.setOnClickListener(){
                    if (likeButoni.isClickable){
                      tekstiTeButoni.visibility = View.VISIBLE
                    }
                }

            animalImage.setOnClickListener(){
                if (animalImage.isClickable){
                    ageText.visibility =View.VISIBLE
                    descriptionText.visibility =View.VISIBLE
                    animalNameText.visibility =View.VISIBLE
                    if (animal is Cat && animal.isCute) {
                        cuteText.visibility = View.VISIBLE
                    }
                }
            }



            animalNameText.text = animal.name
            animalImage.setImageResource(animal.image)
            descriptionText.text = animal.description
            ageText.text = animal.age



            content.addView(animalItem)
        }
    }
}
