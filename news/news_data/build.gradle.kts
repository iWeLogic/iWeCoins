plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/base-data.gradle")
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.newsDomain))
}