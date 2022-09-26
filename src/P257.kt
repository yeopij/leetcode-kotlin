import support.TreeNode

/**
 * 257. Binary Tree Paths
 */
class P257 {


	fun binaryTreePaths(root: TreeNode?): List<String> {
		if (root == null) {
			return emptyList()
		}

		if (root.left == null && root.right == null)
			return listOf(root.`val`.toString())

		val left = binaryTreePaths(root.left)
		val right = binaryTreePaths(root.right)

		return (left + right).map { root.`val`.toString() + "->" + it }
	}
}

fun main() {
	println(P257().binaryTreePaths(TreeNode(1).apply {
		left = TreeNode(2).apply {
			right = TreeNode(5)
		}
		right = TreeNode(3)
	}))
}