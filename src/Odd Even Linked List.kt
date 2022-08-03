import support.ListNode
import kotlin.test.assertEquals
import kotlin.test.expect

/**
 * 328. Odd Even Linked List
 *
 * Given the head of a singly linked list,
 * group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * https://leetcode.com/problems/odd-even-linked-list/
 */
class OddEvenLinkedList {

	fun oddEvenList(head: ListNode?): ListNode? {
		if (head?.next == null) {
			return head
		}

		var oddNode = head
		var evenNode = head.next
		var evenHeadNode = head.next

		while (evenNode?.next != null) {
			oddNode?.next = oddNode?.next?.next
			evenNode.next = evenNode.next?.next

			oddNode = oddNode?.next
			evenNode = evenNode?.next
		}

		oddNode?.next = evenHeadNode
		return head
	}
}

fun main() {
	assertEquals(ListNode.create(listOf(1, 3, 5, 2, 4)), OddEvenLinkedList().oddEvenList(
		ListNode.create(listOf(1, 2, 3, 4, 5))
	))
}