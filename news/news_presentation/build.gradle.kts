plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/base-presentation.gradle")
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.newsDomain))
}