package com.example.music.usecase.errors

import com.example.music.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
