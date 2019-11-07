package com.learn.animationtest

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import kotlinx.android.synthetic.main.master_fragment.*


class MasterFragment : Fragment() {

    private lateinit var viewModel: MasterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.master_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                imageView to "imageView"
            )
            navigate(R.id.action_masterFragment_to_detailFragment, extras)
        }


        imageView.setOnClickListener {
            println("clicked")
            val intent = Intent(activity, ModalActivity::class.java)
//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity ?: return@setOnClickListener, imageView, "imageView")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity ?: return@setOnClickListener, label, "text")
            startActivity(intent, options.toBundle())
//            startActivity(intent)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MasterViewModel::class.java)
    }

}
