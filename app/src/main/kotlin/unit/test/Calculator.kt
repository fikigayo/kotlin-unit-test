package unit.test

import java.lang.IllegalArgumentException

class Calculator {
    fun sum(x: Int, y: Int): Int {
        return x+y
    }

    fun divide(x: Int, y: Int): Int {
        if(y == 0){
            throw IllegalArgumentException("Cant divide by zero")
        }else{
            return x/y
        }
    }
}