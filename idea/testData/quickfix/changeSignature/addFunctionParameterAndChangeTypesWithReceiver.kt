// "Change the signature of function 'withReceiver'" "true"
// DISABLE-ERRORS

fun String.withReceiver(i: Int) {}

private fun test(s: String, q: Boolean) {
    s.withReceiver(q, <caret>2)
}