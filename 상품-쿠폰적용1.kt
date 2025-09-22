/**
상품 가격, [percent 50, minus700,..] 인풋
최저가 적용된 상품 가격 찾기
*/
class Solution {
    fun solution(price: Int, coupons: Array<String>): Int {
        var minPrice = price

        coupons.forEach { coupon ->
            val info = coupon.trim().split(" ")
            val policy = info[0].lowercase()
            val value = info[1].toInt()
            
            val finalPrice = when(policy) {
                "percent" -> price - (price * value / 100)
                "minus" -> maxOf(0, price - value)
                else -> error("알 수 없는 정책 $policy")
            }
            minPrice = minOf(minPrice, finalPrice)
        }
        return minPrice
    }
}
