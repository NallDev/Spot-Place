package com.nalldev.spotplace.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("meta")
	val meta: Meta
)

data class Meta(

	@field:SerializedName("copyright")
	val copyright: String,

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("url_reference")
	val urlReference: String
)

data class Data(

	@field:SerializedName("forecast")
	val forecast: Forecast
)

data class TimerangeItem(

	@field:SerializedName("datetime")
	val datetime: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("value")
	val value: List<ValueItem>
)

data class AreaItem(

	@field:SerializedName("coordinate")
	val coordinate: String,

	@field:SerializedName("level")
	val level: String,

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("domain")
	val domain: String,

	@field:SerializedName("parameter")
	val parameter: List<ParameterItem>,

	@field:SerializedName("name")
	val name: List<String>,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("longitude")
	val longitude: String,
)

data class ValueItem(

	@field:SerializedName("unit")
	val unit: String,

	@field:SerializedName("text")
	val text: String
)

data class ParameterItem(

	@field:SerializedName("timerange")
	val timerange: List<TimerangeItem>,

	@field:SerializedName("description")
	val description: String
)

data class Forecast(

	@field:SerializedName("area")
	val area: List<AreaItem>,

	@field:SerializedName("domain")
	val domain: String,

	@field:SerializedName("timestamp")
	val timestamp: String
)
