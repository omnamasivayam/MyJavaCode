import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
 
class GCD {
 
       public static void main(String[] args) throws IOException  {
              // TODO Auto-generated method stub
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int T = Integer.parseInt(br.readLine());
           
               for (int z= 1; z <=T; z++) {
                      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                      while(!st.hasMoreTokens()) {
                             st = new StringTokenizer(br.readLine(), " ");
                      }
                      int count = 0;
                      int ans = 0;
                      
                     // StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                      int A = Integer.parseInt(st.nextToken());
                      int B = Integer.parseInt(st.nextToken());
                    //  Long A = Long.parseLong((st.nextToken()));
                    //  Long B = Long.parseLong((st.nextToken()));
                     // BigInteger bi1, bi2, bi3;
                     // bi1 = BigInteger.valueOf(A);
                     // bi2 = BigInteger.valueOf(B);

                      for (int i = A; i>=1; i--){
                    	  for(int j = B; j>=1; j--){
                    	  
                    		//  bi3 = bi1.gcd(bi2);
                    	//	  ans = bi3.intValue();
                    		  ans = gcdThing(i,j);
                    		  if(ans == 1) count++;

                    	  }
                    	
                      }
                      System.out.println(count);
               }
       }
       
       private static int gcdThing(int a, int b) {
    	    BigInteger b1 = new BigInteger(""+a); // there's a better way to do this. I forget.
    	    BigInteger b2 = new BigInteger(""+b);
    	    BigInteger gcd = b1.gcd(b2);
    	    return gcd.intValue();
    	}
}
