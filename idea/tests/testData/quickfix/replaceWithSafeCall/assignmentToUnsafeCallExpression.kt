// "Replace with safe (?.) call" "true"
class A(var s: String? = null)

fun foo(a: A?) {
    a<caret>.s = ""
}
