package com.example.gonavi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.gonavi.R
import com.example.gonavi.databinding.ActivityMainBinding
import com.example.gonavi.helper.showToast
import com.example.gonavi.helper.visibility
import com.example.gonavi.views.models.ApiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val mergeAdapter: MergeRequestAdapter by lazy { MergeRequestAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getAllClosedMR()
        observeDataChange()
        setAdapter()
    }

    private fun observeDataChange() {
        viewModel.fetchClosedMRStatus.observe(this) { state ->
            when (state) {
                is ApiState.Success -> mergeAdapter.updateData(state.data)
                is ApiState.Loading -> binding.progress.visibility(state.isLoading)
                is ApiState.Failure -> state.failure.showToast(this)
            }
        }
    }

    private fun setAdapter() {
        binding.mergeRequestRecycler.adapter = mergeAdapter
    }
}