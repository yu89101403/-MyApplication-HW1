package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        intent?.extras?.let{
            val value1 = it.getString("Key1")
            val value2 = it.getString("Key2")
            val sizeEditText = findViewById<EditText>(R.id.sizeEditText).text
            val colorEditText = findViewById<EditText>(R.id.colorEditText).text
            val button1 = findViewById<Button>(R.id.button1)
            button1.setOnClickListener {

                val bundle = Bundle()
                bundle.putString("Key1", value1)
                bundle.putString("Key2", value2)
                bundle.putString("Key3", sizeEditText.toString())
                bundle.putString("Key4", colorEditText.toString())
                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK,intent.putExtras(bundle))
                finish()

            }
        }
    }
}