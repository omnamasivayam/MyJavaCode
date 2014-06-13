import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;
 
class divide {
 
       public static void main(String[] args) throws IOException  {
              // TODO Auto-generated method stub
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int T = Integer.parseInt(br.readLine());
           
               for (int i= 1; i <=T; i++) {
                      StringTokenizer st = new StringTokenizer(br.readLine());
                      while(!st.hasMoreTokens()) {
                             st = new StringTokenizer(br.readLine());
                      }
                      int N = Integer.parseInt(st.nextToken());  
                      
                   //   BigDecimal ans = powerOf(N);
                      
                    //  double ans = powerOf(N);

                      double ans = Math.pow(0.5, N);
                      System.out.println(new BigDecimal(ans).toPlainString());
                      
               }
               
       }
       
}
