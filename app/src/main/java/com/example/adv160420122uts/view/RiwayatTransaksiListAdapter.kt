package com.example.adv160420122uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420122uts.R
import com.example.adv160420122uts.model.RiwayatTransaksi
import com.example.adv160420122uts.util.loadImage

class RiwayatTransaksiListAdapter(val riwayatTransaksiList: ArrayList<RiwayatTransaksi>)
    :RecyclerView.Adapter<RiwayatTransaksiListAdapter.RiwayatTransaksiListViewHolder>() {

    class RiwayatTransaksiListViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatTransaksiListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.riwayat_transaksi_list_item, parent, false)

        return RiwayatTransaksiListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RiwayatTransaksiListViewHolder, position: Int) {
        val txtName = holder.view.findViewById<TextView>(R.id.txtNameRiwayatMedicine)
        txtName.text = riwayatTransaksiList[position].name

        val txtQuantity = holder.view.findViewById<TextView>(R.id.txtQuantityRiwayatMedicine)
        txtQuantity.text = riwayatTransaksiList[position].quantity

        val txtPrice = holder.view.findViewById<TextView>(R.id.txtPriceRiwayatMedicine)
        txtPrice.text = riwayatTransaksiList[position].price

        val imgView = holder.view.findViewById<ImageView>(R.id.imgViewRiwayatMedicine)
        imgView.loadImage(riwayatTransaksiList[position].photoUrl)
    }

    override fun getItemCount(): Int {
        return riwayatTransaksiList.size
    }

    fun updateRiwayatTransaksi(newRiwayatTransaksi: ArrayList<RiwayatTransaksi>) {
        riwayatTransaksiList.clear()
        riwayatTransaksiList.addAll(newRiwayatTransaksi)
        notifyDataSetChanged()
    }
}