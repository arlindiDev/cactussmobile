package com.mojo.myapplication

var color = "WHITE"

fun main() {
    color = "BLUE"

    val color = "RED"
    println(color)

    val automjeti = Automjeti(MeNaft(), Kuq(), "Golf")

    val automjeti2 = Automjeti(MeRrym(), Kalter(), "Tesla")

    automjeti.drive()
    automjeti2.drive()

    var parkingu = listOf(automjeti, automjeti2)

    automjeti2.ngjyra = Zeze()
}

class Automjeti(
    var motor: Motor,
    var ngjyra: Ngjyra,
    var tipi: String,
    ) {

    fun drive() {
        motor.turnOn()
        motor.makeSound()
        println(color)
    }
}

open class Ngjyra
class Kuq: Ngjyra()
class Kalter: Ngjyra()
class Zeze: Ngjyra()

abstract class Motor {
    abstract fun turnOn()

    abstract fun makeSound()
}

class MeNaft: Motor() {
    override fun turnOn() {
        println("Celsi, Vroom!")
    }

    override fun makeSound() {
        println("VROOM, VROOM!")
    }
}
class MeRrym: Motor() {
    override fun turnOn() {
        println("Start Pressed!")
    }

    override fun makeSound() {
        println("...")
    }
}

class MeBenzin: Motor() {
    override fun turnOn() {
        println("Start Pressed!")
    }

    override fun makeSound() {
        println("vroom")
    }
}
class Hibrid: Motor(){
    override fun turnOn() {
        println("Start Pressed!")
    }

    override fun makeSound() {
        println("..., vroom")
    }
}
