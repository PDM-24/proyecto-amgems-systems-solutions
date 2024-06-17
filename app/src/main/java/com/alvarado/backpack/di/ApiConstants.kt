package com.alvarado.backpack.di

class ApiConstants {
    companion object {
        const val BASE_URL = "http:localhost:8080"
        const val API_PATH = "/api"

        const val LOGIN_PATH = "/auth/login"
        const val LOGIN_IDENTIFIER_PARAM = "identifier"
        const val LOGIN_PASSWORD_PARAM = "password"
        const val LOGIN_RESPONSE_TOKEN = "token"
        const val LOGIN_RESPONSE_ERROR = "error"

        const val REGISTER_PATH = "/auth/register"
        const val REGISTER_CARNET_PARAM = "carnet"
        const val REGISTER_NAME_PARAM = "name"
        const val REGISTER_LASTNAME_PARAM = "lastname"
        const val REGISTER_EMAIL_PARAM = "email"
        const val REGISTER_DEGREE_PARAM = "degree"
        const val REGISTER_PASSWORD_PARAM = "password"
        const val REGISTER_RESPONSE_MESSAGE = "message"
        const val REGISTER_RESPONSE_ERROR = "error"

        const val WHOAMI_PATH = "/auth/whoami"
        const val WHOAMI_ID_PARAM = "_id"
        const val WHOAMI_CARNET_PARAM = "carnet"
        const val WHOAMI_NAME_PARAM = "name"
        const val WHOAMI_LASTNAME_PARAM = "lastname"
        const val WHOAMI_EMAIL_PARAM = "email"
        const val WHOAMI_DEGREE_PARAM = "degree"
        const val WHOAMI_ROLES_PARAM = "roles"

    }
}