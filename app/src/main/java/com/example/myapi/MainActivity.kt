package com.example.myapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapi.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val apiUrl = "http://api.weatherapi.com/v1/current." +
            "json?key=159d40268ea744789e993117230510&q=Tashkent&aqi=no"

    lateinit var degreeText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        degreeText = findViewById(R.id.degree)

        Log.d("MainActivity", "current")

        val requestQueue = Volley.newRequestQueue(this)

        val request = JsonObjectRequest(apiUrl,
            object : Response.Listener<JSONObject>{
                override fun onResponse(response: JSONObject?) {
                    var current = response?.getJSONObject("current")
                    var tempC = current?.getDouble("temp_c")
                    degreeText.text = "tempC.toString()"
                    Log.d("MainActivity", current.toString())
                    Log.d("tyui", "fun worked")

                }

            },
            object : Response.ErrorListener{
                override fun onErrorResponse(error: VolleyError?) {
                    Log.d("tyu", "error")

                }

            })

        requestQueue.add(request)


    }
}