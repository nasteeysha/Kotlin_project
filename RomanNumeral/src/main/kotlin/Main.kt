package RomanNumber

fun main() {
    val roman1 = RomanNumber("V")
    val roman2 = RomanNumber(100000)

    //roman2.decimalValue = 10000
    val roman3 = RomanNumber(roman1) //на основе другого объекта

    println("Вывод чисел")
    println(roman1) // Результат: V
    println(roman2) // Результат: X
    println(roman3) // Результат: V

    println("Вывод результатов вычисления")
    roman2+=roman1
    println(roman2)
    val sum = roman1+roman2
    println(sum) // Результат: XV

    val min = roman2.minus(roman1)
    println(min) // Результат: V

    val multiplication = roman1.times(roman2)
    println(multiplication) // Результат: L

    val division = roman2.div( roman1)
    println(division) // Результат: II

    val positive = roman1.unaryPlus()
    println(positive) // Результат: V

    val negative = roman1.unaryMinus()
    println(negative) // Результат: -V


}
