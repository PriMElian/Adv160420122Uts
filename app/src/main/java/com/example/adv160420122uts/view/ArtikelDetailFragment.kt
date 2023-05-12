package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420122uts.R
import com.example.adv160420122uts.databinding.FragmentArtikelDetailBinding
import com.example.adv160420122uts.util.loadImage
import com.example.adv160420122uts.viewmodel.ArtikelDetailViewModel

class ArtikelDetailFragment : Fragment() {
    private lateinit var artikelDetailViewModel: ArtikelDetailViewModel
    private lateinit var dataBinding: FragmentArtikelDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_artikel_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentArtikelDetailBinding>(inflater,
            R.layout.fragment_artikel_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = ArtikelDetailFragmentArgs.fromBundle(requireArguments()).arikelId
        artikelDetailViewModel = ViewModelProvider(this).get(ArtikelDetailViewModel::class.java)
        artikelDetailViewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        /*artikelDetailViewModel.artikelLD.observe(viewLifecycleOwner, Observer { artikelLD->
            val txtJudul = view?.findViewById<TextView>(R.id.txtJudulArtikelDetail)
            val txtIsi = view?.findViewById<TextView>(R.id.txtIsiDetail)

            txtJudul?.text = artikelLD.judul
            txtIsi?.text = artikelLD.isi
        })*/

        artikelDetailViewModel.artikelLD.observe(viewLifecycleOwner, Observer {
            dataBinding.artikel = it
        })
    }
}