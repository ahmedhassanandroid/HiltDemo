package com.nextwo.hiltapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nextwo.hiltapp.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dishes.*
import javax.inject.Inject

@AndroidEntryPoint
class DishesFragment: Fragment() {

    private val dishesViewModel: DishesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dishes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dishesViewModel.textLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        btnOpenAgain.setOnClickListener {
            startActivity(Intent(requireActivity(), DishesActivity::class.java))
        }

        btnChangeFragment.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.mainFrameContainer, DishesFragment())
                ?.commit()
        }
    }
    override fun onResume() {
        super.onResume()
        dishesViewModel.getDishes()
    }
}