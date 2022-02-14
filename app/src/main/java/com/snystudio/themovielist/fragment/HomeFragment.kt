package com.snystudio.themovielist.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.aemerse.slider.ImageCarousel
import com.aemerse.slider.model.CarouselItem
import com.snystudio.themovielist.R
import com.snystudio.themovielist.databinding.FragmentHomeBinding
import com.snystudio.themovielist.model.DiscoverMovie
import com.snystudio.themovielist.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val movieViewModel by viewModel<MovieViewModel>()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.homefragment=this
        binding.carouselView.registerLifecycle(lifecycle)
        val list = mutableListOf<CarouselItem>()
        movieViewModel.data.observe(viewLifecycleOwner, Observer {
            for (i in it) {
                list.add(
                    CarouselItem(
                        imageUrl =i.backdrop_path,
                        caption = i.title
                    )
                )

            }
            Log.d("homeFragment", "onCreateView: "+list.get(0).imageUrl)
            binding.carouselView.setData(list)
        })
        return binding.root

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment HomeFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}

