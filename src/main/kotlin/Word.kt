package org.example

class Word(private val currentWord: String, randomSingPosition: Int) {
    private val normalizedWord: String = currentWord.uppercase()
    private var mask: String
    private var list: MutableList<Letter>

    init {
        list = normalizedWord.mapIndexed { index, char -> Letter(char, isFound = index == randomSingPosition) }.toMutableList()
        mask = generateMask()
    }

    fun getMask(): String {
        return mask
    }

    private fun generateMask(): String {
        return buildString {
            for (letter in list) {
                append(if (letter.isFound) letter.char else '_')
            }
        }
    }

    fun isInWord(letter: String): Boolean {
        if (letter.isEmpty()) return false
        return letter.uppercase()[0] in normalizedWord
    }

    fun setFindSing(letter: String) {
        val ch = letter.uppercase()[0]
        for (item in list) {
            if (item.char == ch && !item.isFound) {
                item.isFound = true
            }
        }
        mask = generateMask()
    }
}