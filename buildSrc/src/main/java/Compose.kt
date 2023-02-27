object Compose {
    const val version = "1.2.1"
    private const val nav_version = "2.5.2"
    const val ui = "androidx.compose.ui:ui:$version"
    const val material = "androidx.compose.material:material:$version"
    const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
    const val junit4 = "androidx.compose.ui:ui-test-junit4:$version"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
    const val manifest = "androidx.compose.ui:ui-test-manifest:$version"
    const val navigation = "androidx.navigation:navigation-compose:$nav_version"
    const val runtime = "androidx.compose.runtime:runtime:$version"

    const val composeCompiler = "1.3.1"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompiler"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.4.0"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}
