# scramble-api

## Overview

This simple project has the purpose of showing how to build a REST API using the [compojure-api](https://github.com/metosin/compojure-api) framework.

I'm also using [ring-cors](https://github.com/r0man/ring-cors) to configure CORS.

## Running Tests

Tests have been implemented using [midje](https://github.com/marick/Midje). Execute the following command to run all tests:

    lein do clean, midje

You should get an output similar to the following:

        = Namespace scramble-api.api-test
        Checking api tests
        Checking Test scramble api returns true when a portion of str1 can be rearranged to match str2
        Checking Test scramble api returns false when a portion of str1 cannot be rearranged to match str2
        Checking Test call for an invalid resource
        = Namespace scramble-api.scramble-test
        Checking scramble? tests
        Checking first example from specs
        Checking second example from specs
        Checking third example from specs
        All checks (9) succeeded.

## Building the App

Execute the following command to build the app:

    lein do clean, ring uberjar

This will generate a jar file with the app named `./target/server.jar`.

## Running the App

### Development

Execute the following command to start the app locally:

    lein ring server

The service will be made available on the url [`http://localhost:3000`](http://localhost:3000). 

You should be able to see a [swagger](https://swagger.io/) page.

### Production

To run the app in production mode, execute the following command:

   java -jar target/server.jar

