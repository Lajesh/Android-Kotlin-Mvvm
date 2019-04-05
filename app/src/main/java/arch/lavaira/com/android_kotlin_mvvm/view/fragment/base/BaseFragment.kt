package arch.lavaira.com.android_kotlin_mvvm.view.fragment.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arch.lavaira.com.android_kotlin_mvvm.di.Injectable
import arch.lavaira.com.android_kotlin_mvvm.view.activity.base.BaseActivity
import arch.lavaira.com.android_kotlin_mvvm.view.listeners.BackButtonHandlerListener
import arch.lavaira.com.android_kotlin_mvvm.view.listeners.BackPressListener
import arch.lavaira.com.android_kotlin_mvvm.viewmodel.BaseViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/****
 * Parent for all the UI fragments. All the common things to be kept here
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
abstract class BaseFragment<V : ViewModel, D : ViewDataBinding> : Fragment(), Injectable, BackPressListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V

    protected lateinit var dataBinding: D

    //protected lateinit var sharedViewModel: SharedViewModel

    private var backButtonHandler: BackButtonHandlerListener? = null

    @get:LayoutRes
    protected abstract val layoutRes: Int

    abstract val bindingVariable: Int

    protected abstract fun getViewModel(): Class<V>

    abstract fun getTitle(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

       // sharedViewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        dataBinding.setLifecycleOwner(this)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.setVariable(bindingVariable, viewModel)
        dataBinding.executePendingBindings()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setTitle()

        //setSharedViewModel()

        observeResponse()

        observeLoadingStatus()
    }


    /**
     * Method which sets the title of the view
     */
    private fun setTitle() {
        activity?.let {
            when (it) {
                is BaseActivity<*, *> ->
                    it.setTitle(getTitle())
            }
        }
    }


    /**
     * Method which indicates if the fragment has header
     * Default (true): considering all fragment has header
     */
    open fun hasHeader(): Boolean {
        return true
    }

    /**
     * Method which sets the sharedview to baseviewmodel
     */
//    private fun setSharedViewModel() {
//        (viewModel as BaseViewModel<*>).sharedViewModel = sharedViewModel
//    }

    /**
     * Method to override the backpress behaviour on indivitual fragment
     */
    override fun onBackPress(): Boolean {
        return false
    }

    override fun onResume() {
        super.onResume()
        backButtonHandler?.addBackpressListener(this)
    }

    override fun onPause() {
        super.onPause()
        backButtonHandler?.removeBackpressListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        backButtonHandler = context as BackButtonHandlerListener
    }

    override fun onDetach() {
        super.onDetach()
        backButtonHandler?.removeBackpressListener(this)
        backButtonHandler = null
    }

    open fun observeResponse() {
        // Implementation goes on the child fragments
    }


    open fun observeLoadingStatus() {
        // Implementation goes on the child fragments
    }

}