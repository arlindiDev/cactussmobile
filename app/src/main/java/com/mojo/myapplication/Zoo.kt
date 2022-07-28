package com.mojo.myapplication

class Zoo(input: Input) {
    private val animals = mutableListOf<Animal>()

    fun addAnimal() {
        val animalData = askUserForAnimalData()

        with(animalData) {
            val animal = when (animalType) {
                "Dog" -> Dog(name, age, food, description)
                "Cat" -> Cat(name, age, food, description)
                "Tiger" -> Tiger(name, age, food, description)
                "Snake" -> Snake(name, age, food, description)
                "Turtle" -> Turtle(name, age, food, description)
                "Crocodile" -> Crocodile(name, age, food, description)
                "Penguin" -> Penguin(name, age, food, description)
                "Panda" -> Panda(name, age, food, description)
                "Monkey" -> {
                    print("Type true if monkey is injured, otherwise type false: ")
                    Monkey(name, age, food, description, input().toBoolean())
                }
                else -> { null }
            }

            animals.add(animal!!)
        }

        println(animals)
    }

    fun removeAnimal() {
        val animalData = askUserForAnimalData()

        with(animalData) {
            when (animalType) {
                "Dog" -> animals.remove(Dog(name, age, food, description))
                "Cat" -> animals.remove(Cat(name, age, food, description))
                "Tiger" -> animals.remove(Tiger(name, age, food, description))
                "Snake" -> animals.remove(Snake(name, age, food, description))
                "Turtle" -> animals.remove(Turtle(name, age, food, description))
                "Crocodile" -> animals.remove(Crocodile(name, age, food, description))
                "Penguin" -> animals.remove(Penguin(name, age, food, description))
                "Panda" -> animals.remove(Panda(name, age, food, description))
                "Monkey" -> {
                    print("Type true if monkey is injured, otherwise type false: ")
                    val isInjured = input().toBoolean()
                    animals.remove(Monkey(name, age, food, description, isInjured))
                }
                else -> {}
            }
        }

        println(animals)
    }

    fun askUserForAnimalData(): AnimalUserInput {
        print("What animal do you want to add in the zoo? ")
        val animalType = userInputAnimalType()

        print("Type animal's name: ")
        val name = input()
        print("Type animal's age: ")
        val age = inputInt()
        print("Type animal's food: ")
        val food = input()
        print("Describe the animal: ")
        val description = input()

        return AnimalUserInput(animalType, name, age, food, description)
    }

    fun countAnimals() {
        println("Number of animals: ${animals.size}")
    }

    fun countAnimalsOfSameType() {
        print("What type of animal do you want to count? ")
        val animalType = userInputAnimalType()

        val animalsOfSameType = getAnimalsOfSameType(animals, animalType).size
        println("Number of ${animalType}s: $animalsOfSameType")
    }

    fun numberOfPeople() {
        val people = (0..200).random()
        println("Number of people in the zoo is $people")
    }

    fun oldAnimals() {
        val oldAnimals: MutableList<Animal> = mutableListOf()

        for (animal in animals) {
            if (animal.isOld()) {
                oldAnimals.add(animal)
            }
        }
        println(oldAnimals)
    }

    fun animalActions() {
        print("What type of animal do you want to do stuff? ")
        print("What do you want the animals to do? ")
        val action = readLine()!!

        val animalType = userInputAnimalType()

        when (action) {
            "move" -> {
                val animalsOfSameType = getAnimalsOfSameType(animals, animalType)
                for (animal in animalsOfSameType) {
                    animal.move()
                }
            }
            "eat" -> {
                val animalsOfSameType = getAnimalsOfSameType(animals, animalType)
                for (animal in animalsOfSameType) {
                    animal.eat()
                }
            }
            "sleep" -> {
                val animalsOfSameType = getAnimalsOfSameType(animals, animalType)
                for (animal in animalsOfSameType) {
                    animal.sleep()
                }
            }
            "tricks" -> {
                for (animal in animals) {
                    if (animal is Monkey) {
                        animal.doTricks()
                    }
                }
            }
        }
    }

    fun getAnimalsOfSameType(animals: MutableList<Animal>, animalType: String): List<Animal> {
        return animals.filter {
            it.javaClass.canonicalName!!.split(".").last() == animalType
        }
    }
}
