import support.ListNode
import java.util.*
import kotlin.test.assertEquals

/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedList {
	fun reverseList(head: ListNode?): ListNode? {
		if (head == null) return null

		var current = head
		var prev: ListNode? = null

		while (current != null) {
			val temp = current.next
			current.next = prev
			prev = current
			current = temp
		}
		return prev
	}

	fun usingStack(head: ListNode?): ListNode? {
		if (head == null) return null

		val stack: Stack<ListNode> = Stack()

		//스택에 쌓기
		var current = head
		while (current != null) {
			stack.push(current)
			current = current.next
		}

		//스택에서 꺼내면서 순서 변경
		val head = stack.pop()
		var prev = head
		while (stack.isNotEmpty()) {
			val current = stack.pop()
			prev.next = current
			prev = current
		}
		prev.next = null
		return head
	}

	fun usingRecursive(head: ListNode?): ListNode? {
		if (head?.next == null) return head

		var result = usingRecursive(head?.next)
		head?.next?.next = head
		head?.next = null
		return result
	}
}

fun main() {
	/**
	 * Input: head = [1,2,3,4,5]
	 * Output: [5,4,3,2,1]
	 */
	//Loop로 포인터 방향을 변경하면서 바꾸기
	assertEquals(ListNode.create(listOf(5, 4, 3, 2, 1)), ReverseLinkedList().reverseList(ListNode.create(listOf(1, 2, 3, 4, 5))))
	assertEquals(ListNode.create(listOf(2, 1)), ReverseLinkedList().reverseList(ListNode.create(listOf(1, 2))))
	assertEquals(ListNode.create(listOf()), ReverseLinkedList().reverseList(ListNode.create(listOf())))

	//Stack을 이용하여 순서 바꾸기
	assertEquals(ListNode.create(listOf(5, 4, 3, 2, 1)), ReverseLinkedList().usingStack(ListNode.create(listOf(1, 2, 3, 4, 5))))
	assertEquals(ListNode.create(listOf(2, 1)), ReverseLinkedList().usingStack(ListNode.create(listOf(1, 2))))
	assertEquals(ListNode.create(listOf()), ReverseLinkedList().usingStack(ListNode.create(listOf())))

	//재귀 이용하여 순서 바꾸기
	assertEquals(ListNode.create(listOf(5, 4, 3, 2, 1)), ReverseLinkedList().usingRecursive(ListNode.create(listOf(1, 2, 3, 4, 5))))
	assertEquals(ListNode.create(listOf(2, 1)), ReverseLinkedList().usingRecursive(ListNode.create(listOf(1, 2))))
	assertEquals(ListNode.create(listOf()), ReverseLinkedList().usingRecursive(ListNode.create(listOf())))
}