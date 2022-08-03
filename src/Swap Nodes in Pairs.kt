import support.ListNode
import kotlin.test.assertEquals

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
class SwapNodesInPairs {

	fun swapPairs(head: ListNode?): ListNode? {
		var root = head

		var prev: ListNode? = null
		var first = head
		while (first?.next != null) {
			//swap
			val second = first?.next
			first?.next = first?.next?.next
			second?.next = first
			prev?.next = second

			if (head == first) {
				root = second
			}
			prev = first
			first = first?.next
		}
		return root
	}
}

fun main() {
	assertEquals(ListNode.create(listOf(2, 1, 3)),
		SwapNodesInPairs().swapPairs(ListNode.create(listOf(1, 2, 3))
	))
}