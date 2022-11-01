package com.myproject.petapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.myproject.petapp.MyListAdapter
import com.myproject.petapp.R
import com.myproject.petapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        navController=findNavController()
       // (activity as staffexplore?)?.setActionBarTitle("Home")
        val items = arrayOf<String>(
            "Pet Info",
            "Request Pet Images",
            "Pet Medial Conditions"

        )
        val imageId = arrayOf<Int>(
            R.drawable.owner,
            R.drawable.dog,
            R.drawable.veterinary,



        )
        val myListAdapter = MyListAdapter(requireActivity(), items, imageId)
        binding.listView.adapter = myListAdapter
        binding.listView.setOnItemClickListener(){ adapterView, view, position, id ->
            when(position)
            {

                0-> {


                }
                1-> {



                }
                2->{

                }
                3->{

                }

            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}