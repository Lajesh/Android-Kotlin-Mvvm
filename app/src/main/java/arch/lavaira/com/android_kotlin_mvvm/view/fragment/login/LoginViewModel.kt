package arch.lavaira.com.android_kotlin_mvvm.view.fragment.login

import android.arch.lifecycle.MutableLiveData
import arch.lavaira.com.android_kotlin_mvvm.common.JsonKeyConstants
import arch.lavaira.com.android_kotlin_mvvm.data.remote.response.ApiResponse
import arch.lavaira.com.android_kotlin_mvvm.data.remote.response.ResponseListener
import arch.lavaira.com.android_kotlin_mvvm.model.User
import arch.lavaira.com.android_kotlin_mvvm.repository.UserRepository
import arch.lavaira.com.android_kotlin_mvvm.viewmodel.BaseViewModel
import com.google.gson.JsonObject
import javax.inject.Inject

/****
 * The presentation layer of Login fragment
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/4/19
 * Modified on: 4/4/19
 *****/
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel<User>(){

    val userName =  MutableLiveData<String>()
    val password = MutableLiveData<String>()

    /**
     * Service call that performs the user login
     */
    fun doLogin(){
        userRepository.login("", constructBodyParamsForLogin(), object :ResponseListener<User>{
            override fun onStart() {
                loadingStatus.value = true
            }

            override fun onFinish() {
                loadingStatus.value = true
            }

            override fun onResponse(result: ApiResponse<User>) {
                response.value = result
            }

        } )
    }

    /**
     * This method return the JSON body for Login service call
     */
    fun constructBodyParamsForLogin() : JsonObject{
        val jsonObject = JsonObject();
        jsonObject.addProperty(JsonKeyConstants.JSON_KEY_USERNAME, userName.value)
        jsonObject.addProperty(JsonKeyConstants.JSON_KEY_PASSWORD, password.value)
        return jsonObject
    }

}