class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val arr = IntArray(26)
        magazine.forEach {
            arr[it - 'a'] += 1
        }
        ransomNote.forEach {
            val remain = arr[it - 'a']
            if (remain - 1 < 0) return false
            arr[it - 'a'] = remain - 1
        }
    return true
    }
}