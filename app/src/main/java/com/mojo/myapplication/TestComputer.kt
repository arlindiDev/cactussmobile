package com.mojo.myapplication

fun main() {
    println(testIfProcessorIsi5())
    println(testUpdateProcessor())
    println(downgrade())
}

fun testIfProcessorIsi5(): Boolean {
    val computer = Computer(i5())
    return computer.description() == "Macbook CPU=i5"
}

fun testUpdateProcessor(): Boolean {
    val computer = Computer(i5())
    computer.processor = i7()
    return computer.description() =="Macbook CPU=i7"
}

fun downgrade(): Boolean {
    val computer = Computer(i7())
    computer.processor = i5()
    return computer.description() =="Macbook CPU=i5"
}

