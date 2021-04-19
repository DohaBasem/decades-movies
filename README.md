# decades-movies

## General description
This is a sample app, for listing movies, categorizing them and showing there details.

## Mock Server Project
* Link to apiary project: https://moviedecades.docs.apiary.io/#.
* Mock base url used: https://private-e5d2fb-moviedecades.apiary-mock.com.

## Project Product Flavors
* The includes 3 product flavors, based on the server mode(mock, staging, production). But Since there is only mock server, to run the app you need to select **mockDebug** as your variant.
* Although this is not currently required, but each flavor has its own name and application id by appending a suffix to the app id for each flavor. This makes it easier for tetsters to have the app with different flavors downloaded side by side.

## Git Flow
The **develop** branch was taken initially from the **main**, then each feature or enhancement is done in a separate branch
taken from the develop branch.  After the feature branch is ready, all commits are squashed into a single commit and the feature branch is rebased on top of the develop , and then merged into the develop.

## Code structure
* The used architectural pattern is MVVM
* The app module depends on the baseArchitecture module which includes base classes that contains the minimal setup to implement the MVVM architecture pattern, and the interafces for the helpers required by the app such as the (loggingHelper, SchedularHelper, SerializationHelper, ...) which are then implemented in the main app module. This baseArchitecture module is portable unrelated to any of the detials of the app itself

## UML Diagrams

* Caching Flow for movies

![List_Loading_Flow](https://user-images.githubusercontent.com/6968550/115269037-33da0280-a13b-11eb-90ed-76878f85178b.png)

## Deliverables
* [Demo Video](https://drive.google.com/file/d/10hYEZ3HjuyRRVOvrHru1ThbDH22NqVcx/view?usp=sharing). 
* [Apk Link](https://drive.google.com/file/d/1wf5xT7wOF1MB-woI0TU6072pKWW5Uukx/view?usp=sharing). 

## Libraries used
* Koin for dependency injection
* Glide for image loading
* Mockkito for unit tests
* RxJava3
* Retrofit
* Room
* Navigation Component
