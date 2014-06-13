import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


class Blast {
	
	static int Gterrorists[][];
	static int Gpower[][];
	static int GM;
	static int GN;
	static int count=0;
	static Set<String> set = new HashSet<String>();
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		 
        
        for (int i = 0; i < T; i++) {
        	count=0;
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
   		 	while(!st.hasMoreTokens()) {
   			  st = new StringTokenizer(br.readLine(), " ");
   		 	}
        	set.clear();
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	GM = M;
        	GN = N;
        	Gterrorists = new int[N][M];
        	Gpower = new int[N][M];
        	int terroists[][] = new int[N][M];
        	int power[][] = new int[N][M];
        	for(int j = 0; j < N ; j++){
        		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        		for(int k = 0; k < M; k ++){
        			terroists[j][k] =Integer.parseInt(st2.nextToken());
        		}
        	}
        	Gterrorists = terroists;
        	for(int j = 0; j < N ; j++){
        		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        		for(int k = 0; k < M; k ++){
        			power[j][k] =Integer.parseInt(st2.nextToken());
        		}
        	}
        	Gpower = power;
        	//Print();
        	//Print2();
        	Traverse();
        	//Print();
        	System.out.println(count);
        	//System.out.println(set.size());
        	for(String s: set){
        		if(s != "\n")
        		System.out.println(s);
        		
        		//System.out.print("next item");
        	}
        	
        }
	}

//private static void Traverse(int[][] a, int[][] b )	{
private static void Traverse()	{
	//Gterrorists = a;
	//Gpower = b;
	for(int j = 0; j < GN ; j++){
		for(int k = 0; k < GM; k ++){
			if(Gterrorists[j][k] == 1) {
				Blast(j,k,Gpower[j][k]);
				set.add(j + " " + k);
				count++;
				
			}
		}
	}
}

private static void Blast(int y, int z, int b){
	int k = z;
	int j = y;
	for(int r = 0; r <= b ; r++,k++){
		if(k < GM){
			Gterrorists[j][k] = 0;
		}
	}
	k=z; j=y;
	for(int r = 0; r <= b ; r++,j++){
		if(j < GN){
			Gterrorists[j][k] = 0;
		}
	}
	k=z; j=y;
	for(int r = 0; r <= b ; r++,k--){
		if(!(k < 0)){
			Gterrorists[j][k] = 0;
		}
	}
	k=z; j=y;
	for(int r = 0; r <= b ; r++,j--){
		if(!(j < 0)){
			Gterrorists[j][k] = 0;
		}
	}
}
}
