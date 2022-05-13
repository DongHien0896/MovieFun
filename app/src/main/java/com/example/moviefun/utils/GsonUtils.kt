package com.example.moviefun.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException

class GsonUtils {

    companion object {
        private var INSTANCE: Gson? = null

        fun getInstance(): Gson {
            if (INSTANCE == null) {
                INSTANCE = GsonBuilder().create()
            }
            return INSTANCE as Gson
        }

        fun objectToString(unit: Unit): String = getInstance().toJson(unit)

        fun <T> stringToObject(json: String?, classT: Class<T>): T? {
            return try {
                getInstance().fromJson(json, classT)
            } catch (ignored: JsonSyntaxException) {
                null
            }
        }

        fun <T> stringToListObject(json: String, clazz: Class<T>): List<T> {
            return listOf(getInstance().fromJson(json, clazz))
        }
    }
}
