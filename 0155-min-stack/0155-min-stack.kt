class MinStack() {
    val stack = ArrayDeque<Int>()
    // 스택 쌓일 시점의 최소값, 스택의 값과 생명주기를 같이함.
    val minStack = ArrayDeque<Int>()

    fun push(num: Int) {
        stack.addLast(num)
        val currentMin = if (minStack.isEmpty()) {
            num
        } else {
            minOf(minStack.last(), num)
        }
        minStack.addLast(currentMin)
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int = stack.last()
    

    fun getMin(): Int = minStack.last()
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */