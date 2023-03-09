package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice();

        val homeScreenImage =
            findViewById<ImageView>(R.id.imageView).setImageResource((R.drawable.dice_6))

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val button1: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val score1Text: TextView = findViewById(R.id.score1)
        val score2Text: TextView = findViewById(R.id.score2)
        val luckyNumber = 4
        var score1 = 0
        var score2 = 0
        findViewById<TextView>(R.id.textView2).setText(luckyNumber.toString())

        button1.setOnClickListener {

            val diceImage: ImageView = findViewById(R.id.imageView)
            val diceRoll1 = dice.roll()
            when (diceRoll1) {
                luckyNumber -> {
                    score1++
                    Toast.makeText(this, "Congratulations! You guessed the lucky number", Toast.LENGTH_SHORT).show()
                    diceImage.setImageResource(R.drawable.dice_4)

                }
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
            score1Text.text = score1.toString()
            diceImage.contentDescription = diceRoll1.toString()
        }

        button2.setOnClickListener {

            val diceImage2: ImageView = findViewById(R.id.imageView2)
            val diceImage: ImageView = findViewById(R.id.imageView)
            val diceRoll2 = dice.roll()
            when (diceRoll2) {
                luckyNumber -> {
                    score2++
                    Toast.makeText(this, "Congratulations! You guessed the lucky number", Toast.LENGTH_SHORT).show()
                    diceImage2.setImageResource(R.drawable.dice_4)

                }
                1 -> diceImage2.setImageResource(R.drawable.dice_1)
                2 -> diceImage2.setImageResource(R.drawable.dice_2)
                3 -> diceImage2.setImageResource(R.drawable.dice_3)
                4 -> diceImage2.setImageResource(R.drawable.dice_4)
                5 -> diceImage2.setImageResource(R.drawable.dice_5)
                6 -> diceImage2.setImageResource(R.drawable.dice_6)
            }
            score2Text.text = score2.toString()
            diceImage.contentDescription = diceRoll2.toString()
        }

    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}