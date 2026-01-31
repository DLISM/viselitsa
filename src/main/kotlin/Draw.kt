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
}