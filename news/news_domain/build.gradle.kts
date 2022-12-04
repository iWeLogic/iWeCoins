apply {
    from("$rootDir/data-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
}