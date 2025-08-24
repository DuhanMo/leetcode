class Solution {
    fun frequencySort(s: String): String {
        // 문자/빈도 맵
        val map = mutableMapOf<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        // 최대힙(빈도,문자)
        val maxHeap = PriorityQueue<Pair<Int, Char>>(compareByDescending{it.first})

        // 맵 돌면서 최대힙에 (빈도,문자) 삽입
        map.forEach { (char, count) ->
            maxHeap.add(Pair(count, char))
        }

        // 최대힙 순회하면서 정답 생성
        val sb = StringBuilder()
        while(maxHeap.isNotEmpty()) {
            val (count, char) = maxHeap.poll()
            repeat(count) { sb.append(char) }
        }
        return sb.toString()
    }
}