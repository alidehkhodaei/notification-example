package com.android.notification.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.notification.data.api.ApiClient
import com.android.notification.data.models.MyResponse
import com.android.notification.data.models.Notification
import com.android.notification.data.models.Response
import com.android.notification.databinding.ActivitySendNotificationBinding
import com.android.notification.others.Constans.NOTIFICATION_SENT_SUCCESSFULLY
import com.android.notification.utils.ClipboardManager
import com.android.notification.utils.SharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySendNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendNotificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sendNotificationBtnClicked()

        shareMyTokenBtnClicked()

    }

    private fun shareMyTokenBtnClicked() =
        binding.btnCopyMyToken.setOnClickListener {

            val token = SharedPreferencesManager.getToken(this)

            if (token != null){
                ClipboardManager.copyToClipboard(this,token)
                Toast.makeText(this@NotificationActivity, "Copied to clipboard!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this@NotificationActivity, "Wait a little. The token has not been created yet!", Toast.LENGTH_LONG).show()
            }

        }

    private fun sendNotificationBtnClicked() =
        binding.btnSendNotification.setOnClickListener {
            sendNotification(
                binding.edTitle.text.toString().trim(),
                binding.edMessage.text.toString().trim(),
                binding.edToken.text.toString().trim()
            )
        }

    private fun sendNotification(title: String, message: String, token: String) {
        val data = Notification(title, message)
        val response = Response(data, token)
        ApiClient.apiService.sendNotifcation(response)?.enqueue(object : Callback<MyResponse?> {
            override fun onResponse(
                call: Call<MyResponse?>,
                response: retrofit2.Response<MyResponse?>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.success == NOTIFICATION_SENT_SUCCESSFULLY) {
                        Toast.makeText(this@NotificationActivity, "Success", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@NotificationActivity, "Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<MyResponse?>, t: Throwable?) {
                Toast.makeText(this@NotificationActivity, "Failed", Toast.LENGTH_LONG).show()
            }
        })
    }
}
