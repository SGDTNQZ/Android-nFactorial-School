package com.projects.nfactorial_school.data.token

interface TokenProvider {
    fun getToken() : String
    fun saveToken(token : String)
}