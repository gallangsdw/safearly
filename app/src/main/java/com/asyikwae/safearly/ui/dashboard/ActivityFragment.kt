package com.asyikwae.safearly.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.asyikwae.safearly.databinding.FragmentActivityBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class ActivityFragment : Fragment() {

    private lateinit var activityViewModel: ActivityViewModel
    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.bottomSheet).apply {
            peekHeight = 400
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        activityViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        val questionAdapter = QuestionAdapter()

        activityViewModel.text.observe(viewLifecycleOwner, {
            questionAdapter.setData(it)
        })

        with(binding.sheet.rvActivity) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = questionAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}