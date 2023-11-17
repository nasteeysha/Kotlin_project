package RomanNumber



class RomanNumber {
    private val romanToDecimal = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

   private val decimalToRoman = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    var decimalValue:Int = 0 // переменная, которая хранит текущее десятичное значение числа(свойство)
        set(value) {
            if(value < -3999 || value > 3999) {
                throw IllegalArgumentException("Number out of range")
            }
            field = value
        }

    constructor(decimal: Int) { //принимает десятичное число и проверяет его диапазон
        decimalValue = decimal
    }

    constructor(roman: String) { //принимает римское число и преобразует его в десятичное значение
        val normalizedRoman = roman.uppercase()
        var result = 0
        var i = 0
        while (i < normalizedRoman.length) {
            val currentChar = normalizedRoman[i]
            val currentValue = romanToDecimal[currentChar] //десятичный эквивалент для текущего символа мар
            if (currentValue != null) {
                if (i + 1 < normalizedRoman.length) { //есть ли дальше символ
                    val nextChar = normalizedRoman[i + 1]
                    val nextValue = romanToDecimal[nextChar]
                    if (nextValue != null && nextValue > currentValue) {
                        result += nextValue - currentValue //рим записана в убывающем порядке
                        i += 2
                        continue
                    }
                }
                result += currentValue
                i++
            } else {
                i++
            }
        }
        decimalValue = result
    }

    constructor(other: RomanNumber) {
        decimalValue = other.decimalValue
    }

    /*Преобразует десятичное число в римское число.*/
    override fun toString(): String {
        var remValue = kotlin.math.abs(decimalValue)
        var result = ""
        for ((decimal, roman) in decimalToRoman.entries.sortedByDescending { it.key }) { //перебирает эл-ты в порядке убывания
            while (remValue >= decimal) {
                result += roman
                remValue -= decimal
            }
        }
        if (decimalValue < 0) {
            result = "-$result"
        }
        return result
    }

    operator fun plus(other: RomanNumber) = RomanNumber(decimalValue + other.decimalValue)


    operator fun minus(other: RomanNumber)= RomanNumber(decimalValue - other.decimalValue)

    operator fun times(other: RomanNumber)= RomanNumber (decimalValue * other.decimalValue)

    operator fun div(other: RomanNumber)= RomanNumber (decimalValue / other.decimalValue)

    /*плюс с присваиванием для объектов класса. изменяет текущий объект, добавляя его на другой объект класса*/
    operator fun plusAssign(other: RomanNumber) {
        decimalValue += other.decimalValue
    }

    operator fun minusAssign(other: RomanNumber) {
        decimalValue -= other.decimalValue
    }

    operator fun timesAssign(other: RomanNumber) {
        decimalValue *= other.decimalValue
    }

    operator fun divAssign(other: RomanNumber) {
        decimalValue /= other.decimalValue
    }

    operator fun unaryPlus()= RomanNumber (kotlin.math.abs(decimalValue))

    operator fun unaryMinus()= RomanNumber (-decimalValue)
}