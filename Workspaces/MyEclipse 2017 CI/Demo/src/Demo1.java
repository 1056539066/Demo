
public class Demo1 {
	    public int reverseMy(int x) {
	        long sum = 0;
	        if(x>0){
	            String xString = Integer.toString(x);
	            // int sum=0;
	            for(int i = 0;i<xString.length();i++){
	                int temp = Integer.valueOf(xString.substring(i,i+1));
	                sum+=temp*Math.pow(10,i);
	            }
	        }else if(x<0&&x>(Integer.MIN_VALUE)){
//	            int y = x*(-1)
	            	int y = Math.abs(x);
	            	String yString = Integer.toString(y);
		            // int sum = 0;
		            for(int i = 0;i<yString.length();i++){
		                int temp = Integer.valueOf(yString.substring(i,i+1));
		                sum+=temp*Math.pow(10,i);
		                if (sum > (long)Integer.MAX_VALUE) {
							sum =0;
							break;
						}
		            }
		            sum = (-1)*sum;
		            if (sum<Integer.MIN_VALUE) {
						sum = 0;
					}
	        }else{
	            return 0;
	        }
	        if(sum<Integer.MAX_VALUE&&sum>=Integer.MIN_VALUE){
	            return (int)sum;
	        }else{
	            return 0;
	        }
	    }
	    public static void main(String[] args) {
			Demo1 demo1 = new Demo1();
			System.out.println(demo1.reverse(-321));
			System.out.println(0.3%10);
		}
	    
	    public int reverse(int x)
	    {
	        int result = 0;

	        while (x != 0)
	        {
	        	//一般情况下，直接取余，通过 newResult 的操作换位
	        	//特殊情况下，即越界时，newResult 的计算会出错，那么看起来会一直成立的 if 判断条件就不会成立，直接 return 0
	            int tail = x % 10;
	            int newResult = result * 10 + tail;
	            if ((newResult - tail) / 10 != result)
	            { return 0; }
	            result = newResult;
	            x = x / 10;
	        }

	        return result;
	    }
	}
