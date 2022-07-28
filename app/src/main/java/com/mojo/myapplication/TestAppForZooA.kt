package com.mojo.myapplication

fun main() {
    whenAddAnimalIsCalledAnimalsListShouldNotBeEmpty()
    addsMultipleAnimalsToTheZoo()
}

fun whenAddAnimalIsCalledAnimalsListShouldNotBeEmpty() {
    val zoo = ZooA(TestInput(), FakePrinter())

    zoo.addAnimal()

    println(zoo.animals.isNotEmpty())
}

fun addsMultipleAnimalsToTheZoo() {
    val zoo = ZooA(TestInput(), FakePrinter())

    zoo.addAnimal()
    zoo.addAnimal()
    zoo.addAnimal()
    zoo.addAnimal()
    zoo.addAnimal()

    println(zoo.animals.size == 5)
    println(zoo.animals[0] == "DiqkaTjeter")
    println(zoo.animals[1] == "Dog")
    println(zoo.animals[2] == "Cat")
    println(zoo.animals[3] == "DiqkaTjeter")
    println(zoo.animals[4] == "Dog")
}

class TestInput: Input {
    var index = 0
    override fun inputInt() = 5

    override fun userInputAnimalType() = "Dog"

    override fun input(): String {
        val list = listOf("DiqkaTjeter", "Dog", "Cat")

        return list[index++ % list.size]
    }
}

// real app me perdore println()
// test app me perdore kurrgjo hiq

