package com.asyikwae.safearly.data.source.remote

import com.asyikwae.safearly.data.source.remote.network.ApiResponse
import com.asyikwae.safearly.data.source.remote.network.EndPoint
import com.asyikwae.safearly.data.source.remote.response.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource private constructor(private val endPoint: EndPoint) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(endPoint: EndPoint): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(endPoint)
            }
    }

    suspend fun getArticles(): Flow<ApiResponse<List<Response>>> {
        return flow {
            try {
                val response = endPoint.getArticles()
                val dataArray = response
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {

                }
            }
        }
    }
}