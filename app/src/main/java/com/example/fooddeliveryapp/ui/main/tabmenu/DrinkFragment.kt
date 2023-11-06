package com.example.fooddeliveryapp.ui.main.tabmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.databinding.FragmentDrinkBinding
import com.example.fooddeliveryapp.ui.foodview.FoodRecyclerViewAdapter
import com.example.fooddeliveryapp.ui.main.viewmodel.DrinkViewModel
import com.example.fooddeliveryapp.ui.main.viewmodel.PizzaViewModel

class DrinkFragment : Fragment() {
    private lateinit var recyclerAdapter: FoodRecyclerViewAdapter

    private var _binding: FragmentDrinkBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinkBinding.inflate(inflater, container, false)
        initRecyclerView()
        initViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRecyclerView() {
        binding.drinkFragmentRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerAdapter = FoodRecyclerViewAdapter()
        binding.drinkFragmentRecyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel: DrinkViewModel = ViewModelProvider(this)[DrinkViewModel::class.java]
        viewModel.observer.observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerAdapter.setData(it)
            } else{
                Toast.makeText(this.requireContext(), "Ой, что-то пошло не так. Попробуйте позже.", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.makeApiCall()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}