package com.example.adv160420122uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420122uts.R
import com.example.adv160420122uts.model.Medicine
import com.example.adv160420122uts.util.loadImage

class MedicineListAdapter(val medicineList:ArrayList<Medicine>)
    :RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {

    class MedicineViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.medicine_list_item, parent, false)

        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val txtName = holder.view.findViewById<TextView>(R.id.txtNameMedicine)
        txtName.text = medicineList[position].name

        val txtQuantity = holder.view.findViewById<TextView>(R.id.txtQuantityMedicine)
        txtQuantity.text = medicineList[position].quantity

        val txtPrice = holder.view.findViewById<TextView>(R.id.txtPriceMedicine)
        txtPrice.text = medicineList[position].price

        val btnPilih = holder.view.findViewById<Button>(R.id.btnPilihMedicine)
        btnPilih.setOnClickListener {
            val action = MedicineListFragmentDirections.actionMedicineDetail(medicineList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imgView = holder.view.findViewById<ImageView>(R.id.imgViewMedicine)
        imgView.loadImage(medicineList[position].photoUrl)
    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

    fun updateMedicineList(newMedicineList: ArrayList<Medicine>) {
        medicineList.clear()
        medicineList.addAll(newMedicineList)
        notifyDataSetChanged()
    }

}