import support.TreeNode

/**
 * 94. Binary Tree Inorder Traversal
 */
class P94 {

	fun inorderTraversal(root: TreeNode?): List<Int> {
		if (root == null) {
			return emptyList()
		}
		return inorderTraversal(root.left) + root.`val` + inorderTraversal(root.right)
	}
}

fun main() {
	println(P94().inorderTraversal(TreeNode(1).apply {
		left = null
		right = TreeNode(2).apply {
			left = TreeNode(3)
		}
	}))
}