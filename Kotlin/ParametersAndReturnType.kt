fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun multiply(a: Int, b: Int) = a * b;

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}");
}

fun main() {
    println("sum of 3 and 5 is ${sum(3,5)}");
    println("multiplication of 3 and 5 is ${multiply(3,5)}");
    printSum(2,4);
}
