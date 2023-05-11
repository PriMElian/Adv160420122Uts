package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420122uts.R
import com.example.adv160420122uts.util.loadImage
import com.example.adv160420122uts.viewmodel.MedicineDetailViewModel

class MedicineDetailFragment : Fragment() {
    private lateinit var medicineDetailViewModel: MedicineDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = MedicineDetailFragmentArgs.fromBundle(requireArguments()).medicineId
        medicineDetailViewModel = ViewModelProvider(this).get(MedicineDetailViewModel::class.java)
        medicineDetailViewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        medicineDetailViewModel.medicineLD.observe(viewLifecycleOwner, Observer { medicineLD->
            val txtName = view?.findViewById<TextView>(R.id.txtNameMedicineDetail)
            val txtQuantity = view?.findViewById<TextView>(R.id.txtQuantityMedicineDetail)
            val txtPrice = view?.findViewById<TextView>(R.id.txtPriceMedicineDetail)
            val txtDescription = view?.findViewById<TextView>(R.id.txtDescription)
            val imgView = view?.findViewById<ImageView>(R.id.imgViewMedicineDetail)

            val btnAddToCart = view?.findViewById<Button>(R.id.btnAddToCart)

            txtName?.text = medicineLD.name
            txtQuantity?.text = medicineLD.quantity
            txtPrice?.text = medicineLD.price
            txtDescription?.text = medicineLD.description
            imgView?.loadImage(medicineLD.photoUrl)


            btnAddToCart?.setOnClickListener {
                Toast.makeText(activity, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            }
        })
    }
}