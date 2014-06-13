import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

class GPS {
    static int lowest =0;
    static int highest =0;
    public static void main(String[] args) throws IOException  {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //String lines[] = new String[T];
        double elevation[] = new double[T];
        double latitude[] = new double[T];
        double longitude[] = new double[T];
        String dateTime[] = new String[T];
        //String time[] = new String[T];
        int id[] = new int[T];

        for (int z= 0; z <T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , ",");
            while(!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine(), ", ");
            }
            //  lines[z] = st.nextToken();
            elevation[z] = Double.parseDouble(st.nextToken());
            dateTime[z] = st.nextToken();
            id[z] = Integer.parseInt(st.nextToken());
            latitude[z]= Double.parseDouble(st.nextToken());
            longitude[z]= Double.parseDouble(st.nextToken());
        }

        int check =0;
        int a[] = new int[6];
        int b[] = new int[6];
        int c[] = new int[6];
        double TimeTaken2 = 0;
        for(int h=0; h < (T-1);h++){
        	a =( getDetails(dateTime[h]));
            b = getDetails(dateTime[h+1]);
        	
        	TimeTaken2 =  TimeTaken2 + TimeTaken(a,b);
        	//System.out.println(TimeTaken2 + "- TimeTaken in hrs");
        }
   //     TimeTaken = TimeTaken;
        
        double distance2 =0 ;
        for(int h=0; h < (T-1);h++){
        	
        	distance2 = distance2 + (distFrom(latitude[h] ,  longitude[h],latitude[h+1], longitude[h+1]));
        	
        
        }
       // distance2 = distance2/T;
        
       // System.out.println("distance2 " + distance2 + "Speed" + (distance2/TimeTaken2) );
        System.out.println(String.format("%.1f", distance2) + "," +String.format("%.1f", (distance2/TimeTaken2))) ;
        
        for(int i=0; i<T;i++){

                a =( getDetails(dateTime[lowest]));
                b = getDetails(dateTime[highest]);
                c = getDetails(dateTime[i]);
                check = checkDateTime(c,a);
                    if (check == 1) lowest = i ;
                check = checkDateTime(c,b);
                    if(check ==2) highest =i;
        }
        a =( getDetails(dateTime[lowest]));
        b = getDetails(dateTime[highest]);
        double hours =     TimeTaken(a,b);
    //    System.out.println(hours);
        //System.out.println(dateTime[lowest]);
        //System.out.println(dateTime[highest]);
        double distance =0 ;
        //double distnce2 =0;
        distance = distFrom(latitude[lowest] ,  longitude[lowest],latitude[highest], longitude[highest]);
        //distance = distance(latitude[lowest] ,  longitude[lowest],latitude[highest], longitude[highest] , 'K');
        //double actDistance = Math.round(distance * 100.0) / 100.0;
        //double actSpeed = Math.round((distance/hours) * 100.0) / 100.0;
        //System.out.println(actDistance);
        //System.out.println(actSpeed);
        //double Speed = (distance/hours);
       // System.out.println(String.format("%.1f", distance) + "," +String.format("%.1f", (distance/hours))) ;
    //    System.out.println(String.format("%.1f", Speed));
    //    System.out.println(hours);
    //    System.out.println();
        
        //System.out.println(distnce2);
    }


private static int[] getDetails(String a){
    int details[] = new int[6];
    StringTokenizer stz = new StringTokenizer(a, "T");
    StringTokenizer stz2 = new StringTokenizer((stz.nextToken()),"-");
    details[0] = Integer.parseInt(stz2.nextToken());
    details[1] = Integer.parseInt(stz2.nextToken());
    details[2] = Integer.parseInt(stz2.nextToken());
    StringTokenizer stz3 = new StringTokenizer((stz.nextToken()),"Z");
    StringTokenizer stz4 = new StringTokenizer((stz3.nextToken()),":");
    details [3] = Integer.parseInt(stz4.nextToken());
    details[4] = Integer.parseInt(stz4.nextToken());
    details[5] = Integer.parseInt(stz4.nextToken());
    return details;
}

private static int checkDateTime(int[] high, int[]low){
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String dateStart = (high[0] + "/"  + high[1] + "/"  + high[2] + " "  + high[3] + ":"  + high[4] + ":"  +high[5]);
    String dateStop = (low[0] + "/"  + low[1] + "/"  + low[2] + " "  + low[3] + ":"  + low[4] + ":"  +low[5]);
    try {
    Date d1 = null;
    Date d2 = null;
    d1 = format.parse(dateStart);
    d2 = format.parse(dateStop);
    double diff = (d1.getTime() - d2.getTime());
    if (diff <=0) return 1;
    else return 2;
    } catch (Exception e) {
        e.printStackTrace();
        return 1;
    }
    }

public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
    double earthRadius = 6373;
    double dLat = Math.toRadians(lat2-lat1);
    double dLng = Math.toRadians(lng2-lng1);
    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double dist = earthRadius * c;

   // int meterConversion = 1609;
    //double distance = ((double) ((dist * meterConversion)/1000));
    double distance = ((double) ((dist)));
    return distance;
    }

public static double TimeTaken(int high[] , int low[])  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String dateStart = (high[0] + "/"  + high[1] + "/"  + high[2] + " "  + high[3] + ":"  + high[4] + ":"  +high[5]);
    String dateStop = (low[0] + "/"  + low[1] + "/"  + low[2] + " "  + low[3] + ":"  + low[4] + ":"  +low[5]);
    try {
    Date d1 = null;
    Date d2 = null;
    d1 = format.parse(dateStart);
    d2 = format.parse(dateStop);
    double diff = (d2.getTime() - d1.getTime());
    return (diff/3600000.0);
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}

///////////////
private static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
    double theta = lon1 - lon2;
    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
    dist = Math.acos(dist);
    dist = rad2deg(dist);
    dist = dist * 60 * 1.1515;
    if (unit == 'K') {
      dist = dist * 1.609344;
    } else if (unit == 'N') {
      dist = dist * 0.8684;
      }
    return (dist);
  }

  /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
  /*::  This function converts decimal degrees to radians             :*/
  /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
  private static double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
  }

  /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
  /*::  This function converts radians to decimal degrees             :*/
  /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
  private static double rad2deg(double rad) {
    return (rad * 180.0 / Math.PI);
  }

}
