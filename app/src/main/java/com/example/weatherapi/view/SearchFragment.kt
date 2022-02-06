package com.example.weatherapi.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapi.TAG
import com.example.weatherapi.databinding.SearchMenuBinding
import com.example.weatherapi.viewModel.WeatherViewModel

class SearchFragment :Fragment() {


    private var _binding: SearchMenuBinding? = null
    private val binding: SearchMenuBinding get() = _binding!!

    private lateinit var viewModel: WeatherViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[WeatherViewModel::class.java]
        with(binding) {


            lookupBtn.setOnClickListener{
                val bundle = Bundle()
//                viewModel.getCityName(it)

                Log.d(TAG,"This is ittttt --->  $it")
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
