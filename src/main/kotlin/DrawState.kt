package org.example

class DrawState {
    private var state: Int = 0
    private val draw = Draw()

    fun start(): String {
        state++
        return draw.start()
    }

    fun gameOver(): String {
        state=0
        return draw.stepSix()
    }

    fun errorStep(): String {
        state++

        if(state == 1)
            return draw.stepTwo()
        if(state == 2)
            return draw.stepThree()
        if(state == 3)
            return draw.stepFour()
        if(state == 4)
            return draw.stepFive()
        else
            state=0
            return draw.stepSix()
    }
}