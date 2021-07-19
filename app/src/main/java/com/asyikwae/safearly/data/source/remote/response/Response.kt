package com.asyikwae.safearly.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("imageUrl")
	val imageUrl: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("desc")
	val desc: String
)
