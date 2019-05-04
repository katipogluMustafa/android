# Android Studio

## [Get Android Studio SHA-1 Key](https://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode)

1. Open Android Studio
2. Open your Project
3. Click on Gradle (From Right Side Panel, you will see Gradle Bar)
4. Click on Refresh (Click on Refresh from Gradle Bar, you will see List Gradle scripts of your Project)
5. Click on Your Project (Your Project Name form List (root))
6. Click on Tasks
7. Click on Android
8. Double Click on signingReport (You will get SHA1 and MD5 in Run Bar(Sometimes it will be in Gradle Console))
9. Select app module from module selection dropdown to run or debug your application
