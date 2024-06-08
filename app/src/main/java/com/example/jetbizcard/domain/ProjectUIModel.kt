package com.example.jetbizcard.domain

import com.example.jetbizcard.EMPTY_CHARACTER

data class ProjectUIModel(
    val name: String = EMPTY_CHARACTER,
    val description: String = EMPTY_CHARACTER,
    val imageUrl: String = EMPTY_CHARACTER
)