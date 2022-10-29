package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.btnOk);
        val txtEdit:EditText = findViewById(R.id.ednum);
        val txtView:TextView = findViewById(R.id.resultTV);

        var flag:String = "Jordan";
        val spinner:Spinner = findViewById(R.id.spinner);
        var options = arrayOf("Jordan","KSA","Brazil");

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2);
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{view->
            var price:Double = txtEdit.text.toString().toDouble();

            when(flag){
                "Jordan"-> txtView.text = ComputeTax(0.16,price).toString();
                "KSA"-> txtView.text = ComputeTax(0.15,price).toString();
                "Brazil"-> txtView.text = ComputeTax(0.17,price).toString();

            }
        }

    }
}

public fun ComputeTax(taxR:Double,price:Double):Double{
    return taxR*price;
}