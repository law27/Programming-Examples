
fun getLength(arg: Any): Int? {
    if(arg is String) {
        return arg.length;
    }
    return null;
}

fun main() {
    println(getLength("Lawrance"));
    println(getLength(23846283));
    println(getLength(""));
}
