package testing

import functions.checkIP


fun main() {
    testIP(
        name = "When the IP address is valid containing random values from (0-255) it should return true",
        result = checkIP(
            "162.234.121.2"
        ),
        correctResult = true
    )

    testIP(
        name = "When the IP address is all zeros it should return true",
        result = checkIP(
            "0.0.0.0"
        ),
        correctResult = true
    )

    testIP(
        name = "When the IP address is all 255 it should return true",
        result = checkIP(
            "255.255.255.255"
        ),
        correctResult = true
    )


    testIP(
        name = "When the IP address is divided into more than four segments it should return false",
        result = checkIP(
            "162.234.121.2.5"
        ),
        correctResult = false
    )


    testIP(
        name = "When the IP address is divided into less than four segments it should return false",
        result = checkIP(
            "162.234.121"
        ),
        correctResult = false
    )


    testIP(
        name = "When the IP address has contains a number greater than 255 (outside the range(0-255)) it should return false",
        result = checkIP(
            "162.288.121.2"
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address containing a negative number(outside the range(0-255))  it should return false",
        result = checkIP(
            "162.234.121.-2"
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address containing negative number and a number greater than 255 it should return false",
        result = checkIP(
            "162.234.270.-2"
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address has leading zeros it should return false",
        result = checkIP(
            "162.234.121.02"
        ),
        correctResult = false
    )



    testIP(
        name = "When the IP address has letters or special characters it should return false",
        result = checkIP(
            "162.$.121.on"
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address dots are replaced by slash or any other separator it should return false",
        result = checkIP(
            "162.234.121/2"
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address ends with a dot it should return false",
        result = checkIP(
            "162.234.121.2."
        ),
        correctResult = false
    )

    testIP(
        name = "When the IP address segments are separated by spaces it should return false",
        result = checkIP(
            "162 234 121 2"
        ),
        correctResult = false
    )

    testIP(
        name = "When IP has leading/trailing spaces it should return false",
        result = checkIP(" 162.234.121.2 "),
        correctResult = false
    )

    testIP(
        name = "When IP has consecutive dots it should return false",
        result = checkIP("162..234.121.2"),
        correctResult = false
    )

    testIP(
        name = "When the IP address has spaces within any of the segments it should return false",
        result = checkIP("162.2 34.121.2"),
        correctResult = false
    )

    testIP(
        name = "When the IP address consists of a single number it should return false",
        result = checkIP("200"),
        correctResult = false
    )

    testIP(
        name = "When the IP address consists of only dots, it should return false",
        result = checkIP("..."),
        correctResult = false
    )

    testIP(
        name = "When the IP address is empty it should return false ",
        result = checkIP(
            ""
        ),
        correctResult = false
    )


}


fun testIP(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}