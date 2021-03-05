package com.example.shufflingnumbers

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.Collections.shuffle
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var mAdapterNumbers: ArrayAdapter<Int>? = null
    private var mNumbersList: ArrayList<Int>? = null
    private var mNumber: Int? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

// getting the edittext we are going to input our value into
            var digitInput: EditText = findViewById(R.id.editText_input)

            // Converting the value in the edittext to int so we canuse it for math operations

            val stringValue: String = digitInput.text.toString()
            // the value of the inputed number in integer format
            val originalNumber: Int = Integer.parseInt(stringValue)



            // create a function to do the shuffling of numbers
            shuffleNumbers(originalNumber)


//          displaying the original inputed value
            Snackbar.make(
                view, "Number inputed was: $originalNumber",
                Snackbar.LENGTH_LONG
            )
                .setAction("Action", null).show()
        }

    }


    private fun shuffleNumbers(number : Int) {


        //getting the number inputed to the edittext
        mNumber = number
        //creating a listview to hold the lists of numbers
        val listNumbers: ListView = findViewById(R.id.list_numbers)
        // creating an emptylist we will be adding the numbers to.
        mNumbersList = arrayListOf()
        mNumber?.let {
            mNumbersList!!.add(it)

            // subtract the inputed number and add it to the list  till the inputed number reaches 1
            while (mNumber != 1) {
                mNumber = mNumber!! - 1
                mNumbersList!!.add(mNumber!!)
            }

        }
        //kotlin function that shuffles a list
        shuffle(mNumbersList)

        // using a listview with an adapter to display the numbers
        mAdapterNumbers = mNumbersList?.let { ArrayAdapter(this, android.R.layout.simple_list_item_1, it) }
        listNumbers.adapter = mAdapterNumbers
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