package com.example.githubdata.closedmr

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

class TestHelper {

    companion object {
        internal const val NORMAL_ERROR_CODE = 400
        internal const val AUTH_ERROR_CODE = 401
        internal const val SCOOTER_OFFLINE_ERROR_CODE = 406
        internal const val CONFLICT_ERROR_CODE = 409

        internal inline fun <reified T> getApiError(errorCode: Int): HttpException {
            val error = Response.error<T>(
                errorCode,
                ("{\"status\":\"failed\", \"title\":\"setting api\",\"display_message\":\"DEFAULT_ERROR_MSG\",\"data\":\"null\"}").toResponseBody(
                    "application/json".toMediaTypeOrNull()
                )
            )
            return HttpException(error)
        }
    }
}
