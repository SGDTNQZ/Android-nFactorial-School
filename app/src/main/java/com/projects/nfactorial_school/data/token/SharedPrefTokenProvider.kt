package com.projects.nfactorial_school.data.token

import android.content.Context
import android.content.SharedPreferences

class SharedPrefTokenProvider(context: Context) : TokenProvider {

    companion object {
        private const val PREFS_NAME = "auth_prefs"
        private const val KEY_TOKEN = "token"
    }

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun getToken(): String {
        return prefs.getString("token","") ?: ""
    }

    override fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    override fun clearToken() {
        prefs.edit().remove(KEY_TOKEN).apply()
    }
}