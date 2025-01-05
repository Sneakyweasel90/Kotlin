package org.example.com.rockthejvm

object FP {

    //fun multiply10(arg: Int): Int = arg * 10

    //functional programming - ability to use functions as values
    val tenxFun: (Int) -> Int = fun (x: Int): Int {return x * 10}
    val tenxFun_V2 = {x: Int -> x * 10} //function value in Kotlin aka LAMBDA

    //multi-arg lambdas
    val adderFun = {a: Int, b: Int -> a + b}

    //collections
    val numbers = listOf(1,3,5,7,9,2,3,4)
    // .map
    val tenxNumbers = numbers.map(tenxFun)
    val tenxNumebrs_V2 = numbers.map({x: Int -> x * 10})
    val tenxNumbers_V3 = numbers.map {x: Int -> x * 10}
    val tenxNumbers_V4 = numbers.map {x -> x *10} //shorthand, compiler type inference
    val tenxNumbers_V5 = numbers.map {it * 10}

    // functional API
    //filtering
    val evenNumbers = numbers.filter { x -> x % 2 == 0 } //[2,4]
    //reducing
    val numbersSum = numbers.reduce {partialSum, ele -> partialSum + ele}
    //processing with predicates
    val firstEven = numbers.find {x -> x % 2 == 0} //nullable
    val oddPrefix = numbers.takeWhile { x -> x % 2 != 0 } //[1,3,5,7,9]
    val evenNumbersCount = numbers.count { x -> x % 2 == 0} //2

    val stringRep = numbers.joinToString("|", "{", "}") { x -> x.toString() }

    @JvmStatic
    fun main(args: Array<String>) {

        println(tenxFun(13))
        println(adderFun(10, 45))
        println(numbersSum)
        println(oddPrefix)
        println(evenNumbersCount)
        println(stringRep)
    }
}