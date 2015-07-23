# Gradlelizing

From the [initial state](../master/tutorial/initial_state.md), the next step
performed in our quest to Eclipse building is to convert projects to Gradle.

I will not put that much details on how I did it as it's relatively easy to
find this information on the internet. Here the higher level steps I performed:

 1. Renamed `src/java` to `src/main/java` in all Java projects.
 2. Added `src/test/java` in Java projects containing unit tests.
 3. Moved unit tests from source folder `src/java` to `src/test/java`.
 4. Fixed build path of each Java projects and adjusted source sets.
 5. Added root `settings.gradle` and `build.gradle` files.
 6. Added gradle build script in `api-services`, `framework-core` and
    `framework-services`.

Note that I did not add build scripts for Eclipse projects. This is normal
since next steps will explore different ideas about how to build Eclipse
projects using Eclipse.

Moreover, I did not remove vendor projects. This is simply because it's not
clear how architecture will be. It might change depending on the actual
solution used. As such, it's better to leave them like this and simply
make the necessary modifications in another branch.