package com.example.madscalucator

object Utils {


    fun MADSCalculation(input: String): Double {
        if (input.contains("-") || input.contains("/")) {
            val operands = input.split("[/-]".toRegex()).toTypedArray()
            var index_operator: Int
            var operator: Char
            var operand: String
            operand = operands[0]
            var result: Double = MADSCalculation(operand)
            index_operator = operand.length
            var counter = 1
            while (counter < operands.size) {
                operator = input[index_operator]
                operand = operands[counter]
                if (operator == '/') result /= MADSCalculation(operand) else result -= MADSCalculation(
                    operand
                )
                index_operator += operand.length + 1
                counter++
            }
            return result
        } else if (input.contains("*")) {
            val operands: Array<String> = input.split("\\*".toRegex(), 2).toTypedArray()
            return MADSCalculation(operands[0]) * MADSCalculation(operands[1])
        } else if (input.contains("+")) {
            val operands: Array<String> = input.split("\\+".toRegex(), 2).toTypedArray()
            return MADSCalculation(operands[0]) + MADSCalculation(operands[1])
        } else if (input.matches("[0-9]*".toRegex())) {
            return input.toDouble()
        } else {
            throw RuntimeException()
        }
    }

}