package com.mojo.myapplication

fun main() {
    val computer = Computer(i5())
    println(computer.description())

    println("After 5 years, Upgrade")
    computer.processor = i7()
    println(computer.description())
}

class Computer(var processor: Processor) {
    fun description(): String {
        return "Macbook CPU=${processor.name()}"
    }
}

interface Processor {
    fun name(): String
}

class i5: Processor {
    override fun name() = "i5"
}

class i7: Processor {
    override fun name() = "i7"
}
