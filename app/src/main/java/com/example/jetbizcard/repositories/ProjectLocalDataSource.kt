package com.example.jetbizcard.repositories

import com.example.jetbizcard.domain.Project

object ProjectLocalDataSource {

    fun getProjects() = listOf(
        Project(
            "Jetpack Compose",
            "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.",
            "https://developer.android.com/images/jetpack/compose.png"
        ),
        Project(
            "Kotlin Multiplatform",
            "Kotlin Multiplatform lets you maintain a single codebase for your app logic across iOS and Android.",
            "https://developer.android.com/images/kotlin/kmp.png"
        ),
        Project(
            "Android Studio",
            "Android Studio provides the fastest tools for building apps on every type of Android device.",
            "https://developer.android.com/images/studio.png"
        ),
        Project(
            "Android Jetpack",
            "Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices.",
            "https://developer.android.com/images/jetpack/jetpack.png"
        ),
        Project(
            "Android Emulator",
            "The Android Emulator simulates Android devices on your computer so that you can test your app on a variety of devices and Android API levels without needing to have each physical device.",
            "https://developer.android.com/images/tools/emulator.png"
        ),
        Project(
            "Android System",
            "Android is an open source, Linux-based software stack created for a wide array of devices and form factors. The following diagram shows the major components of the Android platform.",
            "https://developer.android.com/images/system-architecture.svg"
        )
    )

}