package com.mojo.myapplication

import kotlin.system.exitProcess

fun selectFeatureBasedOnUserInput(zoo: Zoo) {
    with(zoo) {
        when (zoo.input.inputInt()) {
            1 -> addAnimal()
            2 -> removeAnimal()
            3 -> countAnimals()
            4 -> countAnimalsOfSameType()
            5 -> numberOfPeople()
            6 -> oldAnimals()
            7 -> animalActions()
            8 -> exitProcess(0)
        }
    }
}
