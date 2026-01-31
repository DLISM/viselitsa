package org.example

class Word (private val currentWord: String, randomSingPosition: Int){
    private var mask: String
    private var list: MutableList<Sing>

    init {
        list = currentWord.mapIndexed { index, char -> Sing(char.toString(), isFind = index == randomSingPosition) }.toMutableList()
        mask = generateMask()
    }

    fun getMask():String {
        return mask
    }

    private fun generateMask(): String {
        return buildString {
            for (letter in list) {
                append(if(letter.isFind) letter.sing else '_')
            }
        }
    }

    fun isInWord(letter: String): Boolean {
        return letter.uppercase() in currentWord
    }

    fun setFindSing(letter: String) {
        for (item in list) {
            if (item.sing == letter.uppercase() && !item.isFind) {
                item.isFind = true
            }
        }
        mask = generateMask()
    }
}