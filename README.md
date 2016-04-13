# MVP-CleanArchitecture-DI-Rx-BaseProject

### Summary

This sample is the base for many of the variants. It showcases a simple
implementation of the Model-View-Presenter pattern with no architectural
frameworks. It uses manual dependency injection to provide a repository with
local and remote data sources. Asynchronous tasks are handled with callbacks.

<img src="https://github.com/googlesamples/android-architecture/wiki/images/mvp.png" alt="Diagram"/>

Note: in a MVP context, the term "view" is overloaded:

  * The class android.view.View will be referred to as "Android View"
  * The view that receives commands from a presenter in MVP, will be simply called
"view".

### Fragments

It uses fragments for two reasons:

  * The separation between Activity and Fragment fits nicely with this
implementation of MVP: the Activity is the overall controller that creates and
connects views and presenters.
  * Tablet layout or screens with multiple views take advantage of the Fragments
framework.

### Key concepts

There are currently one feature in the app:

  * <code>Login</code>

Each feature has:

  * A contract defining the view and the presenter
  * An Activity which is responsible for the creation of fragments and presenters
  * A Fragment which implements the view interface.
  * A presenter which implements the presenter interface

In general, the business logic lives in the presenter and relies on the view to
do the Android UI work.

The view contains almost no logic: it converts the presenter's commands to UI
actions and listens to user actions, which are passed to the presenter.

Contracts are interfaces used to define the connection between views and
presenters.

### Dependencies

  * Common Android support libraries (<code>com.android.support.\*)</code>
  * Android Testing Support Library (Espresso, AndroidJUnitRunner…)
  * Mockito
  * Guava (null checking)

## Features

### Complexity - understandability

#### Use of architectural frameworks/libraries/tools:

None

#### Conceptual complexity

Low, as it's a pure MVP implementation for Android

### Testability

#### Unit testing

High, presenters are unit tested as well as repositories and data sources.

#### UI testing

High, injection of fake modules allow for testing with fake data

### Code metrics

Compared to a traditional project with no architecture in place, this sample
introduces additional classes and interfaces: presenters, a repository,
contracts, etc. So lines of code and number of classes are higher in MVP.

### Maintainability

#### Ease of amending or adding a feature

High.

#### Learning cost

Low. Features are easy to find and the responsibilities are clear. Developers
don't need to be familiar with any external dependency to work on the project.



### Requirements

 - [Android SDK](http://developer.android.com/sdk/index.html).
 - Android [6.0 (API 23) ](http://developer.android.com/tools/revisions/platforms.html#6.0).
 - Android SDK Tools
 - Android SDK Build tools 23.0.2
 - Android Support Repository
 - Android Support library

### Building

To build, install and run a debug version, run this from the root of the project:

    ./gradlew installRunDebug

### Testing

For Android Studio to use syntax highlighting for Automated tests and Unit tests you **must** switch the Build Variant to the desired mode.

To run **pmd**, **checkstyle** and **findbug** checks on your machine:

    ./gradlew check

To run **unit** tests on your machine:

    ./gradlew testDebugUnitTest

To run **automated** tests on connected devices:

    ./gradlew connectedDebugAndroidTest

### Thanks

Thanks to the following for the very useful projects (which this project is based of)!

[hitherejoe] (https://github.com/hitherejoe/Android-Boilerplate)
[googlesamples] (https://github.com/googlesamples/android-architecture)
