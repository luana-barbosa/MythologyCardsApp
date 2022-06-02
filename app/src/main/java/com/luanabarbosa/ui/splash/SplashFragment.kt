package com.luanabarbosa.ui.splash

import android.animation.Animator
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.luanabarbosa.cards.databinding.CardsSplashFragmentBinding

class SplashFragment : Fragment(), Animator.AnimatorListener{
    lateinit var binding: CardsSplashFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.animation.addAnimatorListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardsSplashFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onAnimationStart(animation: Animator?) {

    }

    override fun onAnimationEnd(animation: Animator?) {
        val uri = Uri.parse("app://HOME_SCREEN")
        findNavController().navigate(uri)
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationRepeat(animation: Animator?) {
    }
}
