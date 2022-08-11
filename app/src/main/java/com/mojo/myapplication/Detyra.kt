package com.mojo.myapplication

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Detyra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detyra)

        var emri = findViewById<EditText>(R.id.inputemri)
        var mbiemri = findViewById<EditText>(R.id.inputmbiemri)
        var mosha = findViewById<EditText>(R.id.inputage)
        var animal = findViewById<EditText>(R.id.inputanimal)

        var butoni = findViewById<Button>(R.id.butoni)
        var tregoshkronjat = findViewById<TextView>(R.id.tregoShkronjat)
        var tregousernamin = findViewById<TextView>(R.id.tregousernamin)

        var randomDogName = listOf("Bubi", "Pitbull", "Husky", "Dobbberman", "Labrador", "German Shepherd", "Bulldog").random()
        var randomCatName = listOf("Abyssinian", "Burmese", "British", "Cornish", "Devon", "Egyptian").random()
        var randomDinosaurName = listOf("Raptor", "Rex", "Robber", "Roof", "Stego", "Saurus", "Lizard").random()

        lateinit var kafsha:String
        fun randomUsername1(emri: String, mbiemri: String, kafsha: String, mosha: Editable): String {
            if (kafsha.lowercase() == "dog") {
                return ("${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomDogName}")
            }
            if (kafsha.lowercase() == "dinosaur") {
                return ("${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomDinosaurName}")
            }
            if (kafsha.lowercase() == "cats") {
                return ("${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomCatName}")
            } else {
                return ("${emri.get(0)}.${mbiemri.get(0)}${mosha}")
            }
        }

        fun randomUsername2(emri: String, mbiemri: String, kafsha: String, mosha: Editable): String {
            if (kafsha.lowercase() == "dog") {
                return ("${emri}${mbiemri.get(0)}.${randomDogName}")
            }
            if (kafsha.lowercase() == "dinosaur") {
                return ("${emri}${mbiemri.get(0)}.${randomDinosaurName}")
            }
            if (kafsha.lowercase() == "cats") {
                return ("${emri}${mbiemri.get(0)}.${randomCatName}")
            } else {
                return ("${emri.take(2)}.${mbiemri.take(2)}${mosha}")
            }
        }

        fun randomUsername3(emri: String, mbiemri: String, kafsha: String, mosha: Editable): String {
            if (kafsha.lowercase() == "dog") {
                return ("${emri}${mbiemri}.${randomDogName}${mosha}")
            }
            if (kafsha.lowercase() == "dinosaur") {
                return ("${emri}${mbiemri}.${randomDinosaurName}${mosha}")
            }
            if (kafsha.lowercase() == "cats") {
                return ("${emri}${mbiemri}.${randomCatName}${mosha}")
            } else {
                return ("${emri.take(1)}.${mbiemri}${mosha}")
            }
        }


        var randomUserNames = listOf(randomUsername1(
                emri.text.toString(),
                mbiemri.text.toString(),
                kafsha ,
                mosha.text
            ), randomUsername2(
                emri.text.toString(),
                mbiemri.text.toString(),
                kafsha ,
                mosha.text
            ), randomUsername3(
                emri.text.toString(),
                mbiemri.text.toString(),
                kafsha,
                mosha.text
            )
        )
        butoni.setOnClickListener {
            val gjatesiaeEmrit = emri.text.length
            var kafsha = animal.text
            tregoshkronjat.text = "Emri juaj ka ${gjatesiaeEmrit} shkronja"
            tregousernamin.text = randomUserNames[Random.nextInt(randomUserNames.size)]

        }


    }


}