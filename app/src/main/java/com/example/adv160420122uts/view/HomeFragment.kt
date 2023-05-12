package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.adv160420122uts.R
import com.example.adv160420122uts.viewmodel.ArtikelListViewModel
import com.example.adv160420122uts.viewmodel.DoctorListViewModel

class HomeFragment : Fragment() {
    private lateinit var artikelListViewModel: ArtikelListViewModel
    private val artikelListAdapter = ArtikelListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        artikelListViewModel = ViewModelProvider(this).get(ArtikelListViewModel::class.java)
        artikelListViewModel.refresh()

        val recView = view?.findViewById<RecyclerView>(R.id.recViewArtikel)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = artikelListAdapter

        val refreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view?.findViewById<TextView>(R.id.txtErrorArtikel)
        val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadArtikel)

        refreshLayout?.setOnRefreshListener {
            recView?.visibility = View.GONE
            txtError?.visibility = View.GONE
            progressLoad?.visibility = View.VISIBLE
            artikelListViewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        artikelListViewModel.artikelLD.observe(viewLifecycleOwner, Observer {
            artikelListAdapter.updateArtikelList(it)
        })

        artikelListViewModel.artikelLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtErrorArtikel)
            if (it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        artikelListViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadArtikel)
            val recView = view?.findViewById<RecyclerView>(R.id.recViewArtikel)
            if (it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })
    }
}