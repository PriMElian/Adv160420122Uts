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
import com.example.adv160420122uts.viewmodel.DoctorListViewModel

class DoctorListFragment : Fragment() {
    private lateinit var doctorListViewModel: DoctorListViewModel
    private val doctorListAdapter = DoctorListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        doctorListViewModel = ViewModelProvider(this).get(DoctorListViewModel::class.java)
        doctorListViewModel.refresh()

        val recView = view?.findViewById<RecyclerView>(R.id.recViewDoctor)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = doctorListAdapter

        val refreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view?.findViewById<TextView>(R.id.txtErrorDoctor)
        val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadDoctor)

        refreshLayout?.setOnRefreshListener {
            recView?.visibility = View.GONE
            txtError?.visibility = View.GONE
            progressLoad?.visibility = View.VISIBLE
            doctorListViewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        doctorListViewModel.doctorsLD.observe(viewLifecycleOwner, Observer {
            doctorListAdapter.updateDoctorList(it)
        })

        doctorListViewModel.doctorsLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtErrorDoctor)
            if (it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        doctorListViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadDoctor)
            val recView = view?.findViewById<RecyclerView>(R.id.recViewDoctor)
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