package com.wahyuindra.submissionfinalandroid.views.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.wahyuindra.submissionfinalandroid.R
import com.wahyuindra.submissionfinalandroid.adapter.MessageAdapter
import com.wahyuindra.submissionfinalandroid.databinding.FragmentHomeBinding
import com.wahyuindra.submissionfinalandroid.databinding.FragmentMessageBinding
import com.wahyuindra.submissionfinalandroid.model.Aslab
import com.wahyuindra.submissionfinalandroid.utils.ARG_SECTIONS_NUMBER

class MessageFragment : Fragment() {

    private lateinit var binding : FragmentMessageBinding
    private lateinit var messageAdapter: MessageAdapter

    private val arrayOfAslab = arrayListOf<Aslab>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayPopulateView()
    }

    @SuppressLint("Recycle")
    private fun displayPopulateView() {
        val photoArray = resources.obtainTypedArray(R.array.array_photo)
        val nameArray = resources.getStringArray(R.array.array_from)
        val messageArray = resources.getStringArray(R.array.array_messages)

        for (i in nameArray.indices) arrayOfAslab.add(
            Aslab(
                image = photoArray.getResourceId(i, 0),
                name = nameArray[i],
                message = messageArray[i]
            )
        )

        messageAdapter = MessageAdapter(arrayOfAslab) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Message from ${it.name}")
                .setMessage(it.message)
                .setCancelable(true)
                .show()
        }

        with(binding.rvMessage) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = messageAdapter
        }
    }
}