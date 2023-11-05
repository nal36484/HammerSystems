package com.example.test.domain.entities

data class Result<T>(
    val status: StatusEnum,
    val data: T? = null
)
