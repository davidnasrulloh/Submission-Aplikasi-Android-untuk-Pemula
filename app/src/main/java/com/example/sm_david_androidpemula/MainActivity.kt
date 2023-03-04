package com.example.sm_david_androidpemula

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sm_david_androidpemula.databinding.ActivityMainBinding
import com.example.sm_david_androidpemula.kantincoding.Academy
import com.example.sm_david_androidpemula.kantincoding.AcademyAdapter
import com.example.sm_david_androidpemula.kantincoding.AcademyData

class MainActivity : AppCompatActivity() {

    private lateinit var rvAcademy: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<Academy> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Kantin Coding"

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHelloWord.text = "Bismillah Gassss !!!"

        rvAcademy = findViewById(R.id.rv_academy)
        rvAcademy.setHasFixedSize(true)

        list.addAll(AcademyData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList(){
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvAcademy.layoutManager = GridLayoutManager(this, 2)
        } else{
            rvAcademy.layoutManager = LinearLayoutManager(this)
        }
        val academyAdapter = AcademyAdapter(list)
        rvAcademy.adapter = academyAdapter

        //kirim data
        academyAdapter.setOnItemClickCallback(object : AcademyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Academy) {
                val intentToDetail = Intent(this@MainActivity, DetailAcademy::class.java)

                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, About::class.java)
                startActivity(intent)
            }
            R.id.action_list ->{
                rvAcademy.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvAcademy.layoutManager = GridLayoutManager(this, 2)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}