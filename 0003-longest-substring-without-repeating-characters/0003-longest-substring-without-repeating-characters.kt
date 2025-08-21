class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // 슬라이딩 윈도우 사용, 문자/포지션 맵 사용
        // right 가 문자열 순회 (최대값은 항상 갱신)
        // 문자열 돌면서 맵에 있는지 확인
        // 없다면 맵에 문자/포지션 값 삽입
            
        // 있다면 left를 가장최근 본 중복문자의앞으로 넘김
        // 최대값을 갱신 (left와 right 길이와 기존 최대값)

        val lastSeen = mutableMapOf<Char, Int>()
        var left = 0
        // var right = 0
        var maxLen = 0

        for ((i, c) in s.withIndex()) {
            if (c in lastSeen && lastSeen[c]!! >= left) {
                left = lastSeen[c]!! + 1
            }
            maxLen = maxOf(maxLen, i - left + 1)
            lastSeen[c] = i
        }               
        return maxLen
    }
}