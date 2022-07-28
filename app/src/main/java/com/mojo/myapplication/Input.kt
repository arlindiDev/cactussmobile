package com.mojo.myapplication

import java.io.File

fun main() {
    val realPrinter = RealPrinter()
    realPrinter.logLn("Can we send logs to our servers [Y\\N]: ")

    val realInput = RealInput()
    val answer = realInput.input()

    val printer = if(answer == "Y") {
       FilePrinter()
    } else {
        RealPrinter()
    }

    val zooA = ZooA(realInput, printer)

    zooA.addAnimal()
}

// Concept: Dependency Injection
//ZooA has 2 dependencies:
//  Input
//  Printer

class ZooA(val input: Input, val printer: Printer) {
    val animals = mutableListOf<String>()

    fun addAnimal() {
        printer.logLn("Please type the animals name: ")
        val animalName = input.input()

        printer.logLn("You just typed $animalName")
        animals.add(animalName)
    }
}

interface Printer {
    fun logLn(message: String)

    fun log(message: String)
}

class RealPrinter: Printer {
    override fun logLn(message: String) {
        println(message)
    }

    override fun log(message: String) {
        print(message)
    }
}

class FilePrinter: Printer {
    override fun logLn(message: String) {
        println(message)
        File("/Users/arlindhajredinaj/Desktop/ardit.txt").appendText(message)
    }

    override fun log(message: String) {
        print(message)
        File("/Users/arlindhajredinaj/Desktop/ardit.txt").appendText(message)
    }

}

class FakePrinter: Printer {
    override fun logLn(message: String) {

    }

    override fun log(message: String) {

    }
}

interface Input {
    fun inputInt(): Int

    fun userInputAnimalType(): String

    fun input(): String
}

class RealInput: Input {
    override fun inputInt() = readLine()!!.toInt()

    override fun userInputAnimalType() = input()

    override fun input() = readLine()!!
}
