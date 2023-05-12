package com.example.adv160420122uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420122uts.R
import com.example.adv160420122uts.databinding.DoctorListItemBinding
import com.example.adv160420122uts.model.Doctor
import com.example.adv160420122uts.util.loadImage

class DoctorListAdapter(val doctorList:ArrayList<Doctor>)
    :RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>(), ButtonDoctorDetailClickListener {

    class DoctorViewHolder(var view: DoctorListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.doctor_list_item, parent, false)
        val view = DataBindingUtil.inflate<DoctorListItemBinding>(inflater,
            R.layout.doctor_list_item, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        /*val txtName = holder.view.findViewById<TextView>(R.id.txtNameDoctor)
        txtName.text = doctorList[position].name

        val txtType = holder.view.findViewById<TextView>(R.id.txtTypeDoctor)
        txtType.text = doctorList[position].type

        val btnPilih = holder.view.findViewById<Button>(R.id.btnPilihDoctor)
        btnPilih.setOnClickListener {
            val action = DoctorListFragmentDirections.actionDoctorDetail(doctorList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imgView = holder.view.findViewById<ImageView>(R.id.imgViewDoctor)
        imgView.loadImage(doctorList[position].photoUrl)*/

        holder.view.doctor = doctorList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    fun updateDoctorList(newDoctorList: ArrayList<Doctor>) {
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }

    override fun onButtonDoctorDetailClick(v: View) {
        val action = DoctorListFragmentDirections.actionDoctorDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}