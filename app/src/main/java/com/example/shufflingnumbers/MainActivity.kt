package com.example.shufflingnumbers

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->


            var digitInput: EditText = findViewById(R.id.editText_input)
            val textValue: TextView = findViewById(R.id.textview_value)

            val stringValue: String = digitInput.text.toString()
            val originalNumber: Int = Integer.parseInt(stringValue)


            // create a function to do the shuffling of numbers
            val newValue: Int? = doubleTheValue(originalNumber)


            textValue.text = newValue?.let { Integer.toString(it) }

            Snackbar.make(
                view, "Changed value from" + originalNumber + "to " + newValue,
                Snackbar.LENGTH_LONG
            )
                .setAction("Action", null).show()
        }

    }

    fun doubleTheValue(value: Int): Int {

          return value * 2
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}