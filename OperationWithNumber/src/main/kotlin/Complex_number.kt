package lab1

import java.lang.Math.abs
import java.lang.StringBuilder

class Complex_number(var re: Double = 0.0, var im: Double = 0.0) {
    constructor(C:Complex_number):this(C.re,C.im)

    operator fun plus(other: Complex_number)=Complex_number(re + other.re, im +other.im)
    operator fun plus(other: Double) = Complex_number(re+other, im)
    operator fun plus(other: Number) = plus(other.toDouble())

    operator fun minus(other: Complex_number)=Complex_number(re - other.re, im - other.im)
    operator fun minus(other: Double) = Complex_number(re-other, im)
    operator fun minus(other: Number) = minus(other.toDouble())

    operator fun times(other: Complex_number) = Complex_number(re * other.re - im * other.im,
        im * other.re + re * other.im)
    operator fun times(other:Double) = Complex_number(re * other, im * other)
    operator fun times(other:Number) = times(other.toDouble())


    operator fun div(other:Complex_number) = (other.re* other.re + other.im * other.im).let {denom->
        Complex_number(
            (re * other.re + im * other.im) / denom, (im * other.re - re * other.im) / denom
        )
    }
    operator fun div(other:Double) = Complex_number(re/other, im/other)
    operator fun div(other: Number) = div(other.toDouble())

    operator fun unaryMinus() = Complex_number(re, -im)



    override fun toString() = StringBuilder().apply {
            if (re == 0.0 && im == 0.0) append(0.0)
            else {
                if (re != 0.0) append(re)
                if (im != 0.0) {
                    append(if (im > 0.0) "" else  "-")
                    if (abs(im) != 1.0) append(abs(im))
                    append("i")
                }
            }
    }.toString()
}
