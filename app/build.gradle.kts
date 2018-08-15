import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.sapuglha.tictactoe"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    dataBinding.isEnabled = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // kotlin
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    implementation(kotlin("test", KotlinCompilerVersion.VERSION))
    implementation(kotlin("test-junit", KotlinCompilerVersion.VERSION))

    implementation(Libraries.anko)

    androidTestImplementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    androidTestImplementation(kotlin("test-junit", KotlinCompilerVersion.VERSION))

    // Android support libs
    implementation(Libraries.androidx_appcompat)
    implementation(Libraries.androidx_gridlayout)
    implementation(Libraries.androidx_constraintLayout)
    implementation(Libraries.androidx_constraintLayout_solver)

    // Architecture components
    implementation(Libraries.androidx_lifecycle_runtime)
    implementation(Libraries.androidx_lifecycle_extensions)
    kapt(Libraries.androidx_lifecycle_compiler)

    implementation(Libraries.picasso)

    // Dagger
    implementation(Libraries.dagger)
    implementation(Libraries.dagger_android)
    implementation(Libraries.dagger_android_support)
    kapt(Libraries.dagger_compiler)
    kapt(Libraries.dagger_android_processor)

    // Testing libs
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidx_espresso)
//    , {
//        exclude group: 'com.android.support', module: 'support-annotations'
//    })
}
