package com.example.kotlin_tablelayout

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_tablelayout.databinding.ActivityTablelayoutBinding

class ActivityTable: AppCompatActivity() {
    private  lateinit  var dataBind: ActivityTablelayoutBinding
    private  lateinit var table:TableLayout
    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBind = ActivityTablelayoutBinding.inflate(layoutInflater)
        setContentView(dataBind.root)
        init()
    }
    private fun init(){
        dataBind.generateTable.setOnClickListener {
            count++
            addwidget()
        }
        dataBind.tableData.setOnClickListener { getTableData() }
        table = dataBind.tablelayout

    }

    //添加一行控件
    private fun addwidget(){
        var tb:TableLayout = dataBind.tablelayout
        var tr:TableRow = TableRow(this)
        tr.setBackgroundColor(Color.WHITE)
        var year = EditText(this)
        var cash = EditText(this)
        var time = EditText(this)

        year.setText("year:${count}")
        cash.setText("cash:${count}")
        time.setText("time:${count}")

        year.setOnClickListener {
            Toast.makeText(this, "点击${count}行第1列",Toast.LENGTH_LONG).show()
        }
        cash.setOnClickListener {
            Toast.makeText(this, "点击${count}行第2列",Toast.LENGTH_LONG).show()
        }
        time.setOnClickListener {
            Toast.makeText(this, "点击${count}行第3列",Toast.LENGTH_LONG).show()
        }
        tr.addView(year)
        tr.addView(cash)
        tr.addView(time)
        val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        tb.addView(tr, lp)
    }
    private fun getTableData(){
        val tb:TableLayout = dataBind.tablelayout
        Toast.makeText(this, "总行数:"+ tb.childCount, Toast.LENGTH_LONG)
        for(i in 0 until tb.childCount){
            val tr = tb.getChildAt(i)
            val tr1 = tr as TableRow
            val count = tr1.childCount
            var str:String=""
            for (j in 0 until count){
                val e = tr1.getChildAt(j)
                val e1 = e as EditText
                str += e1.text
            }
            println(str)
        }
    }
}