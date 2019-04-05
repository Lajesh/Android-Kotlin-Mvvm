package arch.lavaira.com.android_kotlin_mvvm.view.listeners

/****
 * Back button handler interface. Add/remove listener functionality
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
interface BackButtonHandlerListener {
    fun addBackpressListener(listner: BackPressListener)
    fun removeBackpressListener(listner: BackPressListener)
}