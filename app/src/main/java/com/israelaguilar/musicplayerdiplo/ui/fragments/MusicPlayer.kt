package com.israelaguilar.musicplayerdiplo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.israelaguilar.musicplayerdiplo.R
import com.israelaguilar.musicplayerdiplo.databinding.FragmentMusicListBinding
import com.israelaguilar.musicplayerdiplo.databinding.FragmentMusicPlayerBinding


class MusicPlayer : Fragment() {

    private var _binding: FragmentMusicPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}