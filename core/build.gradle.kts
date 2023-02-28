apply {
    from("$rootDir/base-data.gradle")
}

dependencies {
    "implementation"(Retrofit.gsonConverter)
}