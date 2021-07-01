import kotlin.test.assertEquals

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStockII {
	fun maxProfit(prices: IntArray): Int {
		if (prices.isEmpty()) return 0

		var profit = 0
		var buyPrice = prices[0]
		var sellPrice = 0

		prices.forEach { price ->
			//이전 매도점보다 가격이 내려가는 시점에 매도
			if (sellPrice > price) {
				profit += sellPrice - buyPrice
				buyPrice = price
				sellPrice = 0
			} else {
				sellPrice = price
			}

			//이전 매수점 보다 가격이 내려가는 시점에 매수 지점 조정
			if (buyPrice >= price) {
				buyPrice = price
			}
		}

		if (sellPrice > buyPrice) {
			profit += sellPrice - buyPrice
		}
		return profit
	}
}

fun main() {
	assertEquals(7, BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(7,1,5,3,6,4)))
	assertEquals(4, BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(1,2,3,4,5)))
}