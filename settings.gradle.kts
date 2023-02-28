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
include(":main:main_domain")
include(":main:main_presentation")
include(":main:main_data")
include(":core")
include(":coins:coins_data")
include(":coins:coins_domain")
include(":coins:coins_presentation")
include(":news:news_data")
include(":news:news_domain")
include(":news:news_presentation")
include(":core_ui")
