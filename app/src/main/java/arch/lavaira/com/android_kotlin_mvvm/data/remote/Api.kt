package arch.lavaira.com.android_kotlin_mvvm.data.remote

import arch.lavaira.com.android_kotlin_mvvm.model.User
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

/****
 * Keep all the REST Apis here
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/3/19
 * Modified on: 4/3/19
 *****/
interface Api {
    @POST("user/login")
    fun login(@Header("Authorization") authorization: String, @Body params: JsonObject): Observable<User>

}