package com.example.adv160420122uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420122uts.R
import com.example.adv160420122uts.databinding.ArtikelListItemBinding
import com.example.adv160420122uts.model.Artikel

class ArtikelListAdapter(val artikelList:ArrayList<Artikel>)
    : RecyclerView.Adapter<ArtikelListAdapter.ArtikelViewHolder>(), ButtonArtikelDetailClickListener {

    class ArtikelViewHolder(var view: ArtikelListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ArtikelListItemBinding>(inflater,
            R.layout.artikel_list_item, parent, false)
        return ArtikelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        holder.view.artikel = artikelList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return artikelList.size
    }

    fun updateArtikelList(newArtikelList: ArrayList<Artikel>) {
        artikelList.clear()
        artikelList.addAll(newArtikelList)
        notifyDataSetChanged()
    }

    override fun onButtonArtikelDetailClick(v: View) {
        val action = HomeFragmentDirections.actionArtikelDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}