package functions

fun main() {

}

// split fun
//fun checkIP(input: String): Boolean {
//    var dotsCount = 0
//    var currentSegment = ""
//    for (i in input.indices) {
//        if (input[i] == '.' || i == input.length - 1) {
//            if (input[i] == '.')
//                dotsCount++
//
//            if (i == input.length - 1)
//                currentSegment += input[i]
//
//            val segmentValue = currentSegment.toIntOrNull()
//            if ( dotsCount > 3 ||
//                currentSegment.isEmpty() ||
//                (currentSegment[0] == '0' && currentSegment.length > 1) ||
//                segmentValue == null ||
//                segmentValue > 255 || segmentValue < 0
//
//            ) {
//                return false
//            }
//            currentSegment = ""
//
//        } else {
//            currentSegment += input[i]
//        }
//    }
//    return dotsCount == 3
//}

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