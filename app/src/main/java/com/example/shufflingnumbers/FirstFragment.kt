package com.example.shufflingnumbers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    private lateinit var listNumbers: ListView
    private lateinit var digitInput: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting a reference to the listview xml file and creating a listview to hold the lists of numbers
        listNumbers = view.findViewById(R.id.list_numbers)
        // getting the edittext we are going to input our value into
        digitInput = view.findViewById(R.id.editText_input)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            // Converting the value in the edittext to int so we canuse it for math operations

            val stringValue: String = digitInput.text.toString()
            // the value of the inputed number in integer format
//            val originalNumber: Int = Integer.parseInt(stringValue)
            val originalNumber: Int = Integer.parseInt(digitInput.text.toString())



            // create a function to do the shuffling of numbers
            shuffleNumbers(originalNumber)


//          displaying the original inputed value
            Snackbar.make(
                    view, "Number inputed was: $originalNumber",
                    Snackbar.LENGTH_LONG
            )
                    .setAction("Action", null).show()

//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    private fun shuffleNumbers(number : Int) {

        //getting the number inputed to the edittext
        var mNumber = number
        // creating an emptylist we will be adding the numbers to.
        val mNumbersList = arrayListOf<Int>()
        mNumber?.let {
            mNumbersList!!.add(it)

            // subtract the inputed number and add it to the list  till the inputed number reaches 1
            while (mNumber != 1) {
                mNumber = mNumber!! - 1
                mNumbersList!!.add(mNumber!!)
            }

        }
        //kotlin function that shuffles a list
        mNumbersList.shuffle()

        // using a listview with an adapter to display the numbers
        val mAdapterNumbers = mNumbersList?.let { ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it) }
        listNumbers.adapter = mAdapterNumbers
    }


}