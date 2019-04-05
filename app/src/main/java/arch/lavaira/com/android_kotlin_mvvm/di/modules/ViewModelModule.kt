package arch.lavaira.com.android_kotlin_mvvm.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import arch.lavaira.com.android_kotlin_mvvm.architecture.ViewModelFactory
import arch.lavaira.com.android_kotlin_mvvm.di.key.ViewModelKey
import arch.lavaira.com.android_kotlin_mvvm.view.fragment.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/****
 * View Model module which provides the viewmodelfactory and viewmodel instances
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}