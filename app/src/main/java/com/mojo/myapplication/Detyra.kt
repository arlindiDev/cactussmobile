package com.mojo.myapplication

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Detyra: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detyra)

        var emri=findViewById<EditText>(R.id.inputemri)
        var mbiemri=findViewById<EditText>(R.id.inputmbiemri)
        var mosha=findViewById<EditText>(R.id.inputage)
        var animal=findViewById<EditText>(R.id.inputanimal)

        var butoni=findViewById<Button>(R.id.butoni)
        var tregoshkronjat=findViewById<TextView>(R.id.tregoShkronjat)
        var tregousernamin=findViewById<TextView>(R.id.tregousernamin)

        var randomDogName= listOf("Bubi","Pitbull","Husky","Dobbberman","Labrador","German Shepherd","Bulldog").random()
        var randomCatName= listOf("Abyssinian","Burmese","British","Cornish","Devon","Egyptian").random()
        var randomDinosaurName= listOf("Raptor","Rex","Robber","Roof","Stego","Saurus","Lizard").random()

        fun shfaqUsernamin(emri:String, mbiemri:String, kafsha:String, mosha: Editable) {
            if (kafsha.lowercase()=="dog"){
                tregousernamin.text = ("${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomDogName}")
            }
            if (kafsha.lowercase()=="dinosaur"){
                tregousernamin.text = "${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomCatName}"
            }
            if (kafsha.lowercase()=="cats"){
                tregousernamin.text = "${emri.get(0)}${mbiemri.get(0)}${mosha}.${randomDinosaurName}"
            }
            else
            {
                tregousernamin.text="${emri}.${mbiemri.get(0)}${mosha}"
            }
        }


        butoni.setOnClickListener {
            var gjatesiaeEmrit=emri.text.length
            var kafsha=animal.text
            tregoshkronjat.text = "Emri juaj ka ${gjatesiaeEmrit} shkronja"
            shfaqUsernamin(emri.text.toString(),mbiemri.text.toString(),kafsha.toString(),mosha.text)

        }


    }



}