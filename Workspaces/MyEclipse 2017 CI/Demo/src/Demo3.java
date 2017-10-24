import java.util.Map;

public class Demo3 {
	private static int r2a(String in){  
        int graph[] = new int[400];  
        graph['I'] = 1;  
        graph['V']=5;  
        graph['X']=10;  
        graph['L']=50;  
        graph['C']=100;  
        graph['D']=500;  
        graph['M']=1000;  
          
        char[] num = in.toCharArray();  
          
        // 遍历这个数，用sum来总计和  
        int sum = graph[num[0]];  
          
        for(int i=0; i<num.length-1; i++){  
            // 如果，i比i+1大的话，直接相加  
            if(graph[num[i]] >= graph[num[i+1]]){  
                sum += graph[num[i+1]];  
            }  
            // 如果i比i+1小的话，则将总和sum减去i这个地方数的两倍，同时加上i+1  
            // 就相当于后边的数比左边的数大，则用右边的数减左边的数  
            else{  
                sum = sum + graph[num[i+1]] - 2*graph[num[i]];  
            }  
        }  
          
        return sum;  
    }
//	public int romanToInt(String s) {
//	        int sum = 0;
//	        Map<Character, Integer> roman = {
//	            { 'I', 1 },{ 'V', 5 },{ 'X', 10 },{ 'L', 50 },{ 'C', 100 },{ 'D', 500 },{ 'M', 1000 }
//	        };
//	        for (int i = 0; i < s.size(); ++i) {
//	            sum += roman[s[i]];
//	            if (s[i] == 'I' || s[i] == 'X' || s[i] == 'C')
//	                if (i + 1 < s.size() && roman[s[i + 1]] > roman[s[i]])
//	                    sum -= 2 * roman[s[i]];
//	        }
//	        return sum;
//	    }
	public static void main(String[] args) {
		System.out.println(r2a("MMMCMXCIX"));
	}
}
