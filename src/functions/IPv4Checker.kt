package functions

fun main() {

}


fun checkIP(input: String): Boolean {
    val segments = input.split('.')
    if (segments.size != 4) return false

    for (segment in segments) {
        val segmentInt = segment.toIntOrNull()
        if (segment.isEmpty() ||
            (segment[0] == '0' && segment.length > 1) ||
            segmentInt == null ||
            (segmentInt !in 0..255)
        ) {
            return false
        }
    }
    return true
}