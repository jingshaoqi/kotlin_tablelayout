package com.example.kotlin_tablelayout

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_tablelayout.databinding.ActivityTablelayoutBinding

class ActivityTable: AppCompatActivity() {
    private  lateinit  var dataBind: ActivityTablelayoutBinding
    private  lateinit var table:TableLayout
    private lateinit var rg:RadioGroup
    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBind = ActivityTablelayoutBinding.inflate(layoutInflater)
        setContentView(dataBind.root)
        rg = RadioGroup(this)
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
        var seq = EditText(this)
        var dev_num = EditText(this)
        var dev_name = EditText(this)
        var dev_sel =  RadioButton(this)

        seq.setText("seq:${count}")
        dev_num.setText("devnum:${count}")
        dev_name.setText("devname:${count}")
        dev_sel.setText("选择：${count}")

        dev_sel.tag = "row_num_${count}"


        seq.setOnClickListener {
            Toast.makeText(this, "点击${count}行第1列",Toast.LENGTH_LONG).show()
        }
        dev_num.setOnClickListener {
            Toast.makeText(this, "点击${count}行第2列",Toast.LENGTH_LONG).show()
        }
        dev_name.setOnClickListener {
            Toast.makeText(this, "点击${count}行第3列",Toast.LENGTH_LONG).show()
        }
        dev_sel.setOnClickListener {
            Toast.makeText(this, "点击${count}行第4列",Toast.LENGTH_LONG).show()
            var tag = it.tag
            val tb:TableLayout = dataBind.tablelayout
            for(i in 0 until tb.childCount){
                val tr = tb.getChildAt(i) as TableRow
                val rb = tr.getChildAt(3) as RadioButton
                if(rb.tag != it.tag){
                    rb.isChecked = false
                }
            }
        }
        tr.addView(seq)
        tr.addView(dev_num)
        tr.addView(dev_name)
        tr.addView(dev_sel)
        //tr.dividerDrawable = "middle|beginning|end"
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