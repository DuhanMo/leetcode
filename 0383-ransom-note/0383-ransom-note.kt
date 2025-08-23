class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
      val map = ('a'..'z').associateWith { 0 }.toMutableMap()
      magazine.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
      }
      ransomNote.forEach {
        val remain = map.getOrDefault(it, 0)
        if (remain - 1 < 0 ) return false
        map[it] = remain - 1
      }
      return true
    }
}