package com.iwelogic.core.utils

fun Float?.orZero() = this ?: 0.0f

fun Double?.orZero() = this ?: 0.0

fun Float?.twoDigitsAfterDot() = String.format("%.2f", this.orZero())

fun Boolean?.isTrue() = this ?: true

