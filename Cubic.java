import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.math.BigDecimal;
import java.util.StringTokenizer;
 
class Cubic {
 
       public static void main(String[] args) throws IOException  {
             
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int T = Integer.parseInt(br.readLine());
           
               for (int i= 1; i <=T; i++) {
            	   
                      StringTokenizer st = new StringTokenizer(br.readLine() , " ");
                      
                      while(!st.hasMoreTokens()) {
                             st = new StringTokenizer(br.readLine(), " ");
                      }
                      Long A =Long.parseLong(st.nextToken());  
                      Long B =Long.parseLong(st.nextToken());  
                      Long C= Long.parseLong(st.nextToken());  
                      Long D = Long.parseLong(st.nextToken()); 
                      Long K = Long.parseLong(st.nextToken()); 
                      
                      
                     

                      
                      double value;
                     // double ans =0;
                      int min =1;
                      int max = 1000000;
                      int mid = 0;
                      while(min<=max)
                      {
                    	  mid=(min+max)/2;
                    	  value=calculateFoo(A,B,C,D,mid);
                    	  if(value<=K){
                    		 // ans = mid;
                    		  min=mid+1;
                    		  if((mid==max||(calculateFoo(A,B,C,D,mid+1))>K)) break;
                    		  
                    	  }
                    	  if(value>K)
                    		  max=mid-1;
                    	  else if(value<K)
                    		  min=mid+1;
                      }
                      System.out.println(mid);
                     
               }
       }

 private static double calculateFoo(double A, double B, double C, double D , int t){
	 double one = A * ( Math.pow(t, 3));
	  double two = B * ( Math.pow(t, 2));
	  double three = C * (t);
	  double four = D;
	  double five =  one + two + three + four;
	 return five;
 }
       
}

