package org.example

class DrawState {
    private var state: Int = 0
    private val draw = Draw()

    fun start(): String {
        state = 0
        return draw.getState(state)
    }

    fun gameOver(): String {
        state=6
        return draw.getState(state)
    }

    fun errorStep(): String {
        state++
        return draw.getState(state)
    }

    fun state(): String {
        return draw.getState(state)
    }
}