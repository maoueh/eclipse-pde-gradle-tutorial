# Initial State

What you see on the [master](../../../tree/master) is the initial state of the
repository before gradelizing it.

This repository is a trimmed down replication of what we have where I work.
I tried to put together a fairly complex repository with multiple moving
parts. Indeed, building a single plug-in is completely different than
building an RCP application depending on a plug-in itself depending
on plain Java projects.

In the initial state, we have 3 plain Java projects:

 * [api-services](../../../tree/master/api/services)
 * [framework-core](../../../tree/master/framework/core)
 * [framework-services](../../../tree/master/framework/services)

All this project are valid OSGI bundles having a valid `MANIFEST.MF` file
defining dependencies correctly. All these files are managed manually
for each project.

We also have 6 vendor projects:

 * [vendor-guava](../../../tree/master/vendor/guava)
 * [vendor-jackson-annotations](../../../tree/master/vendor/jackson-annotations)
 * [vendor-jackson-core](../../../tree/master/vendor/jackson-core)
 * [vendor-jackson-databind](../../../tree/master/vendor/jackson-databind)
 * [vendor-jackson-datatype-guava](../../../tree/master/vendor/jackson-datatype-guava)
 * [vendor-junit](../../../tree/master/vendor/junit)

These projects are JAR only projects. They all have customized `MANIFEST.MF`
file to more easily work as OSGI bundles. Again, all these are managed
manually.

Finally, we have 4 Eclipse projects:

 * [plugin](../../../tree/master/plugin)
 * [rcp](../../../tree/master/rcp)
 * [feature](../../../tree/master/feature)
 * [update-site](../../../tree/master/update-site)

The [plugin](../../../tree/master/plugin) project is a plug-in that is used by
the [rcp](../../../tree/master/rcp) project but can also be deployed stand-alone.
The [feature](../../../tree/master/feature) project is used to
group together all plugins required by the [plugin](../../../tree/master/plugin)
project. Finally, the [update-site](../../../tree/master/update-site) is used to
create the update site to distribute the [plugin](../../../tree/master/plugin) project
and simply include the [feature](../../../tree/master/feature) feature definition.

Hierarchy is:

```
    ├── api
    │   └── services
    ├── feature
    ├── framework
    │   ├── core
    │   └── services
    ├── plugin
    ├── rcp
    ├── update-site
    └── vendor
        ├── guava
        ├── jackson-annotations
        ├── jackson-core
        ├── jackson-databind
        ├── jackson-datatype-guava
        └── junit
```

## Target Platform

At work, we also have a custom target platform that is store in the repository
and is used to build [plugin](../../../tree/master/plugin) and
[rcp](../../../tree/master/rcp) projects. However, it is not present
in this repository. Main reason was to reduce the size as our target platform
includes all the jar required in the build process.

For this tutorial, you can use your current Eclipse as the target platform as
both [plugin](../../../tree/master/plugin) and [rcp](../../../tree/master/rcp)
projects should be buildable with almost any version of Eclipse.

## Build System

At work, we have a custom build system that works as following. Each project
has a special XML file defining the project: its dependencies, version,
configuration, etc. Then, we have a script (it's a full Java project in fact)
that reads this file and from information contained in it, generates an
`ant` build script. We then simply run `ant` to build the project while
never really caring about `ant`.

This however only works for plain Java projects and the build is not capable
of building Eclipse projects (headless).

## Eclipse

Eclipse development in this state is really easy. You must have a valid
JDK for a Java 6 execution environment and set your current Eclipse as
your target platform.

To develop, open Eclipse and choose an empty workspace. Import all projects
from the root repository and that's it.

### Settings

All projects (in fact, all source projects) have project specific settings
stored in the repository. This make it really easy to share settings
between users. At work, this is check-in in the repository but settings
are stored in a central repository and can be copied automatically to all
projects.

This central repository and automatic copying were not replicated in this
repository. However, settings are checked-in like what I have at work.
