//import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//import java.util.LinkedList;
//import java.math.BigDecimal;
import java.util.StringTokenizer;
 
class superHero {
 
       public static void main(String[] args) throws IOException  {
             
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int T = Integer.parseInt(br.readLine());
              HashMap<Integer,String> map = new HashMap<Integer,String>();
              int highest =0;
              for (int i= 1; i <=T; i++) {
            	   
                      StringTokenizer st = new StringTokenizer(br.readLine() , ",");
                      
                      while(!st.hasMoreTokens()) {
                             st = new StringTokenizer(br.readLine(), ",");
                      }
                      
                      int id = Integer.parseInt(st.nextToken());
                      String Hero = st.nextToken();
                      map.put(id, Hero);
               }
              int TH = map.size();
              //System.out.println(TH);
              int matrix[][] = new int[TH+1][TH+1];
              
              int T2 = Integer.parseInt(br.readLine());
              String Team[] = new String [T2];
              int wins[] = new int[T2];
              int loss[] = new int[T2];
              int netWins[] = new int[T2];
              int noOfHeros[] = new int[T2];
              for (int i= 0; i <T2; i++) {
           	   
                  StringTokenizer st = new StringTokenizer(br.readLine() , ",");
                  
                  while(!st.hasMoreTokens()) {
                         st = new StringTokenizer(br.readLine(), ",");
                  }
                  Team[i] = st.nextToken();
                  wins[i] = Integer.parseInt(st.nextToken());
                  loss[i] = Integer.parseInt(st.nextToken());
                  netWins[i] = wins[i] - loss[i];
                  //System.out.println("netwins is " + netWins[i]);
                  noOfHeros[i] = Integer.parseInt(st.nextToken());
                  String lists[] = new String[noOfHeros[i]];
                  
                  //int totalCombi = noOfCombinations(noOfHeros[i] , 2);
                  StringTokenizer st2 = new StringTokenizer(st.nextToken(), "|");
                  //String combinations[] = new String[totalCombi];
                  for (int j =0; j<noOfHeros[i]; j++){
                	  lists[j] = st2.nextToken();
                  }
                  for(int k=0; k<noOfHeros[i]; k++){
                	  for(int l=k+1; l<(
                			  noOfHeros[i]); l++){
                		  int a = Integer.parseInt(lists[k]);
                		  int b = Integer.parseInt(lists[l]);
                		 // System.out.println("------------------------------------------");
                		  
                		  matrix[a][b] = matrix[a][b] + netWins[i];
                		  matrix[b][a] = matrix[b][a] + netWins[i];
                		  if(matrix[a][b] > highest) highest = matrix[a][b];
                		 // System.out.println("combination of "+map.get(a) + "and "+ map.get(b) + "is " + netWins[i] + "and total " +  matrix[a][b]   );
                	  }
                  }
                  //System.out.println(highest);
                  
              }
              highest = matrix[0][0];
              for(int z= 1; z < (TH+1) ; z++) {
          	    for(int y= z+1; y <(TH +1); y++) {
          	    	if (highest < matrix[z][y]) {
          	    		highest = matrix[z][y];
                    }
          	       // if(matrix[z][y] == highest)
          	    		//System.out.println("highest is" + highest);
          	          //  System.out.println(map.get(z) + "," + map.get(y) + "=" + matrix[z][y] );
          	        //if(numbers[row][col] > numbers[max.X][max.Y])
          	         //   {max.X = row; max.Y = col;}
          	    } 
          	}         
                  //Point min = new Point(0, 0); 
                 // Point max = new Point(0, 0);
                  //LinkedList<Point> pts= new LinkedList<Point>();
                  for(int z= 1; z < (TH+1) ; z++) {
                	    for(int y= z+1; y <(TH +1); y++) {
                	       if(matrix[z][y] == highest){
                	    		//System.out.println("highest is" + highest);
                	            System.out.println(map.get(z) + " & " + map.get(y));
                	       }
                	        //if(numbers[row][col] > numbers[max.X][max.Y])
                	         //   {max.X = row; max.Y = col;}
                	    } 
                	}           
                  
              
              
              
      
       }
}
              
              
