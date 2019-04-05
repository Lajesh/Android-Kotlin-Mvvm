package arch.lavaira.com.android_kotlin_mvvm.view.listeners

/****
 * Back press listener for handling back navigation in activity/fragments
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
interface BackPressListener {
    fun onBackPress(): Boolean
}