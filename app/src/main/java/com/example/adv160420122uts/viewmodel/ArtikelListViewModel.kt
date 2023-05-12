package com.example.adv160420122uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420122uts.model.Artikel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ArtikelListViewModel(application: Application):
    AndroidViewModel(application) {

    //Object Observable
    val artikelLD = MutableLiveData<ArrayList<Artikel>>()
    val artikelLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        artikelLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/advnative/artikel.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Artikel>>() { }.type
                val result = Gson().fromJson<ArrayList<Artikel>>(it, sType)
                artikelLD.value = result
                loadingLD.value =false

                Log.d("showVolley", result.toString())
            },
            {
                Log.d("showVolley", it.toString())
                artikelLoadErrorLD.value = true
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