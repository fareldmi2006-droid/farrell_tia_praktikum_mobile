plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.farrell_tia"

    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.farrell_tia"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation("androidx.recyclerview:recyclerview:1.3.2")   // RecyclerView (Tahap 4)
    implementation("androidx.gridlayout:gridlayout:1.0.0")      // GridLayout
    implementation("androidx.viewpager2:viewpager2:1.1.0")      // ViewPager2
    implementation("com.tbuonomo:dotsindicator:5.1.0")          // DotsIndicator
    implementation("com.github.bumptech.glide:glide:4.16.0")     // Glide (foto profil Message)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
