import kotlin.test.assertEquals

/**
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductofArrayExceptSelf {
	fun productExceptSelf(nums: IntArray): IntArray {
		val result = IntArray(nums.size)
		var tempProduct = 1

		//앞에서 부터 해당 항목 앞까지의 곱
		for (i in nums.indices) {
			if (i != 0) {
				tempProduct *= nums[i - 1]
			} else {
				tempProduct = 1
			}
			result[i] = tempProduct
		}

		//뒤에서 부터 해당 항목 뒤까지의 곱
		for (i in nums.size - 1 downTo 0) {
			if (i != nums.size - 1) {
				tempProduct *= nums[i + 1]
			} else {
				tempProduct = 1
			}
			result[i] *= tempProduct
		}
		return result
	}
}

fun main() {
	assertEquals(intArrayOf(24,12,8,6).toList(), ProductofArrayExceptSelf().productExceptSelf(intArrayOf(1,2,3,4)).toList())
}