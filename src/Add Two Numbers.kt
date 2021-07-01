import support.ListNode
import kotlin.test.assertEquals

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
class AddTwoNumbers {

	fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
		var number1 = l1
		var number2 = l2
		val head = ListNode(0)
		var current = head
		var carry = 0

		while (number1 != null || number2 != null) {
			val sum = (number1?.`val` ?: 0) + (number2?.`val` ?: 0) + carry

			current.next = ListNode(sum % 10)
			current = current.next!!
			carry = sum / 10

			if (number1 != null) {
				number1 = number1.next
			}
			if (number2 != null) {
				number2 = number2.next
			}
		}

		if (carry > 0) {
			current.next = ListNode(carry)
		}
		return head.next
	}
}

fun main() {
	assertEquals(ListNode.create(listOf(7, 0, 8)), AddTwoNumbers().addTwoNumbers(
		ListNode.create(listOf(2, 4, 3)), ListNode.create(listOf(5, 6, 4))
	))
	assertEquals(ListNode.create(listOf(8,9,9,9,0,0,0,1)), AddTwoNumbers().addTwoNumbers(
		ListNode.create(listOf(9,9,9,9,9,9,9)), ListNode.create(listOf(9,9,9,9))
	))
}