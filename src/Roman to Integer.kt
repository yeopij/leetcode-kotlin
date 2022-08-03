import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

/**
 * 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * https://leetcode.com/problems/add-binary/
 */
class RomanToInteger {
	companion object {
		val ROMAN_TO_INTEGER = mapOf(
		"I" to 1,
		"V" to 5,
		"X" to 10,
		"L" to 50,
		"C" to 100,
		"D" to 500,
		"M" to 1000
		)
	}

	fun romanToInt(s: String): Int {
		var result = 0
		var prev = 0

		s.toCharArray().forEach {
			val value = ROMAN_TO_INTEGER[it.toString()] ?: throw IllegalArgumentException("Invalid parameter")
			if (prev == 0) {
				prev = value
			} else {
				if (value > prev) {
					result += value - prev
					prev = 0
				} else {
					result += prev
					prev = value
				}
			}
		}

		if (prev > 0) {
			result += prev
		}

		return result
	}
}

fun main() {
	assertEquals(1994, RomanToInteger().romanToInt("MCMXCIV"))
	assertEquals(58, RomanToInteger().romanToInt("LVIII"))
}