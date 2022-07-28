package com.mojo.myapplication

fun main() {
    theFunctionShouldReturnUppercaseAforArdit()

    whenTheFirstCharacterIsLowercaseShouldReturnUppercase()

    shouldReturnEwhenTheNameIsElion()
}

fun theFunctionShouldReturnUppercaseAforArdit() {
    println(upperCaseFirst("Ardit") == "A")
}

fun whenTheFirstCharacterIsLowercaseShouldReturnUppercase() {
    println(upperCaseFirst("ardit") == "A")
}

fun shouldReturnEwhenTheNameIsElion() {
    println(upperCaseFirst("elion") == "E")
}

// The real PROGRAM
fun upperCaseFirst(name: String): String {
    return name.first().uppercase() //A
}
