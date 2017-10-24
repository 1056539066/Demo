package indi.Leo.experiment;

public class DoCal {
	public static double  Add(double a,double b){
		return a+b;
	}
	
	
	public static String handlebracket(String s){
		int fb,bb;
		String fs,bs,ms;
		String fs1,bs1;
		String out;
		if(s.contains("(")){
				fb=s.lastIndexOf("(");
				bb=s.indexOf(")");
				if(bb<fb){
					int midsi=getnsi(s.substring(bb,fb))+bb;
					fs1=s.substring(0,midsi);
					bs1=s.substring(midsi+1);
					return out=handlebracket(handlebracket(fs1)+s.substring(midsi,midsi+1)+handlebracket(bs1));
				}
				
				else{
					fs=s.substring(0,fb);
					ms=s.substring(fb+1,bb);
					bs=s.substring(bb+1);
				
					if(ms.substring(0,1).equals("-"))
					{
						if(fs.contains("(")&&bs.contains(")")){
							fb=fs.lastIndexOf("(");
							bb=bs.indexOf(")")+bb+1;
							fs=s.substring(0,fb);
							ms=s.substring(fb+1,bb);
							bs=s.substring(bb+1);
							ms=DoCal.handlefomula(ms);
							return out=handlebracket(fs+ms+bs);
						}
						else return out=DoCal.handlefomula(s);
					}
					else{
						ms=DoCal.handlefomula(ms);
						return out=handlebracket(fs+ms+bs);
					}
				}
			}else return out=DoCal.handlefomula(s);
	}
	
