package com.android.notification.data.api


import com.android.notification.data.models.Response
import com.android.notification.data.models.MyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
 interface ApiService {
    @Headers(
            "Content-Type:application/json",
            "Authorization:key=AAAA169xt1E:APA91bE3cEkiBsGcYYINgOQGPm3JbkGi-VK3BK-P9BOzIrclGChSeN7NVhAwZnsKMzli3kmDHuqmWK7u6D-YZ4xaltFkk0dlQrXo-szGOqNPOyxOZ8POkYZrxFEeseXDEzEBZvVaMJMj"
    )
    @POST("fcm/send")
    fun sendNotifcation(@Body body: Response?): Call<MyResponse?>?
}