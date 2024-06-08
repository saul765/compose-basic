package com.example.jetbizcard.domain

data class Project(val name: String?, val description: String?, val imageUrl: String?)


fun Project.toProjectUIModel(): ProjectUIModel {
    return ProjectUIModel(name.orEmpty(), description.orEmpty(), imageUrl.orEmpty())
}