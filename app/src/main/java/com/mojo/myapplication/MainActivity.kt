package com.mojo.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val colors = listOf(
        Ngjyra("Black", Color.parseColor("#000000")),
        Ngjyra("Red", Color.RED),
        Ngjyra("BLUE", Color.BLUE),
        Ngjyra("Pink", Color.parseColor("#ff00ff")),
        Ngjyra("Yellow", Color.parseColor("#ffff00")),
        Ngjyra("Silver", Color.parseColor("#c0c0c0")),
    )

    data class Ngjyra(val emri: String, val color: Int)

    lateinit var view1: View
    lateinit var view2: View
    lateinit var view3: View
    lateinit var view4: View
    lateinit var textColor: TextView
    lateinit var scoreText: TextView
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)
        view4 = findViewById(R.id.view4)
        textColor = findViewById(R.id.textColor)
        scoreText = findViewById(R.id.score)

        nextRound()
    }

    fun nextRound() {
        var clicked1=false
        var clicked2=false
        var clicked3=false
        var clicked4=false

        scoreText.text = "Score: $score"
        val someColors = colors.toMutableList()

        val firstColor = someColors[Random.nextInt(someColors.size)]
        someColors.remove(firstColor)

        val secondColor = someColors[Random.nextInt(someColors.size)]
        someColors.remove(secondColor)

        val thirdColor = someColors[Random.nextInt(someColors.size)]
        someColors.remove(thirdColor)

        val fourthColor = someColors[Random.nextInt(someColors.size)]

        val randomizedColors = listOf(firstColor, secondColor, thirdColor, fourthColor)
        val winningColor = randomizedColors[Random.nextInt(randomizedColors.size)]

        view1.setBackgroundColor(firstColor.color)
        view2.setBackgroundColor(secondColor.color)
        view3.setBackgroundColor(thirdColor.color)
        view4.setBackgroundColor(fourthColor.color)
        textColor.text = winningColor.emri

        var count = 0

        view1.setOnClickListener {
            if(clicked1==false){
            if (firstColor == winningColor) {
                score--
                nextRound()
            } else {
                count++
                textColor.text = "Left to go ${3 - count}"
                if(count == 3) {
                    score++
                    nextRound()
                }
            }}
            clicked1=true
        }

        view2.setOnClickListener {
            if(clicked2==false){
            if (secondColor == winningColor) {
                score--
                nextRound()
            } else {
                count++
                textColor.text = "Left to go ${3 - count}"
                if(count == 3) {
                    score++
                    nextRound()
                }
            }
            }
            clicked2=true
        }

        view3.setOnClickListener {
            if(clicked3==false){
            if (thirdColor == winningColor) {
                score--
                nextRound()
            } else {
                count++
                textColor.text = "Left to go ${3 - count}"
                if(count == 3) {
                    score++
                    nextRound()
                }
            }
        }
            clicked3=true
        }

        view4.setOnClickListener {
            if(clicked4==false){
            if (fourthColor == winningColor) {
                score--
                nextRound()
            } else {
                count++
                textColor.text = "Left to go ${3 - count}"
                if(count == 3) {
                    score++
                    nextRound()
                }
            }
        }
            clicked4=true
        }
    }
}

// 4 ngjyra zgjedhi random
// 1
// 2
// 3
// 4

// 3 zgjedhe 1 random prej qatyne te katertave
