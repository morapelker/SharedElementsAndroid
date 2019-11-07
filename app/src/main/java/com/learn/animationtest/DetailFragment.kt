package com.learn.animationtest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.detail_fragment.*


class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(scrollView)
        scrollView.viewTreeObserver.addOnScrollChangedListener(scrollChangeListener)
    }

    private val scrollChangeListener = ViewTreeObserver.OnScrollChangedListener {
        topBar.alpha = if (scrollView.scrollY < 736) {
            scrollView.scrollY.toFloat() / 736
        } else 1f
    }

    override fun onPause() {
        super.onPause()
        scrollView.viewTreeObserver.removeOnScrollChangedListener(scrollChangeListener)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
