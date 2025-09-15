class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1 // 5
        while (left <= right) {
            // mid = 4
            val mid = left + right / 2
            println(mid)
            when {
                // 3 < 9
               nums[mid] < target -> left = mid + 1 // left = 3
                nums[mid] > target -> right = mid - 1
                nums[mid] == target -> return mid
            }
        }
        return -1   
    }
}