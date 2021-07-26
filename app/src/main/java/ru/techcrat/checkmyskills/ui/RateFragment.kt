package ru.techcrat.checkmyskills.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.techcrat.checkmyskills.BaseApplication
import ru.techcrat.checkmyskills.R
import ru.techcrat.checkmyskills.databinding.RateFragmentBinding
import ru.techcrat.checkmyskills.di.components.DaggerAppComponent
import ru.techcrat.checkmyskills.viewmodels.RateViewModel
import javax.inject.Inject


class RateFragment : Fragment(R.layout.rate_fragment) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel: RateViewModel by viewModels {
        viewModelFactory
    }
    private val binding: RateFragmentBinding by viewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.builder().application(context?.applicationContext as BaseApplication)
            .build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRates()
        setValues()
    }


    private fun setValues() {
        viewModel.dates.observe(viewLifecycleOwner) {
            binding.dollarTv.text = "$=${it[0]} "
            binding.euTv.text = "€=${it[1]}"

        }
    }

}