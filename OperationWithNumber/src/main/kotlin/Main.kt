package lab1

fun main() {
    val z1 = Complex_number()
    val z2 = Complex_number(5.0)
    val z3 = Complex_number(im = -2.0)
    val z4 = Complex_number(z3)
    val z5 = z1.plus(z2).plus(z3)
    val z6 = z5.minus(z4)
    val z7 = z6
    val z8 = z1.div(z2).div(z3)
    val z9 = Complex_number(1.0)
    val z10 = z2.div(z9)
    val z11 = z7.times(z3)
    val z12 = z9.times(z2)
    val z13 = z2.unaryMinus()
    println("z1 = $z1")
    println("z2 = $z2")
    println("z3 = $z3")
    println("z4 = $z4")
    println("z5 = $z5")
    println("z6 = $z6")
    println("z7 = $z7")
    z6.im = -1.0
    println("z6 = $z6")
    println("z7 = $z7")
    z3.im = 4.0
    println("z3 = $z3")
    println("z4 = $z4")
    println("z8 = $z8")
    println("z10 = $z10")
    println("z11 = $z11")
    println("z12 = $z12")
    println("z13 = $z13")
}