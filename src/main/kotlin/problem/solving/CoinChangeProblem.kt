package problem.solving

import exception.invalidArgumentError


//  Given an unlimited supply of coins of given denominations,
//  find the total number of distinct ways to get the desired change.

// todo Compexity?
fun countChange(coins: IntArray, changeSum: Int): Int {
    val uniqueCoins = validateAndDistinct(coins)
    return solveRecursively(uniqueCoins, uniqueCoins.lastIndex, changeSum)
}

fun countChangeWithHashmap(coins: IntArray, changeSum: Int): Int {
    val uniqueCoins = validateAndDistinct(coins)
    return solveRecursively(uniqueCoins, uniqueCoins.lastIndex, changeSum, hashMapOf())
}

private fun validateAndDistinct(coins: IntArray): IntArray {
    if (coins.isEmpty()) invalidArgumentError("Array is empty")
    if (coins.any { it <= 0 }) invalidArgumentError("Coin values must be positive")

    return coins.distinct().toIntArray()
}

private fun solveRecursively(
    coins: IntArray,
    lastCoinIndex: Int,
    changeSum: Int,
    map: HashMap<String, Int>? = null
): Int {
    if (changeSum == 0) return 1
    if (changeSum < 0 || lastCoinIndex < 0) return 0

    val coinValue = coins[lastCoinIndex]

    val key = "$coinValue|$changeSum"
    if (map?.containsKey(key) == true) return map[key]!!

    val changeWithCoin = solveRecursively(coins, lastCoinIndex, changeSum - coinValue, map)
    val changeWithoutCoin = solveRecursively(coins, lastCoinIndex - 1, changeSum, map)

    val result = changeWithCoin + changeWithoutCoin

    map?.put(key, result)

    return result
}

// Complexity time/space: O(n^2)/O(n^2)
fun countChangeDP(coins: IntArray, changeSum: Int): Int {
    val uniqueCoins = validateAndDistinct(coins)

    val array = IntArray(changeSum + 1)
    array[0] = 1

    for (i in uniqueCoins.indices) {
        for (j in uniqueCoins[i]..changeSum) {
            array[j] += array[j - uniqueCoins[i]]
        }
    }

    return array[changeSum]
}
