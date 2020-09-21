
fun main() {
    /*
    var arr = arrayOf(1, 2, 4);
    arr.forEach { println(it) };
    */
    var arr = Array(5) { it -> (it * it).toString() };
    arr.forEach { it -> println(it) };
    
}
