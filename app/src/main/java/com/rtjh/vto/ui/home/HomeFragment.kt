package com.rtjh.vto.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bin.david.form.core.SmartTable
import com.rtjh.vto.R
import com.rtjh.vto.adapter.TableAdapter
import com.rtjh.vto.databinding.FragmentHomeBinding
import com.rtjh.vto.model.SchedulingInfoDataModel

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val smartTable: SmartTable<SchedulingInfoDataModel> = binding.schedulingInfoLl.findViewById(
            R.id.scheduling_info_table)
        val tableAdapter = TableAdapter(binding.root.context)

        tableAdapter.setupTable(smartTable)
        return binding.root
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}