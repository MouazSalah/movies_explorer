plugins{
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {

    compileSdk = 34
    namespace = "com.areeb.moviesexplorer"

    defaultConfig {
        applicationId = "com.areeb.moviesexplorer"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }

        buildFeatures {
            viewBinding = true
            buildConfig = true
        }
    }


    flavorDimensions("flavors")
    productFlavors {
        create("staging") {
            dimension = "flavors"
            applicationId = "com.areeb.tmdb"
            resValue("string", "app_name", "Movie Explorer")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "BASE_IMAGES_URL", "\"https://image.tmdb.org/t/p/original/\"")
            buildConfigField("String", "API_KEY", "\"169edd5ba67dab5a976067e49fad78d0\"")
            buildConfigField("String", "API_ACCESS_TOKEN", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNjllZGQ1YmE2N2RhYjVhOTc2MDY3ZTQ5ZmFkNzhkMCIsInN1YiI6IjVkZmI4ZjI4ZDFhODkzMDAxMjgyYzNjYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5Aadm0G5V8KH-c5TQRwz-KcC2-k_A4LNmdVTRjKp5dM\"")
        }
    }

    dependencies {
        //Test
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

        //Android
        implementation("androidx.core:core-ktx:1.10.1")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")

        //Lifecycle
        val lifecycleVersion = "2.6.1"
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

        //Navigation
        val navVersion = "2.7.0"
        implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
        implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

        //Dimensionsres
        implementation("com.intuit.sdp:sdp-android:1.1.0")
        implementation("com.intuit.ssp:ssp-android:1.1.0")

        //Swiperefresh
        implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

        //Glide
        implementation("com.github.bumptech.glide:glide:4.15.1")

        //Hilt
        val hilt_version = "2.47"
        implementation("com.google.dagger:hilt-android:$hilt_version")
        kapt("com.google.dagger:hilt-compiler:$hilt_version")

        //Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

        //File/Imagepicker
        implementation("com.github.atwa:filepicker:1.0.7")

        //KotlinSerialization
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
        //DataStore
        implementation("androidx.datastore:datastore-preferences-core:1.0.0")
        implementation("androidx.datastore:datastore-preferences:1.0.0")

        //Popup
        implementation("com.github.skydoves:balloon:1.5.2")

        //Chuck
        debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
        releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

        implementation("com.jakewharton.timber:timber:5.0.1")

        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
        implementation("com.squareup.retrofit2:converter-scalars:2.1.0")
        implementation("com.google.code.gson:gson:2.10.1")
        implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")

        // Room
        implementation("androidx.room:room-ktx:2.5.2")
        ksp("androidx.room:room-compiler:2.5.2")
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
