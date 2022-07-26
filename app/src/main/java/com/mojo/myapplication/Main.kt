package com.mojo.myapplication

fun main() {
    val dog1 = Dog("Bubi", 4,5)
    val dog3 = Dog("Bubi", 4,5)
    val dog2 = Dog("Reksi", 4,2)
    val cat1= Cat("Egjiptiane", 4,1)
    val snake1 = Snake ("Helmues",2,2)

    val kafshet: List<Animal> = listOf(dog1, cat1, dog2, dog3, snake1) // List<Animal>

    for (kafsha in kafshet) {
        println(kafsha)
        kafsha.move()
    }
}

abstract class Animal(open var name: String) {
    abstract fun move()
}

data class Dog(
    override var name: String,
    var numriKembeve: Int ,
    var age: Int
    ): Animal(name) {

    override fun move() {
        println("me putra")
    }
}

data class Cat(
    override var name: String,
    var numriKembeve: Int ,
    var age: Int
): Animal(name) {
    override fun move() {
        println("si zoj")
    }
}

data class Snake(
    override var name: String,
    var gjatesia : Int ,
    var age: Int
): Animal(name) {
    override fun move() {
        println("zvarritet")
    }
}

