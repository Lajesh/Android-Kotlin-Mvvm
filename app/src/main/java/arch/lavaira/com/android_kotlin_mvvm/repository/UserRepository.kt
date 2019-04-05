package arch.lavaira.com.android_kotlin_mvvm.repository

import arch.lavaira.com.android_kotlin_mvvm.data.remote.Api
import arch.lavaira.com.android_kotlin_mvvm.data.remote.response.ResponseListener
import arch.lavaira.com.android_kotlin_mvvm.model.User
import arch.lavaira.com.android_kotlin_mvvm.schedulers.SchedulerContract
import com.google.gson.JsonObject
import javax.inject.Inject

/****
 * User Repository which keeps all the service calls related to User entity
 * Author: Lajesh Dineshkumar
 * Company: Lavaira
 * Created on: 4/4/19
 * Modified on: 4/4/19
 *****/
class UserRepository@Inject constructor(private val api: Api, scheduler: SchedulerContract)
    : BaseRepository(scheduler){

    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun login(authorizationHeader: String, bodyParams: JsonObject, responseListener: ResponseListener<User>) {
        performRequest(api.login(authorizationHeader, bodyParams), responseListener)
    }

}