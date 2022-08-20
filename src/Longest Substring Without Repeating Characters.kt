import kotlin.test.assertEquals

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class `Longest Substring Without Repeating Characters` {
	fun lengthOfLongestSubstring(s: String): Int {
		if (s.isNullOrEmpty()) return 0

		var fromIndex = 0
		var endIndex = 0
		var maxSize = 0

		//중복여부 체크를 위한 map
		val map = mutableMapOf<Char, Int>()
		while (endIndex < s.length) {
			val existIndex = map[s[endIndex]]
			if (existIndex != null && existIndex >= fromIndex) {
				fromIndex = existIndex + 1
			} else {
				maxSize = maxOf(maxSize, endIndex - fromIndex + 1)
			}
			map[s[endIndex]] = endIndex
			endIndex++
		}
		return maxSize
	}
}

fun main() {
	val testObject = `Longest Substring Without Repeating Characters`()
//	assertEquals(3, testObject.lengthOfLongestSubstring("abcabcbb"))
//	assertEquals(1, testObject.lengthOfLongestSubstring("bbbbb"))
//	assertEquals(3, testObject.lengthOfLongestSubstring("pwwkew"))
	assertEquals(5, testObject.lengthOfLongestSubstring("tmmzuxt"))
}