package com.example.sm_david_androidpemula


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sm_david_androidpemula.R
import com.example.sm_david_androidpemula.databinding.ActivityDetailAcademyBinding
import com.example.sm_david_androidpemula.kantincoding.Academy

class DetailAcademy : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAcademyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_academy)
        supportActionBar?.title = "Detail Data"
        val data = intent.getParcelableExtra<Academy>("DATA")

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDetailAcademyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Glide.with(this)
            .load(data?.photo)
            .apply(RequestOptions())
            .into(binding.imgDetailAcademy)
        binding.tvDetailRate.text = data?.rate
        binding.tvDetailNameAcademy.text = data?.name
        binding.tvDetailAcademy.text = data?.detail
        binding.tvDetailDeskripsi.text = data?.overview


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }
}