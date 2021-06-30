import kotlin.test.assertEquals

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {
	fun twoSum(nums: IntArray, target: Int): IntArray {
		val map = mutableMapOf<Int, Int>()

		for (i in nums.indices) {
			map[target - nums[i]]?.let {
				return intArrayOf(i, it)
			}
			map[nums[i]] = i
		}
		return intArrayOf()
	}
}

fun main() {
	assertEquals(setOf(0, 1), TwoSum().twoSum(intArrayOf(2,7,11,15), 9).toSet())
	assertEquals(setOf(1, 2), TwoSum().twoSum(intArrayOf(3, 2, 4), 6).toSet())
	assertEquals(setOf(0, 1), TwoSum().twoSum(intArrayOf(3, 3), 6).toSet())
}