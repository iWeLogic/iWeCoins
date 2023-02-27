apply {
    from("$rootDir/presentation-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coinsPresentation))
}