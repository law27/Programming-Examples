
fun replace(src: String?, rep: String, value: String): String? {
    if(src != null) {
        return src.replace(rep, value);
    }
    else return null
}

fun main() {
    val a = "Lawrance is Good";
    val b = replace(null, "is", "was");
    if( b != null) println(b)
    else println("It is a null");
}
