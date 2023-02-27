apply {
    from("$rootDir/base-data-module.gradle")
}

dependencies {
    "implementation"(Retrofit.gsonConverter)
}