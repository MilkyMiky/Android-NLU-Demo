object Versions {

    //Project
    const val compileSdkVersion = 28
    const val applicationId = "com.example.user.samplenlu"
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    const val versionCode = 1
    const val versionName = "1.0"
    const val sourceCompatibility = "1.8"
    const val targetCompatibility = "1.8"

    //Android
    const val appCompat = "28.0.0"
    const val constraintLayout = "1.1.3"
    const val gson = "2.8.5"

    //Kotlin
    const val kotlinVersion = "1.2.71"

    //Di
    const val koinVersion = "1.0.1"

    //Rx
    const val rxKotlinVersion = "2.3.0"
    const val rxAndroidVersion = "2.1.0"

    //Mosby
    const val mosbyVersion = "3.1.0"

    //Gradle
    const val buildGradleVersion = "3.2.1"

    //Test
    const val jUnit = "4.12"
    const val testRunner = "1.0.2"
    const val espresso = "3.0.2"
    const val jupiter = "5.1.0"
}


object Deps {

    //Android
    const val appCompat = "com.android.support:appcompat-v7:${Versions.appCompat}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    //Kotlin
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    //Di
    const val koin = "org.koin:koin-android:${Versions.koinVersion}"

    //Rx
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"

    //Mosby
    const val mosby = "com.hannesdorfmann.mosby3:mvi:${Versions.mosbyVersion}"

    // Gradle
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradleVersion}"

    //Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val jUnitRunner = "android.support.test.runner.AndroidJUnitRunner"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}"

}