fun test(i: Int) {
    if (i == 1) {
        println(1)
    } else if (i == 2) {
        println(2)
    } else<caret> {
        println(3)
    }
}

fun println(i: Int) {}