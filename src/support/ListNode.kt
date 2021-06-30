package support

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
data class ListNode(
	var `val`: Int,
	var next: ListNode? = null
) {
	companion object {
		fun create(list: List<Int>): ListNode? {
			var head: ListNode? = null
			var prev: ListNode? = null

			list.forEach { value ->
				val current = ListNode(value)
				if (head == null) {
					head = current
				}

				prev?.next = current
				prev = current
			}
			return head
		}
	}
}