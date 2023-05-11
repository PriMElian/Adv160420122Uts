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

class MedicineListViewModel(application: Application):
    AndroidViewModel(application) {

    //Object Observable
    val medicineLD = MutableLiveData<ArrayList<Medicine>>()
    val medicineLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        medicineLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/advnative/medicine.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Medicine>>() { }.type
                val result = Gson().fromJson<ArrayList<Medicine>>(it, sType)
                medicineLD.value = result
                loadingLD.value = false

                Log.d("showVolley", result.toString())
            },
            {
                Log.d("showVolley", it.toString())
                medicineLoadErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}