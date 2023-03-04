package com.example.sm_david_androidpemula

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.sm_david_androidpemula.databinding.ActivityMainBinding

class About : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "Profile"


        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        val btnToLinkedin:Button = findViewById(R.id.btn_to_linkedin)
        btnToLinkedin.setOnClickListener(this)
        val btnToInstagram:Button = findViewById(R.id.btn_to_instagram)
        btnToInstagram.setOnClickListener(this)
        val btnToGithub:Button = findViewById(R.id.btn_to_github)
        btnToGithub.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_to_linkedin -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/davidnasrulloh/"))
                startActivity(intent)
            }
            R.id.btn_to_instagram -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/davidnasrulloh_/"))
                startActivity(intent)
            }
            R.id.btn_to_github -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/davidnasrulloh"))
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }


}

