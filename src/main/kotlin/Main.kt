package org.example

import java.io.File
import kotlin.random.Random

fun main() {
    val words: List<String> = File("words.txt").readLines().filter { it.isNotBlank() }

    while (true) {
        val drawState = DrawState()
        val index: Int = Random.nextInt(0, words.size - 1)
        val currentWord = words[index];
        val errorLetters = mutableListOf<String>()

        val randomSing: Int = Random.nextInt(0, currentWord.length - 1)
        var word = Word(currentWord, randomSing)
        var tryCount = word.getMask().count() { it == '_' }

        println(drawState.start())
        println("Слова из ${currentWord.length} букв")

        while (tryCount > 0 && word.getMask().count() { it == '_' } > 0) {
            println(word.getMask())
            println("Осталось ${tryCount} попиток")
            println("\nВведите букву")
            val userSing = input()
            val singInWord: Boolean = word.isInWord(userSing)
            if (singInWord) {
                word.setFindSing(userSing)
                println(drawState.state())
                tryCount--
            } else {
                println("Такой буквы нет в слове")
                if (!errorLetters.contains(userSing)) {
                    errorLetters.add(userSing)
                    println(drawState.errorStep())
                    tryCount--
                } else {
                    println(drawState.state())
                }
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

        println("Хотите продолжить игру? ДА/НЕТ")
        val continueGame = readln()
        if (continueGame.uppercase() != "ДА") {
            break
        }
    }

}

fun input(): String {
    var userInput: String
    while (true) {
        userInput = readln().trim()
        if (userInput.isEmpty() || userInput.length > 1) {
            println("Введите корректное значение (одна буква)")
        } else {
            return userInput.uppercase()
        }
    }
}