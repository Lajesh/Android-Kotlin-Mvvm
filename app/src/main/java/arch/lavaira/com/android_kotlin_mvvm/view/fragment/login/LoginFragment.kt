package arch.lavaira.com.android_kotlin_mvvm.view.fragment.login

import arch.lavaira.com.android_kotlin_mvvm.BR
import arch.lavaira.com.android_kotlin_mvvm.R
import arch.lavaira.com.android_kotlin_mvvm.databinding.FragmentLoginBinding
import arch.lavaira.com.android_kotlin_mvvm.view.fragment.base.BaseFragment

/****
 * Login Fragment
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/4/19
 * Modified on: 4/4/19
 *****/
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_login

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun getTitle(): String {
        return ""
    }
}