package org.ieselcaminas.juan.appproject.Principal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import org.ieselcaminas.juan.appproject.R
import org.ieselcaminas.juan.appproject.databinding.PantallaPrincipalBinding
import androidx.lifecycle.Observer

/**
 * A simple [Fragment] subclass.
 */
class PantallaPrincipal : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {        // Inflate the layout for this fragment

        val binding: PantallaPrincipalBinding = DataBindingUtil.inflate(
            inflater, R.layout.pantalla_principal, container, false)

        val pantallaPrincipalViewModel = PantallaPrincipalViewModel()

        val adapter = PlacesListAdapter()

        binding.placesList.adapter = adapter

        pantallaPrincipalViewModel.placesLiveData.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)
            }
        })



        return binding.root

    }


}
