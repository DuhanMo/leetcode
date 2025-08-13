class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        if (s.length != t.length) return false

        val charMap = ('a'..'z').associateWith { 0 }.toMutableMap()

        s.forEach { c -> charMap[c] = charMap[c]!! + 1 }
        t.forEach { c -> charMap[c] = charMap[c]!! - 1 }

        // 모든 값이 0인지 확인
        return charMap.values.all { it == 0 }
    }
}