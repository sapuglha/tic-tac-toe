object versions {
    const val kotlin = "1.2.60"

    object androidx {
        const val appcompat = "1.0.0-rc01"
        const val constraintLayout = "1.1.2"
        const val gridlayout = "1.0.0-rc01"
        const val lifecycle = "2.0.0-rc01"
    }

    const val anko = "0.+"

    const val dagger = "2.16"

    const val junit = "4.12"
    const val picasso = "2.5.2"
}

object Libraries {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
    val kotlin_test = "org.jetbrains.kotlin:kotlin-test:${versions.kotlin}"
    val kotlin_test_junit = "org.jetbrains.kotlin:kotlin-test-junit:${versions.kotlin}"

    val anko = "org.jetbrains.anko:anko:${versions.anko}"

    val dagger = "com.google.dagger:dagger:${versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${versions.dagger}"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${versions.dagger}"

    val androidx_appcompat = "androidx.appcompat:appcompat:${versions.androidx.appcompat}"

    val androidx_gridlayout = "androidx.gridlayout:gridlayout:${versions.androidx.gridlayout}"

    val androidx_constraintLayout = "androidx.constraintlayout:constraintlayout:${versions.androidx.constraintLayout}"
    val androidx_constraintLayout_solver = "androidx.constraintlayout:constraintlayout-solver:${versions.androidx.constraintLayout}"

    val androidx_test_espresso = "androidx.test.espresso:espresso-core:3.1.0-alpha4"
    val androidx_test_rules = "androidx.test:rules:1.1.0-alpha4"
    val androidx_test_runner = "androidx.test:runner:1.1.0-alpha4"

    val androidx_lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${versions.androidx.lifecycle}"
    val androidx_lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${versions.androidx.lifecycle}"
    val androidx_lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${versions.androidx.lifecycle}"

    val junit = "junit:junit:${versions.junit}"

    val picasso = "com.squareup.picasso:picasso:${versions.picasso}"
}