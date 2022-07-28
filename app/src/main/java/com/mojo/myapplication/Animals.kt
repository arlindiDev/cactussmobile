package com.mojo.myapplication


abstract class Animal(
    open var name: String,
    open var age: Int,
    open var food: String,
    open var description: String
) {

    abstract fun isOld(): Boolean
    abstract fun eat()
    abstract fun sleep()
    abstract fun move()
}

data class Dog(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 10
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Cat(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 11
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Tiger(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 20
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Snake(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 20
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Turtle(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 100
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Crocodile(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 50
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Penguin(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 15
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Panda(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 18
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }
}

data class Monkey(
    override var name: String,
    override var age: Int,
    override var food: String,
    override var description: String,
    var isInjured: Boolean
) : Animal(name, age, food, description) {

    override fun isOld(): Boolean {
        return age >= 20
    }

    override fun move() {
        println("$name is moving...")
    }

    override fun eat() {
        println("$name is eating...")
    }

    override fun sleep() {
        println("$name is sleeping...")
    }

    fun doTricks() {
        if (!isInjured) {
            println("$name is doing tricks!")
        } else {
            println("$name can't do tricks, it's injured!!!")
        }
    }
}
