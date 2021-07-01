import kotlin.test.assertEquals

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class BestTimeToBuyAndSellStock {
	fun maxProfit(prices: IntArray): Int {
		if (prices.isEmpty()) return 0

		var maxProfit = 0
		var buyPrice = prices[0]

		prices.forEach { price ->
			if (buyPrice >= price) {
				buyPrice = price
			} else {
				maxProfit = maxOf(maxProfit, price - buyPrice)
			}
		}
		return maxProfit
	}
}

fun main() {
	assertEquals(5, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7,1,5,3,6,4)))
	assertEquals(0, BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7,6,4,3,1)))
}