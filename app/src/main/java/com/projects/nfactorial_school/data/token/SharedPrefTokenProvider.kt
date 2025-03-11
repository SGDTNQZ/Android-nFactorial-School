package com.projects.nfactorial_school.data.token

import android.content.Context

class SharedPrefTokenProvider(context: Context) : TokenProvider {
    private val prefs = context.getSharedPreferences(
        "auth_prefs",
        Context.MODE_PRIVATE
    )

    override fun getToken(): String {
        return prefs.getString("token","") ?: ""
    }

    override fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }
}