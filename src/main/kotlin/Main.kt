package org.example

import java.io.File
import kotlin.random.Random

fun main() {
    val words: List<String> = File("words.txt").readLines()

    while (true) {
        val drawState = DrawState()
        val index: Int = Random.nextInt(0, words.size - 1)
        val currentWord = words[index];

        val randomSing: Int = Random.nextInt(0, currentWord.length - 1)
        var word = Word(currentWord, randomSing)
        var tryCount = word.getMask().count() { it == '_' }

        println(drawState.start())
        println("Слова из ${currentWord.length} букв")

        for (i in 0..tryCount - 1) {
            println(word.getMask())
            println("Осталось ${tryCount - i} попиток")
            println("\nВведите букву")
            val userSing = input()
            val singInWord: Boolean = word.isInWord(userSing)
            if (singInWord) {
                word.setFindSing(userSing)
            } else {
                println(drawState.errorStep())
                println("Такой буквы нету в слове")
            }
        }

        if (word.getMask().count() { it == '_' } > 0) {
            println("Было загадано слово: $currentWord")
            println(drawState.gameOver())
        } else {
            println("===============================================")
            println("             Вы угадали слово!                 ")
            println("===============================================")
        }

        println("Хотите продолжит игру? ДА/НЕТ")
        val continueGame = readln()
        if (continueGame.uppercase() != "ДА") {
            break
        }
    }

}

fun input(): String {
    var userInput = ""
    while (true) {
        userInput = readln()
        if (userInput.isEmpty() || userInput.length > 1)
            println("Введите корректное значение")
        else
            break
    }

    return userInput
}