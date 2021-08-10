import kotlin.test.assertEquals

/**
 * 561. Array Partition I
 *
 * Given an integer array nums of 2n integers,
 * group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
 * such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 *
 * https://leetcode.com/problems/array-partition-i/
 */
class ArrayPartitionI {
	fun arrayPairSum(nums: IntArray): Int {
		return nums.sorted().filterIndexed { index, _ -> index % 2 == 0 }.sum()
	}
}

fun main() {
	assertEquals(4, ArrayPartitionI().arrayPairSum(intArrayOf(1,4,3,2)))
}