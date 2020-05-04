package com.learn.app.kotlinrapidtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_menu_booking.*
import kotlinx.android.synthetic.main.activity_menu_rumah_sakit.*
import kotlinx.android.synthetic.main.list_antrian.*
import org.json.JSONArray

class MenuBooking : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_booking)

        val context = this

        kembali_booking.setOnClickListener {
            val kembali = Intent(context, DashboardActivity::class.java)
            startActivity(kembali)
        }

        var nama = intent.getStringExtra("nama_rs")

        var book_rs:TextView = findViewById(R.id.book_nama_rs)

        book_rs.text = nama.toString()

        btn_booking.setOnClickListener {
            var input_nama_rs:String = book_nama_rs.text.toString()
            var input_nama_pasien:String = book_nama.text.toString()
            var input_jadwal:String = book_jadwal.text.toString()
            var input_keluhan:String = book_keluhan.text.toString()
            var status:String = book_status.text.toString()

            inputbooking(input_nama_pasien, input_nama_rs, input_jadwal, input_keluhan, status)

            val intent = Intent(context, MenuHasil::class.java)
            intent.putExtra("nama_pasien", "1")
            intent.putExtra("nama_rs", "2")
            intent.putExtra("jadwalpilihan", "3")
            startActivity(intent)
        }

    }

    fun inputbooking(data1:String, data2:String, data3:String, data4:String, data5:String){
        AndroidNetworking.post("http://192.168.0.7/api-rapidtest/antrian/create.antrian.php")
            .addBodyParameter("nama_pasien", data1)
            .addBodyParameter("nama_rs", data2)
            .addBodyParameter("jadwalpilihan", data3)
            .addBodyParameter("keluhan", data4)
            .addBodyParameter("Status", data5)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }

}
