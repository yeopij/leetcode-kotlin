import kotlin.math.min
import kotlin.test.assertEquals

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
class P153 {
	fun findMin(nums: IntArray): Int {
		if (nums.size == 1) return nums[0]

		return findMin(nums, 0, nums.size - 1)
	}

	fun findMin(nums: IntArray, start: Int, end: Int) : Int {
		if (end - start <= 1) {
			return min(nums[start], nums[end])
		}

		val pivot = (start + end) / 2

		return if (nums[start] > nums[pivot]) {
			findMin(nums, start, pivot)
		} else if (nums[pivot] > nums[end]) {
			findMin(nums, pivot, end)
		} else {
			nums[start]
		}
	}
}

fun main() {
	assertEquals(1, P153().findMin(intArrayOf(3,4,5,1,2)))
	assertEquals(0, P153().findMin(intArrayOf(4,5,6,7,0,1,2)))
	assertEquals(11, P153().findMin(intArrayOf(11,13,15,17)))
	assertEquals(1, P153().findMin(intArrayOf(2, 1)))
	assertEquals(1, P153().findMin(intArrayOf(3, 1, 2)))
}