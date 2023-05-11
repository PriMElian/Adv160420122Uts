package com.example.adv160420122uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420122uts.model.Doctor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoctorDetailViewModel(application: Application):
    AndroidViewModel(application) {
    val doctorLD = MutableLiveData<Doctor>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/advnative/doctorDetail.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Doctor>() { }.type
                val result = Gson().fromJson<Doctor>(it, sType)
                doctorLD.value = result
                Log.d("showVolley", result.toString())
            },
            {
                Log.d("showVolley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}