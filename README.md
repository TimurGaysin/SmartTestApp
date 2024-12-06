This is a test live-code mobile application template for KMP Jetpack Compose. 
Its purpose is to display a list of users from the test API https://jsonplaceholder.typicode.com/users and show
the number of posts for each user using the API https://jsonplaceholder.typicode.com/users/USERID/posts.
The libraries used are Ktor, Jetpack Compose, and JetBrains Serialization.
* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


