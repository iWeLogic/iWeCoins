plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {

    namespace = "com.iwelogic.coins_data"

    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BACKEND_URL", "\"https://api.coingecko.com/api/v3/\"")
            buildConfigField("String", "HISTORY_BASE_URL", "\"https://min-api.cryptocompare.com/\"")
        }

        debug {
            buildConfigField("String", "BACKEND_URL", "\"https://api.coingecko.com/api/v3/\"")
            buildConfigField("String", "HISTORY_BASE_URL", "\"https://min-api.cryptocompare.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Retrofit.okHttp)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.gsonConverter)

    kapt(DaggerHilt.hiltCompiler)
    implementation(DaggerHilt.hiltAndroid)

    implementation(project(Modules.core))
    implementation(project(Modules.coinsDomain))
}