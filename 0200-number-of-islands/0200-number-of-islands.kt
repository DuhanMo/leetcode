class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        // 섬 개수
        var islandCount = 0
        // 방문 배열
        val visited = Array(rows) { BooleanArray(cols) }

        // bfs에 쓰일 큐
        val q = ArrayDeque<Pair<Int, Int>>()
        // 시작점을 큐에 넣으면서 방문처리
        

        // 상하좌우 방향벡터
        val dirR = listOf(1, -1, 0, 0)
        val dirC = listOf(0, 0, -1, 1)

        // 모든 데이터를 확인하면서 방문하지 않았고 섬이라면 bfs시작
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    // 섬발견, 카운트 증가
                    islandCount++ 
                    q.add(i to j)
                    visited[i][j] = true

                    // 큐가 빌 때 까지
                    while(q.isNotEmpty()) {
                        val (r, c) = q.removeLast()
                        // 4방향 탐색
                        for (k in 0 until 4) {
                            val nr = r + dirR[k]
                            val nc = c + dirC[k]
                            // 경계 안 && 미방문 && 섬 이라면 계속 탐색과 방문처리
                            if (nr in 0 until rows && nc in 0 until cols && grid[nr][nc] == '1' && !visited[nr][nc]) {
                                q.add(nr to nc)
                                visited[nr][nc] = true
                            }
                        }    
                    }
                }
            }
        }
        
        
        return islandCount
    }
}