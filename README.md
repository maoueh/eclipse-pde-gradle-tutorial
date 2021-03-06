# Gradle Eclipse Building

Purpose of this repository is to give some potential solutions at
converting a set of projects to Gradle. Converting plain Java projects
to Gradle have been discussed a lot and is not the main focus here. Instead,
we will focus on conversion of Eclipse related projects (plugin, feature,
RCP application, update site).

Objectives of this tutorial are:

 * Gradle usage
 * Headless build of projects
 * Headless build of an update site
 * Development works within Eclipse IDE

## Usage

This repository is built in a step by step way. Each step being represented in
a specific branch. The `master` branch being the initial state of the tutorial.
Each subsequent branch builds up a bit to the final state.

To follow, you can simply check the `Tutorial` section which describes the
step and what documents to read.

## Tutorial

## Tutorial

 * [Initial state](../master/tutorial/initial_state.md) (branch [master](../../tree/master))

   The initial state the project. Good background about project in general.

 * [Gradlelized](../gradlelized/tutorial/gradlelizing.md) (branch [gradlelized](../../tree/gradlelized))

   Initial transformation of project not depending to use a Gradle build.

 * [Single Vendors Project](../single-vendor/tutorial/single-vendor.md) (branch [single-vendor](../../tree/single-vendor))

   An attempt at reducing vendors projects merging 6 projects together into a single
   one. Still no Eclipse Gradlelized build but good in-between steps to remove
   some unneeded projects.
