package arch.lavaira.com.android_kotlin_mvvm.di.modules

import arch.lavaira.com.android_kotlin_mvvm.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/****
 * The module which provides the android injection service to activities
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
@Suppress("unused")
@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}