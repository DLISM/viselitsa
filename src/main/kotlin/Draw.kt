package org.example

class Draw {
    fun start(): String {
        return """
              |------
              |     |
              |     
              |    
              |    
              |
            =====
        """.trimIndent()
    }

    fun stepOne(): String {
        return """
              |------
              |     |
              |     O
              |    
              |    
              |
            =====
        """.trimIndent()
    }


    fun stepTwo(): String {
        return """
              |------
              |     |
              |     O
              |     |
              |    
              |
            =====
        """.trimIndent()
    }

    fun stepThree(): String {
        return """
              |------
              |     |
              |     O
              |    /|
              |    
              |
            =====
        """.trimIndent()
    }

    fun stepFour(): String {
        return """
              |------
              |     |
              |     O
              |    /|\
              |    
              |
            =====
        """.trimIndent()
    }

    fun stepFive(): String {
        return """
              |------
              |     |
              |     O
              |    /|\
              |    / 
              |
            =====
        """.trimIndent()
    }

    fun stepSix(): String {
        return """
              |------
              |     |
              |     O
              |    /|\
              |    / \
              |
            =====
        """.trimIndent()
    }

    fun getState(step: Int): String {
        return when (step) {
            0 -> start()
            1 -> stepOne()
            2 -> stepTwo()
            3 -> stepThree()
            4 -> stepFour()
            5 -> stepFive()
            else -> stepSix()
        }
    }
}