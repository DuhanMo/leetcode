class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val stack = ArrayDeque<Char>()
        // 문자열 순회
        // 만약 ( { [ 인 경우 그 짝을 push
        // 여는 괄호가 아닌 경우 , 비어있으면 false 꺼내서 짝과 맞지 않을 경우 false
        s.forEach { ch ->
            when {
                ch == '(' -> stack.addLast(')')
                ch == '{' -> stack.addLast('}')
                ch == '[' -> stack.addLast(']')
                else -> {
                    if (stack.isEmpty() || stack.removeLast() != ch) return false
                }
            }
        }
        return stack.isEmpty()
    }
}