#!/bin/bash

./gradlew build

cp ./build/libs/recipes-1.0-SNAPSHOT.jar ../paper-server/plugins/recipes.jar