	public static String handlefomula(String s){
		int sp;
		String fst,bst;
		String out;
		double num1 = 0,num2 = 0,re = 0;
		int lsi,nsi;
		if(s.contains("√")){
			sp=s.indexOf("√");
			fst=s.substring(0,sp);
			bst=s.substring(sp+1);
			if(bst.contains("*")||bst.contains("/")||bst.contains("+")||bst.contains("-")||fst.contains("√")){
				nsi=getnsi(bst);
				num2=Double.parseDouble(bst.substring(0,nsi));
				bst=bst.substring(nsi);
			}
			else if(bst.contains(")")){
				num2=Double.parseDouble(bst.substring(0,bst.indexOf(")")));
				bst=bst.substring(bst.indexOf(")"));
			}
			else{
				num2=Double.parseDouble(bst);
				bst="";
			}
			re=Math.sqrt(num2);
			return out=handlefomula(fst+re+bst);
		}
		else if(s.contains("*")){
			sp=s.indexOf("*");
			fst=s.substring(0,sp);
			bst=s.substring(sp+1);
			if(fst.contains("*")||fst.contains("/")||fst.contains("+")||fst.contains("-")||fst.contains("√")){
				if(fst.substring(fst.length()-1).equals(")")){
					num1=-Double.parseDouble(fst.substring(fst.lastIndexOf("-")+1,fst.lastIndexOf(")")));
					fst=fst.substring(0,fst.lastIndexOf("("));
				}
				else{
					lsi=getlsi(fst);	
					num1=Double.parseDouble(fst.substring(lsi+1));
					fst=fst.substring(0,lsi+1);
				}
				
			}
			else{
				num1=Double.parseDouble(fst);
				fst="";
			}
			if(bst.contains("*")||bst.contains("/")||bst.contains("+")||bst.contains("-")||bst.contains("√")){
				if(bst.substring(0,1).equals("(")){
					num2=-Double.parseDouble(bst.substring(bst.indexOf("-")+1,bst.indexOf(")")));
					bst=bst.substring(bst.indexOf(")")+1);
				}
				else{
					nsi=getnsi(bst);
					num2=Double.parseDouble(bst.substring(0,nsi));
					bst=bst.substring(nsi);
				}
			}
			else{
				num2=Double.parseDouble(bst);
				bst="";
			}
			re=num1*num2;
			if(re<0)
				return out=handlefomula(fst+"("+re+")"+bst);
			else
				return out=handlefomula(fst+re+bst);
		}
		else if(s.contains("/")){
			sp=s.indexOf("/");
			fst=s.substring(0,sp);
			bst=s.substring(sp+1);
			if(fst.contains("*")||fst.contains("/")||fst.contains("+")||fst.contains("-")||fst.contains("√")){
				if(fst.substring(fst.length()-1).equals(")")){
					num1=-Double.parseDouble(fst.substring(fst.lastIndexOf("-")+1,fst.lastIndexOf(")")));
					fst=fst.substring(0,fst.lastIndexOf("("));
				}
				else{
					lsi=getlsi(fst);	
					num1=Double.parseDouble(fst.substring(lsi+1));
					fst=fst.substring(0,lsi+1);
				}
			}
			else{
				num1=Double.parseDouble(fst);
				fst="";
			}
			if(bst.contains("*")||bst.contains("/")||bst.contains("+")||bst.contains("-")||bst.contains("√")){
					if(fst.substring(0,1).equals("(")){
						num2=-Double.parseDouble(bst.substring(bst.indexOf("-")+1,bst.indexOf(")")));
						bst=bst.substring(bst.indexOf(")")+1);
						
					}
					else{
						nsi=getnsi(bst);
						num2=Double.parseDouble(bst.substring(0,nsi));
						bst=bst.substring(nsi);
					}
			}
			else{
				num2=Double.parseDouble(bst);
				bst="";
			}
			re=num1/num2;
			if(re<0)
				return out=handlefomula(fst+"("+re+")"+bst);
			else
				return out=handlefomula(fst+re+bst);
		}
		else if(s.contains("+")){
			sp=s.indexOf("+");
			fst=s.substring(0,sp);
			bst=s.substring(sp+1);
			if(fst.contains("*")||fst.contains("/")||fst.contains("+")||fst.contains("-")||fst.contains("√")){
				if(fst.substring(fst.length()-1).equals(")")){
					num1=-Double.parseDouble(fst.substring(fst.lastIndexOf("-")+1,fst.lastIndexOf(")")));
					fst=fst.substring(0,fst.lastIndexOf("("));
				}
				else{
					lsi=getlsi(fst);	
					num1=Double.parseDouble(fst.substring(lsi+1));
					fst=fst.substring(0,lsi+1);
				}
			}
			else{
				num1=Double.parseDouble(fst);
				fst="";
			}
			if(bst.contains("*")||bst.contains("/")||bst.contains("+")||bst.contains("-")||bst.contains("√")){
				if(bst.substring(0,1).equals("(")){
					num2=-Double.parseDouble(bst.substring(bst.indexOf("-")+1,bst.indexOf(")")));
					bst=bst.substring(bst.indexOf(")")+1);
				}
				else{
					nsi=getnsi(bst);
					num2=Double.parseDouble(bst.substring(0,nsi));
					bst=bst.substring(nsi);
				}
			}
			else{
				num2=Double.parseDouble(bst);
				bst="";
			}
			re=num1+num2;
			if(re<0)
				return out=handlefomula(fst+"("+re+")"+bst);
			else
				return out=handlefomula(fst+re+bst);
		}
		else if(s.contains("-")){
			sp=s.indexOf("-");
			fst=s.substring(0,sp);
			bst=s.substring(sp+1);
			if(s.indexOf("-")==1&&s.indexOf("(")==0&&s.lastIndexOf("(")==0&&s.indexOf(")")+1==s.length()&&!s.substring(s.indexOf("-")+1).contains("-")){
					return out=s;				
				}
			else if(s.contains("-")){ 
				if(s.contains("(-")&&s.indexOf("(-")==0&&s.substring(s.indexOf("-")).contains("-")){
					sp=s.substring(s.indexOf("-")+1).indexOf("-");
					fst=s.substring(0,sp);
					bst=s.substring(sp+1);
				}
				if(fst.contains("*")||fst.contains("/")||fst.contains("+")||fst.contains("-")||fst.contains("√")){
					if(fst.substring(fst.length()-1).equals(")")){
						num1=-Double.parseDouble(fst.substring(fst.lastIndexOf("-")+1,fst.lastIndexOf(")")));
						fst=fst.substring(0,fst.lastIndexOf("("));
					}
					else{
						lsi=getlsi(fst);	
						num1=Double.parseDouble(fst.substring(lsi+1));
						fst=fst.substring(0,lsi+1);
					}
				}
				else{
					num1=Double.parseDouble(fst);
					fst="";
				}
				if(bst.contains("*")||bst.contains("/")||bst.contains("+")||bst.contains("-")||bst.contains("√")){
					if(bst.substring(0,1).equals("(")){
						num2=-Double.parseDouble(bst.substring(bst.indexOf("-")+1,bst.indexOf(")")));
						bst=bst.substring(bst.indexOf(")")+1);
					}
					else{
						nsi=getnsi(bst);
						num2=Double.parseDouble(bst.substring(0,nsi));
						bst=bst.substring(nsi);
					}
				}
				else{
					num2=Double.parseDouble(bst);
					bst="";
				}
				re=num1-num2;
				if(re<0)
					return out=handlefomula(fst+"("+re+")"+bst);
				else
					return out=handlefomula(fst+re+bst);
			}
			else return out=handlefomula(fst+re+bst);
		}
		else return s;
	}
	
	public static int getlsi(String s){
		int mul,add,min,div,lsi;
		if(s.contains("*"))
			mul=s.lastIndexOf("*");
		else mul=0;
		if(s.contains("+"))
			add=s.lastIndexOf("+");
		else add=0;
		if(s.contains("-"))
			min=s.lastIndexOf("-");
		else min=0;
		if(s.contains("/"))
			div=s.lastIndexOf("/");
		else div=0;
		lsi=mul;
		if(add>lsi) lsi=add;
		if(min>lsi) lsi=min;
		if(div>lsi) lsi=div;
		return lsi;
	}
	
	public static int getnsi(String s){
		int mul,add,min,div,lsi;
		if(s.contains("*"))
			mul=s.indexOf("*");
		else mul=20;
		if(s.contains("+"))
			add=s.indexOf("+");
		else add=20;
		if(s.contains("-"))
			min=s.indexOf("-");
		else min=20;
		if(s.contains("/"))
			div=s.indexOf("/");
		else div=20;
		lsi=mul;
		if(add<lsi) lsi=add;
		if(min<lsi) lsi=min;
		if(div<lsi) lsi=div;
		return lsi;
	}
	
	
}


