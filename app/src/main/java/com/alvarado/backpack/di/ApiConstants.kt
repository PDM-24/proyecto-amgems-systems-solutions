package com.alvarado.backpack.di

class ApiConstants {
    companion object {
        const val BASE_URL = "http://192.168.1.9:3500"
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
        const val WHOAMI_SAVED_POSTS_PARAM = "savedPosts"

        const val POST_SAVE_PATH = "/post"
        const val POST_ALL_PATH = "/post"
        const val POST_SUBJECT_PATH = "/post/subject"
        const val POST_OWNER_PATH = "/post/own"
        const val POST_SAVED_PATH = "/post/saved"
        const val POST_FAVORITE_PATH = "/post/save"

        const val POST_ID_PARAM = "_id"
        const val POST_TITLE_PARAM = "title"
        const val POST_URL_PARAM = "document"
        const val POST_PUBLICATION_YEAR_PARAM = "publication_year"
        const val POST_PUBLICATION_CYCLE_PARAM = "publication_cycle"
        const val POST_SUBJECT_PARAM = "subject"
        const val POST_CATEGORY_PARAM = "category"
        const val POST_HIDDEN_PARAM = "hidden"
        const val POST_TOPICS_PARAM = "topics"
        const val POST_AUTHOR_PARAM = "user"
        const val POST_LIST_PARAM = "posts"

        const val SUBJECT_PATH = "/subject"
        const val SUBJECT_DEGREE_PATH = "/subject"
        const val SUBJECT_ID_PARAM = "_id"
        const val SUBJECT_CODE_PARAM = "code"
        const val SUBJECT_NAME_PARAM = "name"
        const val SUBJECT_IMAGE_PARAM = "image"
        const val SUBJECT_LIST_PARAM = "subjects"

        const val REPORT_PATH = "/report"
        const val REPORT_POST_PARAM = "post"
        const val REPORT_REASON_PARAM = "reportCause"
        const val REPORT_RESPONSE_MESSAGE = "message"
        const val REPORT_RESPONSE_ERROR = "error"
    }
}