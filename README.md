
# Send Notification Example

Send Notification from one user to another using Firebase

## Screenshots

![App Screenshot](https://github.com/aliprogrammer7/SendNotificationExample/blob/main/Pics/pic0.png)

## Installation

### Step 1:Add Libraries

Add firebase messaging library:

```
   implementation 'com.google.firebase:firebase-messaging-ktx:23.0.0'
```


Add this lines:

biuld.gradle(app)
```
plugins {
    ...
    id 'com.google.gms.google-services'
}
```

biuld.gradle(Project)
```
plugins {
    ...
    id 'com.google.gms.google-services' version '4.3.10' apply false
}
```
### Step 2:
To use Firebase in your Android app, you need to register your app with your Firebase project. Registering your app is often called "adding" your app to your project.

![App Screenshot](https://github.com/aliprogrammer7/SendNotificationExample/blob/main/Pics/pic3.png)

### Step 3:
Download and put google-serveces.json into project:

![App Screenshot](https://github.com/aliprogrammer7/SendNotificationApp/blob/main/Pics/pic2.png)

### Step 4:

Get your Server key from firebase console and put here.
```
 interface ApiService {
    @Headers(
            "Content-Type:application/json",
            "Authorization:key=your_Server_key"
    @POST("fcm/send")
    fun sendNotifcation(@Body body: Response?): Call<MyResponse?>?
}
```

![App Screenshot](https://github.com/aliprogrammer7/SendNotificationApp/blob/main/Pics/pic1.png)

