package com.example.nearBy.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.architecturesampletwo.R
import com.example.architecturesampletwo.databinding.MainActivityLayoutBinding
import com.example.nearBy.data.local.database.NearByResponseModel
import com.example.nearBy.ui.UiModel.NetworkResponseState


class NearByActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityLayoutBinding
    private lateinit var viewModel: NearByActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity_layout)
        setContentView(binding.root)
        Init()
        initListener()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.myResponseFlow.collect {
                when (it) {
                    is NetworkResponseState.Loading -> {
                        //showProgress()
                    }
                    is NetworkResponseState.Success -> {
                        //hideProgress()
                        showSuccess(it.data as NearByResponseModel)
                    }
                    is NetworkResponseState.Failure -> {
                        //showApiError(it.e.message.toString())
                    }

                    else -> {

                    }
                }
            }
        }
    }

    private fun showSuccess(catResponse: NearByResponseModel) {
       // set data to ui
    }

    private fun initListener() {
        binding.btnSearch.setOnClickListener {
            viewModel.fetchPlaces(1233,1, "Mzg0OTc0Njl8MTcwMDgxMTg5NC44MDk2NjY5", 12.971599,77.594566, "12", "test"
            )
        }
    }

    private fun Init() {
        viewModel = ViewModelProvider(this)[NearByActivityViewModel::class.java]
    }
}