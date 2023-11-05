package com.example.test.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.FragmentProfileBinding
import com.example.test.presentation.menu.BannersAdapter
import com.example.test.presentation.menu.MenuAdapter
import com.example.test.presentation.menu.MenuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {

    private lateinit var bannersAdapter: BannersAdapter
    private lateinit var menuAdapter: MenuAdapter

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val menuViewModel: MenuViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createAdapters()

        menuViewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        show()
    }

    private fun createAdapters() {
        bannersAdapter = BannersAdapter()
        menuAdapter = MenuAdapter()
    }

    private fun show() {
        attachObservers()

        applyAdapters()
    }

    private fun attachObservers() {
        menuViewModel.banners.observe(viewLifecycleOwner) { banners ->
            bannersAdapter.differ.submitList(banners)
        }

        menuViewModel.menu.observe(viewLifecycleOwner) { menu ->
            menuAdapter.differ.submitList(menu)
        }
    }

    private fun applyAdapters() {
        binding.rvBanners.apply {
            adapter = bannersAdapter
        }

        binding.rvMenu.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = menuAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}