apply {
    from("$rootDir/base-data-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coinsDomain))
}