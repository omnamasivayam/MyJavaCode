
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.util.LinkedHashSet;
//import java.util.LinkedList;
import java.util.List;
//import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.LinkedBlockingQueue;

class element {
    String value;
    int distance = 1;

    element(String val) {
        value = val;
        distance = 1;
    }

    // public static void setValue(String val){
    // value = val;
    // }
    public String getValue() {
        return value;
    }

    public void setdistance(int number) {
        distance = number;
    }

    public int getdistance() {
        return distance;
    }
   
    @Override
    public String toString() {
        String s = value;
        return s;
    }

}

class SocialNetwork {
   
    static int users;
    static long repres[][];
    static LinkedHashSet<String> hs = new LinkedHashSet<String>();
    static Queue<element> queueA = new ArrayDeque<element>();
    static List<String> list = new ArrayList<String>();
    static String sourceA;
    static String DestinationA;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
                  //    Queue<element> queueA = new ArrayDeque<element>();
                      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                      int T = Integer.parseInt(br.readLine());
                      String inputs[] = new String[T];
                      String pathOf;

                      for (int z = 0; z < T; z++) {
                                  StringTokenizer st = new StringTokenizer(br.readLine());
                                  while (!st.hasMoreTokens()) {
                                          st = new StringTokenizer(br.readLine());
                                      }
                                  inputs[z] = st.nextToken();
                      }
                      pathOf = br.readLine();
                      StringTokenizer st2 = new StringTokenizer(pathOf, ",");

                      users = getcount(inputs);
                      repres = new long[users][users];
                      visited = new boolean[users];
                      SetRepresentation(repres, inputs, users, hs);
                      sourceA = st2.nextToken();
                      DestinationA = st2.nextToken();

                      int a = list.indexOf(sourceA);
                      element source = new element(sourceA);
                     // source.setdistance(0);
                      visited[a] = true;
                      queueA.add(source);
                      //System.out.println("Size of the que is " + queueA.size());
                      int distance = findShortestPath(sourceA, DestinationA);
                      System.out.println("," + (distance));
    }


    public static int getcount(String[] all) {

        for (int i = 0; i < all.length; i++) {
            StringTokenizer abc = new StringTokenizer(all[i], ",");
            hs.add(abc.nextToken());
            hs.add(abc.nextToken());
        }

        int sizee = hs.size();
         //System.out.println(sizee);
        return sizee;
    }

    public static void SetRepresentation(long[][] matrix, String[] lines,
                int users, LinkedHashSet<String> hset) {
                list = new ArrayList<String>(hset);
                Collections.sort(list);
                int followers[] = new int[users];
                int followedby[] = new int[users];
                int highestFindex = 0;
                int highestFoindex = 0;
                for (int i = 0; i < lines.length; i++) {
                                StringTokenizer abc = new StringTokenizer(lines[i], ",");
                                int a = list.indexOf(abc.nextElement());
                                followedby[a] = followedby[a] + 1;
                                int b = list.indexOf(abc.nextElement());
                                followers[b] = followers[b] + 1;
                                matrix[a][b] = 1;
                                // matrix[a][b] = matrix[a][b] + 1;
                            //    System.out.println("(" + list.get(a) + "," + list.get(b) + ") -" + matrix[a][b] );
                        }
                int j = 0;
                for (j = 0; (j + 1) < (users); j++) {
                                if (followedby[highestFindex] < followedby[j + 1]) {
                                    highestFindex = (j + 1);
                                }

                                if (followers[highestFoindex] < followers[j + 1]) {
                                    highestFoindex = (j + 1);
                                }

                        }
                repres = matrix;
                System.out.print(list.get(highestFindex) + ","+ list.get(highestFoindex));
        }

    private static int findShortestPath(String A, String B) {
    //    Queue<element> queueA = new ArrayDeque<element>();   
    //    element Source = new element(A);
    //    queueA.add(Source);
   
            //    System.out.println("My source is now " + A + " my Destination is " + B);
                int a = list.indexOf(A);
                int b = list.indexOf(B);
                while((queueA.peek()!=null)){
                //        System.out.println("Items in queue" + queueA);
                //        System.out.println("qu size is before removal " + queueA.size());
                          a =list.indexOf(queueA.peek().getValue());
                        element source = queueA.remove();
                        int tdistance = source.getdistance();
                        //System.out.println("removed from queue" + source.getValue());
                //        System.out.println("queue size is  after removal" + queueA.size());
                      
                        for (int i = 0; i < users; i++) {
                                if (repres[a][i] > 0) {
                                        if (i == b) {
                                         //       System.out.println(" got it " + list.get(i));
                                                return (source.getdistance()+1);
                                                //break;
                                        }
                                    //    System.out.println("Not  got it yet " + list.get(i));
                                        String C = list.get(i);
                                        boolean exists = visited[i];
                                        //boolean exists = false;
                                       // System.out.println(list.get(i) + " visited status is " + visited[i]);
                                        if (!exists) {
                                                element next = new element(C);
                                                // int d = getDistanceOfA(a,queueA);
                                                next.setdistance(tdistance + 1);
                                                visited[i] = true;
                                                //System.out.println("Size of the que2 is " + queueA.size());
                                                //System.out.println("added to que is " + next.getValue() + "and its distnace is" + next.getdistance());
                                        //        System.out.println("Items in queue before adding" + queueA);
                                                queueA.add(next);
                                              //  System.out.println("Items in queue after adding" + queueA);
                       
                                                // queueA.add(next);
                                        }
                                }
                        }
                }
                return 0;
            }
}



