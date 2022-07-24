plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = ConfigData.appPackage
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.appPackage
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ConfigData.defaultProguardFileName),
                ConfigData.proguardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

}

dependencies {

    implementation(Deps.core)
    implementation(Deps.lifecycle)
    implementation(Deps.Compose.composeActivity)
    implementation(Deps.Compose.composeUI)
    implementation(Deps.Compose.composeTooling)
    implementation(Deps.Compose.composeMaterial)

    implementation(project(Deps.Modules.path to Deps.Modules.database))
    implementation(project(Deps.Modules.path to Deps.Modules.datastore))
    implementation(project(Deps.Modules.path to Deps.Modules.network))
    implementation(project(Deps.Modules.path to Deps.Modules.resources))
    implementation(project(Deps.Modules.path to Deps.Modules.utils))
    implementation(project(Deps.Modules.path to Deps.Modules.navigation))
    implementation(project(Deps.Modules.path to Deps.Modules.news))
    implementation(project(Deps.Modules.path to Deps.Modules.newsDetails))

    testImplementation(Deps.Tests.jUnit)

    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
    androidTestImplementation(Deps.AndroidTest.composeJUnit)

}