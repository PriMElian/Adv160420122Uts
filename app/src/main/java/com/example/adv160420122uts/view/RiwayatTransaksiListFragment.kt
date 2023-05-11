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
import com.example.adv160420122uts.viewmodel.RiwayatTransaksiViewModel

class RiwayatTransaksiListFragment : Fragment() {
    private lateinit var riwayatTransaksiViewModel: RiwayatTransaksiViewModel
    private val riwayatTransaksiListAdapter = RiwayatTransaksiListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat_transaksi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        riwayatTransaksiViewModel = ViewModelProvider(this).get(RiwayatTransaksiViewModel::class.java)
        riwayatTransaksiViewModel.refresh()

        val recView = view?.findViewById<RecyclerView>(R.id.recViewRiwayat)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = riwayatTransaksiListAdapter

        val refreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view?.findViewById<TextView>(R.id.txtErrorRiwayat)
        val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadRiwayat)

        refreshLayout?.setOnRefreshListener {
            recView?.visibility = View.GONE
            txtError?.visibility = View.GONE
            progressLoad?.visibility = View.VISIBLE
            riwayatTransaksiViewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        riwayatTransaksiViewModel.riwayatTransaksiLD.observe(viewLifecycleOwner, Observer {
            riwayatTransaksiListAdapter.updateRiwayatTransaksi(it)
        })

        riwayatTransaksiViewModel.riwayatTransaksiLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtErrorRiwayat)
            if (it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        riwayatTransaksiViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadRiwayat)
            val recView = view?.findViewById<RecyclerView>(R.id.recViewRiwayat)
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