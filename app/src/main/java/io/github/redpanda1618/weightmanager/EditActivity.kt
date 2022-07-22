package io.github.redpanda1618.weightmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.runBlocking


class EditActivity : AppCompatActivity() {
    private companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var textViewData: TextView
        @SuppressLint("StaticFieldLeak")
        lateinit var tableLayout: TableLayout
        lateinit var dao : UserDao
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        tableLayout = findViewById(R.id.tableLayoutData)
        showTable()
    }

    @SuppressLint("SetTextI18n")
    private fun showTable() {
        val textElement1 = TextView(this)
        val textElement2 = TextView(this)
        val textElement3 = TextView(this)
        val textElement4 = TextView(this)
        var p: Pair<ArrayList<User>, Int>
        runBlocking {
            p = getData()
        }
        val data = p.first
        val size = p.second - 1
        for (i in (-1..(size))){
            val tableRow = TableRow(this)
            tableRow.setLayoutParams(
                TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
            )
            tableRow.setGravity(Gravity.LEFT)
            tableRow.setPadding(5, 15, 0, 15)
            tableRow.id = i + 1
            if (i > -1) {
                val row: User = data[i]
                textElement1.text = row.date
                textElement2.text = row.weight.toString()
                textElement3.text = row.muscle.toString()
                textElement4.text = row.fat.toString()
                tableRow.addView(textElement1)
                tableRow.addView(textElement2)
                tableRow.addView(textElement3)
                tableRow.addView(textElement4)
                tableLayout.addView(tableRow)
            } else {
                textElement1.text = "@string/date"
                textElement2.text = "@string/weight"
                textElement3.text = "@string/muscle"
                textElement4.text = "@string/fat"
                tableRow.addView(textElement1)
                tableRow.addView(textElement2)
                tableRow.addView(textElement3)
                tableRow.addView(textElement4)
                tableLayout.addView(tableRow)
            }

        }
    }

    private fun getData(): Pair<ArrayList<User>, Int>{
        dao = MainActivity().getDao()
        var data: ArrayList<User> = ArrayList()
        val users = dao.getAll()
        val _size = dao.size()
        users.forEach { user ->
            data.add(user)
        }
        return Pair(data, _size)
    }

    fun clearData(view: View) {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title)
            .setMessage(R.string.dialog_del_message)
            .setPositiveButton(R.string.dialog_ok) { dialog, which ->
                // OK の時は削除処理
                // ここにデータ削除処理を入れる
                runBlocking {
                    dao.deleteAll()
                }
                onStart()
            }
            // Cancelの時は何もしない
            .setNegativeButton(R.string.dialog_cancel) { dialog, which ->

            }
            .show()
    }
}