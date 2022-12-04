apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(Retrofit.gsonConverter)
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    "implementation"("com.google.android.material:material:1.6.1")
    "implementation"("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    "implementation"("androidx.navigation:navigation-runtime-ktx:2.5.2")
    "implementation"( "androidx.fragment:fragment-ktx:1.4.1")
    "implementation"( "androidx.navigation:navigation-fragment-ktx:2.4.2")
}