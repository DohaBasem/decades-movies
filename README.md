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