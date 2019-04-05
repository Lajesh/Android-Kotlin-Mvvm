package arch.lavaira.com.android_kotlin_mvvm.di.modules

import arch.lavaira.com.android_kotlin_mvvm.view.fragment.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/****
 * The module which provides the android injection service to fragments.
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
@Suppress("unused")
@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}