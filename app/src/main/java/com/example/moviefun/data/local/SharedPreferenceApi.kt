package com.example.moviefun.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.moviefun.utils.GsonUtils

@Suppress("UNCHECKED_CAST")
class SharedPreferenceApi private constructor(context: Context) {

    companion object {
        private const val PREFS_NAME = "MovieFunSharedPreferences"
        private var INSTANCE: SharedPreferenceApi? = null

        fun getInstance(context: Context): SharedPreferenceApi {
            if (INSTANCE == null) {
                INSTANCE = SharedPreferenceApi(context)
            }
            return INSTANCE as SharedPreferenceApi
        }
    }

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    operator fun <T> get(key: String, classT: Class<T>): T? {
        when (classT) {
            String::class.java -> {
                return sharedPreferences.getString(key, "") as T
            }
            Boolean::class.java -> {
                return java.lang.Boolean.valueOf(sharedPreferences.getBoolean(key, false)) as T
            }
            Float::class.java -> {
                return java.lang.Float.valueOf(sharedPreferences.getFloat(key, 0f)) as T
            }
            Int::class.java -> {
                return Integer.valueOf(sharedPreferences.getInt(key, 0)) as T
            }
            Long::class.java -> {
                return java.lang.Long.valueOf(sharedPreferences.getLong(key, 0)) as T
            }
            else -> {
                return GsonUtils.stringToObject(sharedPreferences.getString(key, ""), classT) as T
            }
        }
    }

    operator fun <T> get(key: String, classT: Class<T>, defValue: T): T? {
        when (classT) {
            String::class.java -> {
                return sharedPreferences.getString(key, defValue as String) as T
            }
            Boolean::class.java -> {
                return java.lang.Boolean.valueOf(
                    sharedPreferences.getBoolean(key, defValue as Boolean)
                ) as T
            }
            Float::class.java -> {
                return java.lang.Float.valueOf(sharedPreferences.getFloat(key, defValue as Float)) as T
            }
            Int::class.java -> {
                return Integer.valueOf(sharedPreferences.getInt(key, defValue as Int)) as T
            }
            Long::class.java -> {
                return java.lang.Long.valueOf(sharedPreferences.getLong(key, defValue as Long)) as T
            }
            else -> {
                return GsonUtils.stringToObject(
                    sharedPreferences.getString(key, defValue as String),
                    classT
                )
            }
        }
    }

    fun <T> put(key: String, data: T) {
        val editor = sharedPreferences.edit()
        when (data) {
            is String -> {
                editor.putString(key, data as String)
            }
            is Boolean -> {
                editor.putBoolean(key, data as Boolean)
            }
            is Float -> {
                editor.putFloat(key, data as Float)
            }
            is Int -> {
                editor.putInt(key, data as Int)
            }
            is Long -> {
                editor.putLong(key, data as Long)
            }
            else -> {
                editor.putString(key, GsonUtils.objectToString(data as Unit))
            }
        }
        editor.apply()
    }
}
