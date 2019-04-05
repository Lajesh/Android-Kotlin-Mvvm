package arch.lavaira.com.android_kotlin_mvvm.di.components

import android.app.Application
import arch.lavaira.com.android_kotlin_mvvm.MvvmApplication
import arch.lavaira.com.android_kotlin_mvvm.di.modules.ActivityBuilderModule
import arch.lavaira.com.android_kotlin_mvvm.di.modules.AppModule
import arch.lavaira.com.android_kotlin_mvvm.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/****
 * Application Component
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mvvmApplication: MvvmApplication)
}