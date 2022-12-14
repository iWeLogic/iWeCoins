pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "iWeCoins"
include (":app")
include(":main:main_presentation")
include(":core")
include(":coins:coins_presentation")
include(":coins:coins_data")
include(":coins:coins_domain")
include(":news:news_presentation")
include(":news:news_domain")
include(":news:news_data")
