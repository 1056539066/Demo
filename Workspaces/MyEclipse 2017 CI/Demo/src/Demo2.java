
public class Demo2 {
	public boolean isPalindromeMy(int x) {
		if(x<0){
            return false;
        }else if(x == 0){
            return true;
        }else{
            String xString = Integer.toString(x);
            String yString = reverseByRecursive(xString);
            if(xString.equals(yString)){
                return true;
            }
            else
                return false;
        }
    }
        public String reverseByRecursive(String str) {  
        if(str == null || str.length() == 0) {  
            return str;  
        }  
        int len = str.length();  
        if(len == 1) {  
            return str;  
        } else {  
            return reverseByRecursive(str.substring(1))+ str.charAt(0);  
        }  
    }
        
    
	public boolean isPalindrome(int x) {
		//直接去除几个绝对不是回文数的情况：负数、个位为0
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    //定义一个新的整数，用来接收反转后的数字，也不用考虑输入的位数，且只反转一半
	    int rev = 0;
	    while (x>rev){
	    	rev = rev*10 + x%10;
	    	x = x/10;
	    }
	    return (x==rev || x==rev/10);//此处就确保比较的位数相同
	    //因为接收的就是整数型，不用考虑越界
	}
	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		System.out.println(demo2.isPalindrome(1001));
		System.out.println(demo2.isPalindrome(2147483647));
	}
}
