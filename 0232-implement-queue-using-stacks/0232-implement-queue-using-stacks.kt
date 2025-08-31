class MyQueue() {
    val inStack = ArrayDeque<Int>()  
    val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.addLast(x)    
    }

    fun pop(): Int {
        if (outStack.isEmpty()) {
            while(inStack.isNotEmpty()) {
                outStack.addLast(inStack.removeLast())
            }
        }
        return outStack.removeLast()
    }

    fun peek(): Int {
        if (outStack.isEmpty()) {
            while(inStack.isNotEmpty()) {
                outStack.addLast(inStack.removeLast())
            }
        }
        return outStack.last()
    }

    fun empty(): Boolean {
        return outStack.isEmpty() && inStack.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */