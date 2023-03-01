plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/base-data.gradle")
}

dependencies {
    implementation(Retrofit.gsonConverter)
    implementation("com.google.accompanist:accompanist-navigation-animation:0.28.0")
}