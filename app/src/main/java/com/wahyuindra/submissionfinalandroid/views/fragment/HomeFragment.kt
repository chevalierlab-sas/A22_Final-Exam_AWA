package com.wahyuindra.submissionfinalandroid.views.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.wahyuindra.submissionfinalandroid.R
import com.wahyuindra.submissionfinalandroid.adapter.HomeAdapter
import com.wahyuindra.submissionfinalandroid.databinding.FragmentHomeBinding
import com.wahyuindra.submissionfinalandroid.model.Aslab
import com.wahyuindra.submissionfinalandroid.utils.ARG_SECTIONS_NUMBER


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val arrayOfAslab = arrayListOf<Aslab>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(ARG_SECTIONS_NUMBER, 0)
        populateView()
    }

    @SuppressLint("Recycle")
    private fun populateView() {
        val photoArray = resources.obtainTypedArray(R.array.array_photo)
        val nameArray = resources.getStringArray(R.array.array_from)
        val roleArray = resources.getStringArray(R.array.array_position)

        for (i in nameArray.indices) arrayOfAslab.add(
            Aslab(
                image = photoArray.getResourceId(i, 0),
                name = nameArray[i],
                role = roleArray[i]
            )
        )
        homeAdapter = HomeAdapter(arrayOfAslab) {
            Snackbar.make(
                binding.root,
                "${it.name} | ${it.role}",
                Snackbar.LENGTH_SHORT,

            ).show()
        }
        with(binding.rvHome) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }
    }
}