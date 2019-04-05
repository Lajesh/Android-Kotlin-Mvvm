package arch.lavaira.com.android_kotlin_mvvm.schedulers

import android.support.annotation.NonNull
import io.reactivex.Scheduler

/****
 * Scheduler contract interface
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
interface SchedulerContract {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}