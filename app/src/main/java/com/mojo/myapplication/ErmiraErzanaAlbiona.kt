package com.mojo.myapplication

fun main() {
    val zoo = Zoo(TestInput())

    while (true) {
        programDescription()

        selectFeatureBasedOnUserInput(zoo)
    }
}
