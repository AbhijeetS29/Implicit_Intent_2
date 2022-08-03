package com.abhijeet.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.abhijeet.implicit_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var etphone:EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


         binding.button.setOnClickListener {
             val phoneNumber=binding.etphone.text.toString().trim()
            var dialIntent = Intent(Intent.ACTION_DIAL)
             dialIntent.data= Uri.parse("tel:$phoneNumber")
                startActivity(dialIntent)
        }
        binding.button2.setOnClickListener {
            val share =Intent(Intent.ACTION_VIEW)
            share.setData(Uri.parse("https://www.youtube.com"))
            startActivity(share)
        }
        binding.button3.setOnClickListener {
            val Email=binding.etemail.text.toString().trim()
            val emailIntent=Intent(Intent.ACTION_SENDTO)
            emailIntent.data= Uri.parse("mailto:$Email")
            startActivity(emailIntent)
        }
        binding.button4.setOnClickListener {
            val Phonenumber=binding.etphonesms.text.toString().trim()
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.data= Uri.parse("sms:$Phonenumber")
            startActivity(smsIntent)
        }
    }
}