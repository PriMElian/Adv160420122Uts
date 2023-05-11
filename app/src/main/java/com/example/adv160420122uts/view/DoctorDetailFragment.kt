package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420122uts.R
import com.example.adv160420122uts.util.loadImage
import com.example.adv160420122uts.viewmodel.DoctorDetailViewModel

class DoctorDetailFragment : Fragment() {
    private lateinit var doctorDetailViewModel: DoctorDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = DoctorDetailFragmentArgs.fromBundle(requireArguments()).doctorId
        doctorDetailViewModel = ViewModelProvider(this).get(DoctorDetailViewModel::class.java)
        doctorDetailViewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        doctorDetailViewModel.doctorLD.observe(viewLifecycleOwner, Observer { doctorLD->
            val txtName = view?.findViewById<TextView>(R.id.txtNameDoctorDetail)
            val txtType = view?.findViewById<TextView>(R.id.txtTypeDoctorDetail)
            val txtExp = view?.findViewById<TextView>(R.id.txtExpDoctorDetail)
            val txtLike = view?.findViewById<TextView>(R.id.txtLikeDoctorDetail)
            val imgView = view?.findViewById<ImageView>(R.id.imgViewDoctorDetail)
            val txtJadwal = view?.findViewById<TextView>(R.id.txtJadwal)

            txtName?.text = "Name: " + doctorLD.name
            txtType?.text = "Dokter: " + doctorLD.type
            txtExp?.text = "Pengalaman: " + doctorLD.experience.toString() + " tahun"
            txtLike?.text = "Likes: " + doctorLD.like.toString() + " like"
            imgView?.loadImage(doctorLD.photoUrl)
            txtJadwal?.text = doctorLD.jadwal
        })
    }
}