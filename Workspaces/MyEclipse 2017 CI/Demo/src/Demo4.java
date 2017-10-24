import java.util.Arrays;

public class Demo4 {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs != null && strs.length > 0) {

			Arrays.sort(strs);

			char[] a = strs[0].toCharArray();
			char[] b = strs[strs.length - 1].toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (b.length > i && b[i] == a[i]) {
					result.append(b[i]);
				} else {
					return result.toString();
				}
			}
		}
		return result.toString();
	}

	public String longestCommonPrefixSimmple(String[] strs) {
		//特殊情况
	       if(strs == null || strs.length == 0)
	           return "";
	        int index = 0;
	        StringBuffer sb = new StringBuffer();
	        //默认利用第一个进行比较，共同前缀不管是用哪个都应满足
	        while(index<strs[0].length()){
	        	//利用第一个与 strs 后其他的字符串比较，不用比较第一个即自身
	            for(int i = 1;i<strs.length;i++){
	            	//当 index 超过被比较的字符串的长度或者被比较的相同的位数不同时，可直接结束了，因为有一个不满足即都不满足
	                if(index>strs[i].length()-1||strs[0].charAt(index) != strs[i].charAt(index))
	                    return sb.toString();
	            }
	            sb.append(strs[0].charAt(index));
	            index++;
	        }
	        return sb.toString();
	    }

	public static void main(String[] args) {
		Demo4 demo4 = new Demo4();
		String[] strs = { "124", "132", "12", "12489" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		System.out.println(demo4.longestCommonPrefix(strs));
	}
}
