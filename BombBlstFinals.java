import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class BombBlstFinals {
	static int Gterrorists[][];
	static int Gpower[][];
	static int Bpower[][];
	static int GM;
	static int GN;
	static int count=0;
	static Set<String> set = new HashSet<String>();
	static Set<String> set2 = new HashSet<String>();
	static Set<String> set3 = new HashSet<String>();
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
			set2.clear();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			GM = M;
			GN = N;
			Gterrorists = new int[N][M];
			Gpower = new int[N][M];
			Bpower = new int[N][M];
			int terroists[][] = new int[N][M];
			int power[][] = new int[N][M];
			for(int j = 0; j < N ; j++){
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < M; k ++){
					terroists[j][k] =Integer.parseInt(st2.nextToken()); 
					if(terroists[j][k] == 1){
                        set3.add(j + " " + k);
                        count++;
                 }
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
			//BombPower();
			for(int j = 0; j < GN ; j++){
				for(int k = 0; k < GM; k ++){
					int bcount = Blast2(j,k,Gpower[j][k]);
					if(bcount > 8){
						BombBlast(j,k,(Gpower[j][k]));
						set.add(j + " " + k);
					}
				}
			}
			BombPower();
			List<String> list = new ArrayList<String>(set2);
			Collections.sort(list, Collections.reverseOrder());
			int size = set2.size();
			Set<Integer> row = new HashSet<Integer>();
			Set<Integer> column = new HashSet<Integer>();
			int a =1;
			for(int my =0; (my<size) && (a >=1); my++){	
				StringTokenizer st2 = new StringTokenizer(list.get(my), " ");
				a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());
				//System.out.println("Big bomb is " + a + " " + b+ " " + c);
					int bcount = Blast2(b,c,Gpower[b][c]);
					if(bcount > 5){
						BombBlast(b,c,Gpower[b][c]);
						set.add(b + " " + c);
						row.add(b);
						column.add(c);
					}

				}
			set2.clear();
			row.clear();
			column.clear();
			BombPower();
			list = new ArrayList<String>(set2);
			Collections.sort(list, Collections.reverseOrder());
			size = set2.size();
			a =1;
			for(int my =0; (my<size) && (a >=1); my++){	
				StringTokenizer st2 = new StringTokenizer(list.get(my), " ");
				a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());
				//System.out.println("Big bomb is " + a + " " + b+ " " + c);
					int bcount = Blast2(b,c,Gpower[b][c]);
					if(bcount > 1){
						BombBlast(b,c,Gpower[b][c]);
						set.add(b + " " + c);
						row.add(b);
						column.add(c);
					}

				}
			
			
			Traverse();
			//checkOp();
			System.out.println(set.size());
			for(String s: set){
				System.out.println(s);
			}

		}
	}
	
	private static void Traverse()    {
		for(int j = 0; j < GN ; j++){
			for(int k = 0; k < GM; k ++){
				if(Gterrorists[j][k] == 1) {
					BombBlast(j,k,(Gpower[j][k]));
					set.add(j + " " + k);
					//k = k +(Gpower[j][k]-1);
				}
			}
		}
	}
	private static void Blast(int y, int z, int b){
		int k = z;
		int j = y;
		b = b +j;
		Gterrorists[j][k] = 0;
		for(j=j+1; j<=b;j++){
			if(j< GN)
				Gterrorists[j][k] = 0;
			else break;

		}
	}
	private static int Blast2 (int y, int z, int b){
		int k = z;
		int j = y;
		int ba = b +j;
		int power =0;

		if(Gterrorists[j][k] == 1) power++;
		for(j=j+1; j<=ba;j++){
			if(j< GN){
				if(Gterrorists[j][k] == 1) power++;
			}
			else break;
		}

		k = z;j = y;
		ba = b +k;
		for(k=k+1; k<=ba;k++){
			if(k< GM){
				if(Gterrorists[j][k] == 1) power++;
			}
			else break;
		}

		k = z;j = y;
		ba = j-b;
		for(j=j-1; j>=ba;j--){
			if(j >= 0){
				if(Gterrorists[j][k] == 1) power++;
			}
			else break;
		}

		k = z;j = y;
		ba = k-b;
		for(k=k-1; k>=ba;k--){
			if(k >= 0){
				if(Gterrorists[j][k] == 1) power++;
			}
			else break;      
		}
		return power;
	}


	private static void BombBlast (int y, int z, int b){
		int k = z;
		int j = y;
		int ba = b +j;
		Gterrorists[j][k] = 0;

		for(j=j+1; j<=ba;j++){
			if(j< GN){
				Gterrorists[j][k] = 0;
			}
			else break;

		}

		k = z;j = y;
		ba = b +k;
		for(k=k+1; k<=ba;k++){
			if(k< GM){
				Gterrorists[j][k] = 0;
			}
			else break;

		}
		k = z;j = y;
		ba = j-b;
		for(j=j-1; j>=ba;j--){
			if(j >= 0){
				Gterrorists[j][k] = 0;
			}
			else break;

		}
		k = z;j = y;
		ba = k-b;
		for(k=k-1; k>=ba;k--){
			if(k >= 0){
				Gterrorists[j][k] = 0;
			}
			else break;      
		}BombBlstFinalsj++){
			for(int k = 0; k < GM; k ++){
				Bpower[j][k]= Blast2(j,k,(Gpower[j][k]));
				set2.add(Bpower[j][k] + " " + j + " " + k);
			}
		}
		//Print2();
	}
	
	private static void checkOp(){
	       for(String s: set3){
	              StringTokenizer st2 = new StringTokenizer(s);
	              int o = Integer.parseInt(st2.nextToken());
	              int m = Integer.parseInt(st2.nextToken());
	              if(Gterrorists[o][m] != 0){
	                     set.add(o + " " + m);
	              }
	       }
	}
	private static void Print2(){
		System.out.println("----------------------Power IS ----------------");
		for(int j = 0; j < GN ; j++){
			for(int k = 0; k < GM; k ++){
				System.out.print(Bpower[j][k] + " ");
			}
			System.out.println();
		}
	}


}
