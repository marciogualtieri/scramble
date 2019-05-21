# scramble-ui

## Overview

The purpose of this project is to showcase my skills developing a single-page application using [re-frame](https://github.com/Day8/re-frame).

This app is the front-end for the [scramble-api](../scramble-api) project.

## Running Tests

## Running the App

To start the app, execute the following command:

    lein do clean, figwheel dev

The service will be made available at the url  [`http://localhost:3449`](http://localhost:3449).

Figwheel will automatically push cljs changes to the browser.

## Building the App

To compile clojurescript to javascript:

    lein do clean, cljsbuild once min


## Developer's Guide

For my own future reference, [this resource](https://github.com/Day8/re-frame/blob/master/docs/Talking-To-Servers.md) was useful when figuring out how to fetch data from the back-end.
