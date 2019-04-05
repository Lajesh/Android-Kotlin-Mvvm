package arch.lavaira.com.android_kotlin_mvvm.view.fragment.login

import arch.lavaira.com.android_kotlin_mvvm.model.User
import arch.lavaira.com.android_kotlin_mvvm.repository.UserRepository
import arch.lavaira.com.android_kotlin_mvvm.viewmodel.BaseViewModel
import javax.inject.Inject

/****
 * The presentation layer of Login fragment
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/4/19
 * Modified on: 4/4/19
 *****/
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel<User>(){

}