package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText).text
        val sexEditText = findViewById<EditText>(R.id.sexEditText).text

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            val bundle = Bundle()
            bundle.putString("Key1", nameEditText.toString())
            bundle.putString("Key2", sexEditText.toString())
            findViewById<EditText>(R.id.nameEditText).visibility = View.INVISIBLE
            findViewById<EditText>(R.id.sexEditText).visibility = View.INVISIBLE
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let{
            if(requestCode == 1 && resultCode == Activity.RESULT_OK)
            {

                findViewById<TextView>(R.id.textView5).text =
                    "姓名:${it.getString("Key1")}\n\n"+
                    "性別:${it.getString("Key2")}\n\n"+
                    "尺寸:${it.getString("Key3")}\n\n"+
                    "顏色:${it.getString("Key4")}\n\n"
            }
        }
    }
}
