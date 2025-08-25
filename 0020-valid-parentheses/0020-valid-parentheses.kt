class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val stack = ArrayDeque<Char>()
        // 문자열 순회
        // 만약 ( { [ 인 경우 push
        // ) } ] 인 경우 -> peek이 각각 (, {, [ 인 경우 pop
        s.forEach { ch ->
            when {
                ch == '(' || ch ==  '{' || ch ==  '[' ->  {
                    stack.add(ch) 
                }
                ch == ')' -> {
                    if (stack.last() == '(')  stack.removeLast()
                }
                ch == '}' -> {
                    if (stack.last() == '{') stack.removeLast()
                }
                ch == ']' -> {
                    if (stack.last() == '[') stack.removeLast()
                }
            }
        }
        return if(stack.size == 0)  {
            true 
        } else {
            false
        }
    }
}