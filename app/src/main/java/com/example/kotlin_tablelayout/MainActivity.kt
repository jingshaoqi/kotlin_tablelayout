package com.example.kotlin_tablelayout


import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Timer
import java.util.TimerTask
import android.widget.Button
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.kotlin_tablelayout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit  var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        init()
    }
    private fun init(){
        val bt = findViewById<Button>(R.id.open_table)
        bt.setOnClickListener {
            val it = Intent(this, ActivityTable::class.java)
            this.startActivity(it)
        }
    }
}