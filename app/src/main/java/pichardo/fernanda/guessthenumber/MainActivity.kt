package pichardo.fernanda.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var minValue = 0
    var maxValue = 100
    var num: Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minValue,maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if (chckingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("No way! You beat me :c")
            }
        }

        down.setOnClickListener {
            maxValue = num
            if (chckingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("No way! You beat me :c")
            }
        }

        guessed.setOnClickListener {
            if (!won){
                guessings.setText("Yeah! your number is: " + num)
                guessed.setText("Play Again")
                won = true
            } else{
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
                resetValues()
            }


        }

    }

    fun chckingLimits():Boolean{
        return minValue != maxValue
    }

    fun resetValues(){
        minValue = 0
        maxValue = 100
        num = 0
        won = false
    }

}