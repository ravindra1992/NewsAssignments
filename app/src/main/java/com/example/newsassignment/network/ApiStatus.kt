package com.example.newsassignment.network
import okhttp3.ResponseBody
import org.json.JSONObject

object ApiStatus{

    fun CheckStatus(statusCode:Int,errorBody: ResponseBody?):String{
        val jObject = JSONObject(errorBody!!.string())
        val message = jObject.getString("message")
        return when (statusCode) {
            400 -> {
                message
            }
            401 -> {
                message
            }
            500 -> {
                message
            }
            else -> message
        }

    }
}