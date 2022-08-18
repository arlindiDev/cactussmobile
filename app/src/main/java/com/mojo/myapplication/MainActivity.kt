package com.mojo.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    lateinit var content: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content = findViewById(R.id.content)

        val cats = Gson().fromJson<List<Cat>>(catJson)

        for (cat in cats) {
            val animalItem = layoutInflater.inflate(R.layout.animal_item, null)

            val animalNameText = animalItem.findViewById<TextView>(R.id.animalNameText)
            val animalImage = animalItem.findViewById<ImageView>(R.id.animalImage)
            val descriptionText = animalItem.findViewById<TextView>(R.id.descriptionText)
            val ageText = animalItem.findViewById<TextView>(R.id.ageText)
            val cuteText = animalItem.findViewById<TextView>(R.id.isCute)
            val likeButoni = animalItem.findViewById<ImageView>(R.id.likeButton)
            val tekstiTeButoni = animalItem.findViewById<TextView>(R.id.tekstiTeButoni)

            Picasso.get().load(cat.url).into(animalImage)

            likeButoni.setOnClickListener {
                if (likeButoni.isClickable) {
                    tekstiTeButoni.visibility = View.VISIBLE
                }
            }

            animalImage.setOnClickListener {
                if (animalImage.isClickable) {
                    ageText.visibility = View.VISIBLE
                    descriptionText.visibility = View.VISIBLE
                    animalNameText.visibility = View.VISIBLE
//                    if (cat is Cat && cat.isCute) {  BREED
//                        cuteText.visibility = View.VISIBLE
//                    }
                }
            }

            animalNameText.text = cat.id
            //descriptionText.text = cat.description BREED
            //ageText.text = cat.age BREED

            content.addView(animalItem)
        }
    }
}

internal inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)
