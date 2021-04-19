object Dependencies {

    //Dependency injection dependencies
    const val koin_core = "org.koin:koin-core:${Versions.koin_core}"
    const val koin_android = "org.koin:koin-android:${Versions.koin_core}"
    const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_core}"

    //Rx dependencies
    const val rx_java3 = "io.reactivex.rxjava3:rxjava:${Versions.rx_java3}"
    const val rx_android3 = "io.reactivex.rxjava3:rxandroid:${Versions.rx_android3}"

    //Rest service dependencies
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_rx_java3_adapter =
        "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0"
    const val retrofit_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    //Navigation
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:2.3.5"
    const val navigation_safe_args =
        "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5"

    //Room dependencies
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val room_annotation = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_rxjava3_support = "androidx.room:room-rxjava3:${Versions.room}"
    const val room_test_helper = "androidx.room:room-testing:${Versions.room}"

    //Image loading dependencies
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    //Testing dependencies
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito_inline}"
    const val arch_core_testing = "android.arch.core:core-testing:${Versions.arch_core_testing}"
    const val koin_test = "org.koin:koin-test:${Versions.koin_core}"

    //View
    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"


}