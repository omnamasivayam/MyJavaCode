
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Prime {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Na = Integer.parseInt(br.readLine());
		 //int Na = sc1.nextInt();
		//int a[] = new int[Na];
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		//while(st.hasMoreTokens()){
		//	a[i++] = Integer.parseInt(st.nextToken());
		//}
		
		 
		 for (int z = 1; z <=Na; z++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 while(!st.hasMoreTokens()) {
				  st = new StringTokenizer(br.readLine());
			 }
			 int flag = 0;
				 //int wt = Integer.parseInt(br.readLine()); 
			 		int wt = Integer.parseInt(st.nextToken());	 
			 		for(int j = 1 ; j <=(wt/2) ; j++){
				 
			 			if( (isPrime(j)) && (isPrime(wt-j))){
			 				System.out.println("Deepa");
			 				flag =1;
			 				break;
			 			}
			 			// System.out.println("no");
				 
			 		}
			 if(flag == 0){
				 System.out.println("Arjit");
			 }
			 }
			 
		 }	
	
	private static boolean isPrime(int number){
		
		if(number <= 1) return false;
		
		if((number == 2) || (number == 3)) return true;
		
		if((number % 2) == 0) return false;
		
		if((number % 3) == 0) return false;
		
		for(int i=3; (i*i)<number; i=i+2){
			if((number % i) == 0) return false;
		}
			
		return true;
	}

}
