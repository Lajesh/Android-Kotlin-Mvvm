package arch.lavaira.com.android_kotlin_mvvm.di.modules

import arch.lavaira.com.android_kotlin_mvvm.data.remote.Api
import arch.lavaira.com.android_kotlin_mvvm.repository.UserRepository
import arch.lavaira.com.android_kotlin_mvvm.schedulers.SchedulerContract
import arch.lavaira.com.android_kotlin_mvvm.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/****
 * Application Module which is responsible for providing the app wide instances.
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
@Module(includes = [(ViewModelModule::class)])
class AppModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : Api {
        return retrofit.create(Api::class.java)
    }


    @Provides
    @Singleton
    fun provideUserkRepository(api: Api, scheduler: SchedulerContract): UserRepository {
        return UserRepository(api, scheduler)
    }

    @Provides
    @Singleton
    fun provideScheduler(): SchedulerContract {
        return SchedulerProvider()
    }
}