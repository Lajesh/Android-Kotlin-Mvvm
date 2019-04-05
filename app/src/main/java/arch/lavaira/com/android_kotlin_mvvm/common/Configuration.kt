package arch.lavaira.com.android_kotlin_mvvm.common

import android.support.annotation.IntDef

/****
 * Keep all the Build/ deployment configurations here
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
object Configuration {

    private const val SIT = 0

    private const val DEV = 1

    private const val UAT = 2

    private const val PROD = 3

    @DeploymentType
    private val defaultEnvironment = DEV


    // HOST Urls
    private const val URL_SIT = "" //Put the SIT url here

    private const val URL_DEV = "" // Put the development url here

    private const val URL_PROD = "" // Put the production url here

    private const val URL_UAT = "" // Put the UAT url here

    val baseURL: String
        get() {

            return when (defaultEnvironment) {

                SIT -> URL_SIT

                DEV -> URL_DEV

                UAT -> URL_UAT

                PROD -> URL_PROD

                else -> URL_DEV
            }
        }


    @IntDef(SIT, DEV, UAT, PROD)
    private annotation class DeploymentType
}