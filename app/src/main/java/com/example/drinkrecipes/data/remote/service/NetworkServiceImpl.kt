package com.example.drinkrecipes.data.remote.service

import com.example.drinkrecipes.data.remote.DrinksApi
import com.example.drinkrecipes.data.remote.mapper.toDrinkData
import com.example.drinkrecipes.data.remote.mapper.toDrinkDetailsData
import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.domain.service.NetworkService
import com.example.drinkrecipes.util.network.LoadingState
import com.example.drinkrecipes.util.network.NetworkErrors
import com.example.drinkrecipes.util.network.RequestState
import com.google.gson.JsonParseException
import retrofit2.Response
import java.io.IOException

class NetworkServiceImpl(private val api: DrinksApi) : NetworkService {

    override suspend fun getAllDrinks(): RequestState<List<DrinkData>?> {
        val rawRequestState = safeApiCall { api.getDrinks() }
        return RequestState(
            data = rawRequestState.data?.drinks?.map {
                it.toDrinkData()
            },
            loadingState = rawRequestState.loadingState
        )
    }

    override suspend fun getDrinkById(id: String): RequestState<DrinkDetailsData?> {
        val rawRequestState = safeApiCall { api.getDrinkById(id) }
        return RequestState(
            data = rawRequestState.data?.drinkDetails?.firstOrNull()?.toDrinkDetailsData(),
            loadingState = rawRequestState.loadingState
        )
    }

    private suspend inline fun <T> safeApiCall(
        noinline call: suspend () -> Response<T>
    ): RequestState<T?> {
        try {
            val response = call.invoke()
            return if (response.isSuccessful) {
                val responseBody: T? = response.body()
                if (responseBody != null) {
                    RequestState(
                        data = responseBody,
                        loadingState = LoadingState.Success
                    )
                } else {
                    RequestState(
                        data = null,
                        loadingState = LoadingState.Error(NetworkErrors.NullBodyException)
                    )
                }
            } else {
                val loadingState = when (response.code()) {
                    in 400..499 ->
                        LoadingState.Error(NetworkErrors.ClientException)
                    in 500..526 ->
                        LoadingState.Error(NetworkErrors.ServerException)
                    else -> LoadingState.Error(NetworkErrors.UnknowingError)
                }
                RequestState(
                    data = null,
                    loadingState = loadingState
                )
            }

        } catch (exc: JsonParseException) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.JsonParseException)
            )
        } catch (exc: IOException) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.IOException)
            )
        } catch (exc: Exception) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.UnknowingError)
            )
        }
    }
}
