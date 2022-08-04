package com.mojo.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

    lateinit var firstColor: Ngjyra
    lateinit var winningColor: Ngjyra
    var score = 0
    var count = 0

data class ViewsClicked (
    var clicked1: Boolean,
    var clicked2: Boolean ,
    var clicked3: Boolean,
    var clicked4: Boolean
)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)
        view4 = findViewById(R.id.view4)
        textColor = findViewById(R.id.textColor)
        scoreText = findViewById(R.id.score)

        nextRound(ViewsClicked(clicked1 = Boolean, clicked2 = Boolean))
    }

    fun nextRound(isClicked:ViewsClicked) {
        isClicked.clicked1 = false
        isClicked.clicked2 = false
        isClicked.clicked3 = false
        isClicked.clicked4 = false

        scoreText.text = "Score: $score"
        val someColors = colors.toMutableList()

        firstColor = someColors[Random.nextInt(someColors.size)]
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

        setOnClickForView(view1, firstColor, isClicked.clicked1)
        setOnClickForView(view2, secondColor, isClicked.clicked2)
        setOnClickForView(view3, thirdColor, isClicked.clicked3)
        setOnClickForView(view4, fourthColor, isClicked.clicked4)
    }

    fun setOnClickForView(view: View, color: Ngjyra, isClicked: Boolean) {
       val newValue=isClicked
        view.setOnClickListener {
            if (!isClicked) {
                if (color == winningColor) {
                    score--
                    nextRound(isClicked)
                } else {
                    count++
                    textColor.text = "Left to go ${3 - count}"
                    if (count == 3) {
                        score++
                        nextRound()
                    }
                }
            }

            isClicked = true
        }
    }
}