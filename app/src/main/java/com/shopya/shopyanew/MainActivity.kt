package com.shopya.shopyanew

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        val button = findViewById<Button>(R.id.buttonbir)
        button.setOnClickListener {
            val textView: TextView = findViewById(R.id.sayac) as TextView
            val tesbihat: TextView = findViewById(R.id.tesbihatText) as TextView
            count++
            if (count == 33)
            {
                if (tesbihat.text == "SuphanAllah")
                {
                    tesbihat.text = "Elhamdülillah"
                    vibrateKisa()
                }
                else if (tesbihat.text == "Elhamdülillah")
                {
                    tesbihat.text = "Allahu Ekber"
                    vibrateKisa()
                }
                else if (tesbihat.text == "Allahu Ekber")
                {

                    Toast.makeText(this@MainActivity, "Allah Kabul Etsin", Toast.LENGTH_SHORT).show();
                    tesbihat.text = "SuphanAllah"
                    vibrate()
                }

                count = 0
            }
            textView.text = count.toString()
            //Toast.makeText(this@MainActivity, ""+textViewString+"", Toast.LENGTH_SHORT).show();
        }
        val eksibutton = findViewById<Button>(R.id.eksibutton)
        eksibutton.setOnClickListener {
            val textView: TextView = findViewById(R.id.sayac) as TextView
            count--
            if (count > -1) {
                textView.text = count.toString()
                vibrateKisa()
            }
            else {
                count = 0
            }
            //Toast.makeText(this@MainActivity, ""+textViewString+"", Toast.LENGTH_SHORT).show();
        }

        val resetle = findViewById<Button>(R.id.resetButton)
        resetle.setOnClickListener {
            val textView: TextView = findViewById(R.id.sayac) as TextView
            val tesbihat: TextView = findViewById(R.id.tesbihatText) as TextView
            count = 0
            textView.text = count.toString()
            tesbihat.text = "SuphanAllah"
            vibrateKisa()
            //Toast.makeText(this@MainActivity, ""+textViewString+"", Toast.LENGTH_SHORT).show();
        }
    }
    private fun vibrate(){
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(400)
        }
    }
    private fun vibrateKisa(){
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200)
        }
    }
}