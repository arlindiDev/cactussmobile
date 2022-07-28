package com.mojo.myapplication

fun main() {
    val zooA = ZooA(RealInput())

    val testZoo = ZooA(TestInput())

    House(Dog())

    House(Cat())
}

class House(animal: Animal)


class ZooA(input: Input)

interface Input {
    fun inputInt(): Int

    fun userInputAnimalType(): String

    fun  input(): String
}

class RealInput: Input {
    override fun inputInt() = readLine()!!.toInt()

    override fun userInputAnimalType() = input()

    override fun input() = readLine()!!
}

class TestInput: Input {
    override fun inputInt() = 5

    override fun userInputAnimalType() = "Dog"

    override fun input() = "DiqkaTjeter"
}

class Printer {
    fun print(message: String) = println(message)
}
