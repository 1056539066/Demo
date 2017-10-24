import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo5 {
	//用栈判断括号是否匹配，前提是输入的字符串只有括号
	public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            Character input = s.charAt(i);
            switch(input){
                    case'(': case'[' :case'{' :
                    stk.push(input);
                    break;
                    case')' :case']' :case'}' :
                    if(stk.isEmpty() || input != map.get(stk.pop()))
                        return false;
            }
        }
        return stk.isEmpty();
    }
	//用数组实现，更有效率
		public boolean isValidGod(String s) {
			char[] stack = new char[s.length()];
			int head = 0;
			for(char c : s.toCharArray()) {
				switch(c) {
					case '{':
					case '[':
					case '(':
						stack[head++] = c;
						break;
					case '}':
						if(head == 0 || stack[--head] != '{') return false;
						break;
					case ')':
						if(head == 0 || stack[--head] != '(') return false;
						break;
					case ']':
						if(head == 0 || stack[--head] != '[') return false;
						break;
				}
			}
			return head == 0;

		}
}
