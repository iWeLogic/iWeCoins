plugins {
    id("com.android.library")
}

apply {
    from("$rootDir/base-presentation.gradle")
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coinsPresentation))
    implementation(project(Modules.newsPresentation))
    implementation("com.google.accompanist:accompanist-navigation-animation:0.28.0")
}