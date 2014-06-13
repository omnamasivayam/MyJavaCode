import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class rotate2dMatrix {
        static int matrixSize = 0;
        
       public static void main(String[] args) throws IOException  {
              // TODO Auto-generated method stub
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int T = Integer.parseInt(br.readLine());
              matrixSize = T;
              int a[][] = new int[T][T];
              int last[][] = new int[T][T];
               for (int i= 0; i <T; i++) {
                         
                      StringTokenizer st = new StringTokenizer(br.readLine());
                      while(!st.hasMoreTokens()) {
                             st = new StringTokenizer(br.readLine());
                      }
                      StringTokenizer st2 = new StringTokenizer(st.nextToken() , ",");
                      while(st2.hasMoreTokens()){
                          for(int j=0; j < T; j ++){
                              a[i][j] = Integer.parseInt(st2.nextToken());
                          }   
                      }
               }
               String Actions = new String(br.readLine());

               
               char [] act = new char[Actions.length()];
               for (int k =0 ; k < Actions.length(); k++ ){
                   act[k]= Actions.charAt(k);
               }
               last =a;
               for (int k =0 ; k < Actions.length(); k++ ){
                  
                   switch(act[k]){
                   case 'A':
                      // System.out.println("A");
                       last = antiClockWise(last);
                       break;
                       
                   case 'C':
                     //  System.out.println("C");
                       last = clockWise(last);
                       break;
                
                   case 'T':
                     //  System.out.println("T");
                       last = transpose(last);
                       break;
                       
                   case '/':
                  //     System.out.println("/");
                       last = swapNE(last);
                     //  last = swapNW(last);
                       break;
                   
                   case '\\':
                     //   System.out.println("\\");
                          last = swapNW(last);
                     //      last = swapNE(last);
                           break;
                   }
               }
               
               //printMatrix(antiClockWise(a));
              printMatrix(last);
       }      
               
       private static int[][] antiClockWise(int[][] mat){
           int result[][] = new int[matrixSize][matrixSize];
           for(int i=0,z=(matrixSize-1);i<matrixSize; i++,z--){
               for(int j=0;j<matrixSize; j++){
                   result[i][j] = mat[j][z];
               }
           }
           return result;
       }
       
       private static int[][] clockWise(int[][] mat){
           int result[][] = new int[matrixSize][matrixSize];
           for(int i=0;i<matrixSize; i++){
               for(int j=0,z=(matrixSize-1);j<matrixSize; j++,z--){
                   result[i][j] = mat[z][i];
               }
           }
            return result;
        }
       private static int[][] transpose(int[][] mat){
           int result[][] = new int[matrixSize][matrixSize];
           for(int i=0;i<matrixSize; i++){
               for(int j=0;j<matrixSize; j++){
                   result[i][j] = mat[j][i];
               }
           }
            return result;
        }
       private static int[][] swapNE(int[][] mat){
           int result[][] = new int[matrixSize][matrixSize];
           for(int i=0,z=(matrixSize-1);i<matrixSize; i++,z--){
               for(int j=0,y=(matrixSize-1);j<matrixSize; j++,y--){
                  result[i][j] = mat[y][z];
               }
            }
            return result;
        }
       
       private static int[][] swapNW(int[][] mat){
           int result[][] = new int[matrixSize][matrixSize];
           for(int i=0;i<matrixSize; i++){
               for(int j=0;j<matrixSize; j++){
                   result[i][j] = mat[j][i];
            	//   result[i][j]=mat[]
               }
           }
            return result;
        }
       
       private static void printMatrix(int[][] mat){
           for(int i=0;i<matrixSize; i++){
               for(int j=0;j<matrixSize; j++){
                   if(j!=matrixSize-1){
                   System.out.print(mat[i][j] + "," );}
                   else System.out.println(mat[i][j]);
               }
              // System.out.println("\n");
           }
           
       }

       
}
