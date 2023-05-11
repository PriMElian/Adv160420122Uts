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
import com.example.adv160420122uts.viewmodel.MedicineListViewModel

class MedicineListFragment : Fragment() {
    private lateinit var medicineListViewModel: MedicineListViewModel
    private val medicineListAdapter = MedicineListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        medicineListViewModel = ViewModelProvider(this).get(MedicineListViewModel::class.java)
        medicineListViewModel.refresh()

        val recView = view?.findViewById<RecyclerView>(R.id.recViewMedicine)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = medicineListAdapter

        val refreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view?.findViewById<TextView>(R.id.txtErrorMedicine)
        val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadMedicine)

        refreshLayout?.setOnRefreshListener {
            recView?.visibility = View.GONE
            txtError?.visibility = ViewGroup.GONE
            progressLoad?.visibility = View.VISIBLE
            medicineListViewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        medicineListViewModel.medicineLD.observe(viewLifecycleOwner, Observer {
            medicineListAdapter.updateMedicineList(it)
        })

        medicineListViewModel.medicineLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtErrorMedicine)
            if (it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        medicineListViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadMedicine)
            val recView = view?.findViewById<RecyclerView>(R.id.recViewMedicine)
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