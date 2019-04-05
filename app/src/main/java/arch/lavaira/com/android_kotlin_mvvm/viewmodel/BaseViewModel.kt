package arch.lavaira.com.android_kotlin_mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import arch.lavaira.com.android_kotlin_mvvm.architecture.SingleLiveEvent
import arch.lavaira.com.android_kotlin_mvvm.data.remote.response.ApiResponse

/****
 * Base view model. All the common implementation of viewmodel goes here
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
abstract class BaseViewModel<T> : ViewModel() {

    val response: SingleLiveEvent<ApiResponse<T>> = SingleLiveEvent()

    val loadingStatus: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val logoutStatus: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val backPressAction: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val logoutAction: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val headerStatus: MutableLiveData<Boolean> = MutableLiveData()

    val headerStepperStatus: MutableLiveData<Boolean> = MutableLiveData()

    val headerTitle: MutableLiveData<String> = MutableLiveData()

    //lateinit var sharedViewModel: SharedViewModel

    fun showStepper() {
        headerStepperStatus.value = true
    }

    fun showHeader(show: Boolean) {
        headerStatus.value = show
    }

    open fun onBackpress() {
        backPressAction.value = true
    }

    open fun onLogoutAction() {
        logoutAction.value = true
    }

    fun setTitle(title: String) {
        headerTitle.value = title
    }

}