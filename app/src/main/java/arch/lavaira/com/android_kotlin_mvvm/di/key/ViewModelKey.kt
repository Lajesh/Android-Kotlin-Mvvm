package arch.lavaira.com.android_kotlin_mvvm.di.key

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/****
 * ViewModel Key
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/4/19
 * Modified on: 4/4/19
 *****/

@MapKey
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)