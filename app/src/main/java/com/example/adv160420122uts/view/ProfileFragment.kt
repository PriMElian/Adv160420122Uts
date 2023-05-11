package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.adv160420122uts.R
import com.example.adv160420122uts.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = 1
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileViewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        profileViewModel.profileLD.observe(viewLifecycleOwner, Observer {
            val txtname = view?.findViewById<TextView>(R.id.txtNameProfile)
            val txtNoTelp = view?.findViewById<TextView>(R.id.txtNoTelp)
            val btnRiwayat = view?.findViewById<Button>(R.id.btnRiwayat)

            //txtname?.text = "Elian"
            //txtNoTelp?.text = "081345678342"

            btnRiwayat?.setOnClickListener {
                val action = ProfileFragmentDirections.actionRiwayatTransaksi(id = it.id)
                Navigation.findNavController(it).navigate(action)
            }
        })
    }
}