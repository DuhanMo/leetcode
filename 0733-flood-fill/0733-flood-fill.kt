class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val rows = image.size
        val cols = image[0].size

        // 시작 픽셀의 기존 색을 old로 저장
        val old = image[sr][sc]
        // 시작 색과 목표 색이 같으면 아무 작업 하지 않음
        if (old == color) return image
        
        // BFS에 사용할 큐. 좌표를 저장
        val q = ArrayDeque<Pair<Int, Int>>()
        // 시작점을 추가하고 색 갱신 (별도 방문배열 없이 색 바꾸는 행위로 방문표시를 대체)
        q.add(sr to sc)
        image[sr][sc] = color
        
        // 방향벡터 (상 하 좌 우)
        val dirR = intArrayOf(-1, 1, 0, 0)
        val dirC = intArrayOf(0, 0, -1, 1)
        while (q.isNotEmpty()) {
            val (r, c) = q.removeFirst()
            // 현재 칸에서 4방향 확인
            for (k in 0 until 4) {
                val nr = r + dirR[k]
                val nc = c + dirC[k]
                // 1) 경계 내
                // 2) 아직 미방문 (색이 old그대로인 경우)
                // 위 두 조건 만족 시 채색 후 큐에 추가
                if (nr in 0 until rows && nc in 0 until cols && image[nr][nc] == old) {
                    image[nr][nc] = color // 방문 표시 (채색))
                    q.add(nr to nc) // 다음 확장 후보로 추가
                }
            }
        }
        return image
    }
}