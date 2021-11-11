package com.example.thirdparties.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thirdparties.R
import com.example.thirdparties.viewmodel.SoilConditionViewModel
import domain.models.SoilConditionLocalModel
import kotlinx.android.synthetic.main.fragment_soil_condition.*
import kotlinx.android.synthetic.main.fragment_soil_condition.view.*
import kotlinx.android.synthetic.main.recycler_view.*

class SoilConditionFragment: Fragment() {

    private lateinit var soilConditionViewModel: SoilConditionViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):View? {

        val view =  inflater.inflate(R.layout.fragment_soil_condition, container, false)

        soilConditionViewModel = ViewModelProvider(this).get(SoilConditionViewModel::class.java)

        view.add_button.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val id = number.text.toString()
        val area = area_size_field.text.toString()
        val lastAgriculture = last_agriculture_field.text.toString()
        val cropCapacity = crope_capacity_field.text.toString()

        if(inputCheck(id, area, lastAgriculture, cropCapacity)){
            val info =
                SoilConditionLocalModel(id.toLong(), area.toDouble(), lastAgriculture, cropCapacity.toInt())
            soilConditionViewModel.addInfo(info)
            Toast.makeText(requireContext(), "Successfully added to database", Toast.LENGTH_LONG).show()
            val action = SoilConditionFragmentDirections.actionSoilConditionFragment3ToListFragment()
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(id: String, area: String, lastAgriculture:String, cropCapacity:String):Boolean{
        return !(TextUtils.isEmpty(id)&&TextUtils.isEmpty(area)&&TextUtils.isEmpty(lastAgriculture)&&TextUtils.isEmpty(cropCapacity))
    }
}