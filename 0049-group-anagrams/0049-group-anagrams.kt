class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // 각 키들을 정렬
        // 키가 있다면 valuelist에 더함
        // 키가 없다면 새로운 키밸류 생성
        val anagramMap = mutableMapOf<String, MutableList<String>>()
        
        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString("")
            anagramMap.getOrPut(key) {
                mutableListOf()
            }.add(str)
        }
        return anagramMap.values.toList()
    }
}