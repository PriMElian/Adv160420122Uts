package com.example.adv160420122uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.adv160420122uts.R
import com.example.adv160420122uts.databinding.FragmentSignInBinding
import com.example.adv160420122uts.viewmodel.SignInViewModel


class SignInFragment : Fragment(), ButtonToSignUpClickListener, ButtonSignInClickListener, ButtonForgotPasswordClickListener {
    private lateinit var SignInViewModel: SignInViewModel
    private lateinit var dataBinding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_in, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentSignInBinding>(inflater,
            R.layout.fragment_sign_in, container, false)
        return dataBinding.root
    }

    override fun onButtonToSignUpClick(v: View) {
        val action = SignInFragmentDirections.actionSignUp()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonSignInClick(v: View) {
        val action = SignInFragmentDirections.actionHome()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonForgotPasswordClick(v: View) {

    }
}