package com.iwelogic.core.utils

fun Double?.orZero() = this ?: 0.0

fun Double?.twoDigitsAfterDot() = String.format("%.2f", this.orZero())

fun Boolean?.isTrue() = this ?: true
