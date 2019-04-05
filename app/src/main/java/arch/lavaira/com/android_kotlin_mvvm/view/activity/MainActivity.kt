package arch.lavaira.com.android_kotlin_mvvm.view.activity

import arch.lavaira.com.android_kotlin_mvvm.BR
import arch.lavaira.com.android_kotlin_mvvm.R
import arch.lavaira.com.android_kotlin_mvvm.databinding.ActivityMainBinding
import arch.lavaira.com.android_kotlin_mvvm.view.activity.base.BaseActivity
import arch.lavaira.com.android_kotlin_mvvm.view.fragment.login.LoginViewModel


/****
 * MainActivity class
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
class MainActivity : BaseActivity<LoginViewModel, ActivityMainBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<LoginViewModel> {
      return LoginViewModel::class.java
    }


}
