package com.android.notification.data.models

data class Response(
	val notification: Notification? = null,
	val to: String? = null
)

data class Notification(
	val title: String? = null,
	val body: String? = null
)

