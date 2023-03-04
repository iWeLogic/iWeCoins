package com.iwelogic.coins_domain.use_case

import com.iwelogic.coins_domain.models.CoinDetailsDomain
import com.iwelogic.coins_domain.models.CoinDomain
import com.iwelogic.coins_domain.models.CoinHistoryDataDomain
import com.iwelogic.coins_domain.repository.CoinsRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class CoinsDetailsUseCaseImp(private val repository: CoinsRepository) : CoinDetailsUseCase {

    override suspend fun getCoinDetails(): Result<CoinDetailsDomain> = coroutineScope {

        val queriesDetails = HashMap<String, Any>()
        queriesDetails["localization"] = false
        queriesDetails["tickers"] = false
        queriesDetails["market_data"] = true
        queriesDetails["community_data"] = false
        queriesDetails["developer_data"] = false

        val queries = HashMap<String, Any>()
        queries["tsym"] = "USD"
        queries["e"] = "CCCAGG"
        queries["limit"] = 10
        queries["fsym"] = "BTC"
        queries["aggregate"] = 1

        var requestCoinDetails: Deferred<Result<CoinDetailsDomain>>
        var requestCoinHistory: Deferred<Result<CoinHistoryDataDomain>>
        coroutineScope {
            requestCoinDetails = async { repository.getCoinDetails("bitcoin", queriesDetails) }
            requestCoinHistory = async { repository.getCoinHistory(queries) }
        }
        val resultCoinDetails = requestCoinDetails.await()
        val resultCoinHistory = requestCoinHistory.await()
        val results = arrayOf(resultCoinDetails, resultCoinHistory)
        val error = results.firstOrNull { it.isFailure }
        error?.let {
            println("PRINT " + it.exceptionOrNull()!!.message)
            it.exceptionOrNull()?.printStackTrace()
            Result.failure(error.exceptionOrNull()!!)
        } ?: run {
            Result.success(
                resultCoinDetails.getOrThrow().copy(
                    history = resultCoinHistory.getOrThrow()
                )
            )
        }
    }
}

