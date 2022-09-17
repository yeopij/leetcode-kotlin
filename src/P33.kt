import kotlin.test.assertEquals

/**
 * 33. Search in Rotated Sorted Array
 */
class P33 {
	fun search(nums: IntArray, target: Int): Int {
		return search(nums, 0, nums.size - 1, target)
	}

	fun search(nums: IntArray, start: Int, end: Int, target: Int): Int {
		if (start >= end) {
			return if (nums[start] == target) {
				start
			} else {
				-1
			}
		}

		val pivot = (start + end) / 2

		val pivotValue = nums[pivot]
		val startValue = nums[start]
		val endValue = nums[end]

		return if (pivotValue == target) {
			pivot
		} else if (startValue < pivotValue && startValue <= target && target < pivotValue) {
			search(nums, start, pivot -1, target)
		} else if (pivotValue < endValue && pivotValue < target && target <= endValue) {
			search(nums, pivot + 1, end, target)
		} else {
			//순서가 맞지 않는 배열을 찾아서 재귀호출
			if (startValue > pivotValue) {
				search(nums, start, pivot -1, target)
			} else {
				search(nums, pivot + 1, end, target)
			}
		}
	}
}

fun main() {
	assertEquals(4, P33().search(intArrayOf(4,5,6,7,0,1,2), 0))
	assertEquals(-1, P33().search(intArrayOf(4,5,6,7,0,1,2), 3))
}