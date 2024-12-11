plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pruebas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pruebas"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.core:core-ktx:1.10.1")

        // Material Components for Android. Replace the version with the latest version of Material Components library.
        implementation ("com.google.android.material:material:1.5.0")

        // Circle Indicator (To fix the xml preview "Missing classes" error)
        implementation ("me.relex:circleindicator:2.1.6")

        implementation ("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0")

}