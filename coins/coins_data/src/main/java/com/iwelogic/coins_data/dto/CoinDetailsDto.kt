package com.iwelogic.coins_data.dto

import com.google.gson.annotations.SerializedName

data class CoinDetailsDto(

    @SerializedName("description")
    var description: CoinDescriptionDto? = null
)
