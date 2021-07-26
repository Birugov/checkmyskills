package ru.techcrat.checkmyskills.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.techcrat.checkmyskills.BaseApplication
import ru.techcrat.checkmyskills.R
import ru.techcrat.checkmyskills.adapters.DateRecyclerAdapter
import ru.techcrat.checkmyskills.databinding.FragmentDateBinding
import ru.techcrat.checkmyskills.di.components.DaggerAppComponent
import ru.techcrat.checkmyskills.viewmodels.DateViewModel
import ru.techcrat.checkmyskills.viewmodels.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DateFragment : Fragment(R.layout.fragment_date), DateRecyclerAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var dateAdapter: DateRecyclerAdapter
    private val dateViewModel: DateViewModel by viewModels {
        viewModelFactory
    }
    private val binding: FragmentDateBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.builder().application(context?.applicationContext as BaseApplication)
            .build().inject(this)
        dateViewModel.init()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dateAdapter = DateRecyclerAdapter(this)
        initRecycler()
        addDataSet()
    }

    private fun addDataSet() {
        dateViewModel.data.observe(viewLifecycleOwner) {
            dateAdapter.submitData(it)
        }
    }

    private fun initRecycler() {
        binding.dateRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dateAdapter
            postponeEnterTransition()
            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }
    }

    override fun onItemClick(position: Int) {

        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val today = sdf.format(Date())
        val date =
            binding.dateRv.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(
                R.id.date_elem_tv
            )

        if (date?.text == today.toString()) {
            DateFragmentDirections.actionDateFragmentToRateFragment2(
            ).let { directions ->
                findNavController().navigate(directions)
            }
        } else {
            Toast.makeText(
                context,
                "Sorry, but API doesn't provide rates of previous or future dates",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}