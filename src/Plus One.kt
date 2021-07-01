import kotlin.test.assertEquals

/**
 * 66. Plus One
 *
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/plus-one/
 */
class PlusOne {
	fun plusOne(digits: IntArray): IntArray {
		var carry = 1
		var i = digits.size - 1

		while (i >= 0) {
			val sum = digits[i] + carry
			digits[i--] = sum % 10
			carry = sum / 10
		}

		if (carry > 0) {
			return IntArray(digits.size + 1).also {
				it[0] = 1
			}
		}
		return digits
	}
}

fun main() {
	assertEquals(listOf(1,2,4), PlusOne().plusOne(intArrayOf(1,2,3)).toList())
	assertEquals(listOf(1,0), PlusOne().plusOne(intArrayOf(9)).toList())
}