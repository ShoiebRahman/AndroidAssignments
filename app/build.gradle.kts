plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.androidassignments"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidassignments"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.junit)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("androidx.core:core:1.13.1")
    implementation("androidx.test:core:1.5.0")
    implementation("androidx.test:monitor:1.6.1")
    implementation("androidx.test:rules:1.5.0")
    implementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.test.espresso:espresso-intents:3.5.1")
    implementation("androidx.test.ext:junit:1.1.5")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")


    //androidTestImplementation ("androidx.test:rules:1.5.0")
    //androidTestImplementation ("androidx.test:runner:1.5.2")

    testImplementation ("junit:junit:4.13.2")

    // AndroidX Test - Instrumentation Testing
    androidTestImplementation ("androidx.test:runner:1.4.0")
    androidTestImplementation ("androidx.test:rules:1.4.0")

    // Espresso
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

}

