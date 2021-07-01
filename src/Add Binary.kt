import kotlin.test.assertEquals

/**
 * 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * https://leetcode.com/problems/add-binary/
 */
class AddBinary {
	fun addBinary(a: String, b: String): String {
		var i = a.length - 1
		var j = b.length - 1
		var carry = 0
		var strBuf = StringBuffer()

		while (i >= 0 || j >= 0) {
			var sum = carry
			if (i >=0) sum += a[i--] - '0'
			if (j >=0) sum += b[j--] - '0'

			strBuf.append(sum % 2)
			carry = sum / 2
		}

		if (carry > 0) {
			strBuf.append(carry)
		}
		return strBuf.reverse().toString()
	}
}

fun main() {
	assertEquals("100", AddBinary().addBinary("11", "1"))
	assertEquals("10101", AddBinary().addBinary("1010", "1011"))
}