import kotlin.test.assertEquals

/**
 * 989. Add to Array-Form of Integer
 *
 * The array-form of an integer num is an array representing its digits in left to right order.
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 */
class AddToArrayFormOfInteger {
	fun addToArrayForm(num: IntArray, k: Int): List<Int> {
		var i = num.size - 1
		var p = k
		var list = mutableListOf<Int>()

		while (i >= 0 || p > 0) {
			var sum = p % 10
			if (i >= 0) {
				sum += num[i--]
			}

			p = p / 10 + sum / 10
			list.add(sum % 10)
		}
		return list.reversed()
	}
}

fun main() {
	assertEquals(listOf(1,2,3,4), AddToArrayFormOfInteger().addToArrayForm(intArrayOf(1,2,0,0), 34))
	assertEquals(listOf(4,5,5), AddToArrayFormOfInteger().addToArrayForm(intArrayOf(2,7,4), 181))
}