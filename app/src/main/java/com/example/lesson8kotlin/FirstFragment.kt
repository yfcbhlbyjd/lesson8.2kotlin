package com.example.lesson8kotlin


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lesson8kotlin.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val alertDialog = AlertDialog.Builder(requireContext())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireActivity())
            .load("https://mobimg.b-cdn.net/v3/fetch/08/086e706fc77fef16222c4f86e8c39da1.jpg")
            .centerCrop().into(binding.iv)
        binding.iv.setOnClickListener() {

            alertDialog.setTitle("It make empty?")
            alertDialog.setPositiveButton("Yes") { dialog, _ ->
                Glide.with(requireActivity())
                    .load("https://mobimg.b-cdn.net/v3/fetch/08/086e706fc77fef16222c4f86e8c39da1.jpeg").centerCrop()
                    .into(binding.iv)
                    alertDialog.setNegativeButton("No") { diolog, _ ->
                        diolog.dismiss()
                    }
                    alertDialog.create().show()
                }
            }
            alertDialog.setNegativeButton("No") { diolog, _ ->
                diolog.dismiss()
            }
            alertDialog.create().show()

        }
    }
}