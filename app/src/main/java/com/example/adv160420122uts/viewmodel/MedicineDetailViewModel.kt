package com.example.adv160420122uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420122uts.model.Medicine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MedicineDetailViewModel(application: Application):
    AndroidViewModel(application) {
    val medicineLD = MutableLiveData<Medicine>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/advnative/medicineDetail.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Medicine>() { }.type
                val result = Gson().fromJson<Medicine>(it, sType)
                medicineLD.value = result
                Log.d("showVolley", result.toString())
            },
            {
                Log.d("showVolley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}