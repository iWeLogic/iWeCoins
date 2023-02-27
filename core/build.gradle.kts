apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(Retrofit.gsonConverter)
}