# Single Vendors Project

After gradlelizing the project, my next aim was to remove all this vendor
projects. And idea proposed by [carlolf](https://github.com/carlolf) on
the Wuff issue on Eclipse headless build but still do Eclipse development.

Idea is simple. We removed all `vendor-*` projects and replaced it with a
single `vendors` project. This project `vendors` project is a single
OSGI bundle exporting multiple jars. Then all projects depends on this
bundle. Here the `MANIFEST.MF` file for this project:

```
Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: Acme Vendors
Bundle-SymbolicName: com.acme.vendors
Bundle-Version: 1.0.0
Bundle-RequiredExecutionEnvironment: JavaSE-1.7
Bundle-ClassPath: lib/guava-17.0.0.jar,
 lib/jackson-annotations-2.3.3.jar,
 lib/jackson-core-2.3.3.jar,
 lib/jackson-databind-2.3.3.jar,
 lib/jackson-datatype-guava-2.3.3.jar,
 lib/junit-4.10.0.jar
Export-Package: ...
```

This all works correctly inside Eclipse. However, this is a simple in-between
step for now. Indeed, Gradle build of Eclipse stuff has not been addressed
right now with those changes. But it's still a good step forward as I removed
many projects.

Next ideas are:

  * Automate `vendors` project building.

    Idea would be to add a Gradle build script in project listing
    dependencies on projects. Using Gradle API, we could transitively
    find all required JAR files and then build project automatically.

  * Transformed into a target platform

    This would be very likely the `vendors` project but as a target
    platform. That should be easier for Wuff to work with but is not
    clear how it would work for non-OSGI ready JAR files.