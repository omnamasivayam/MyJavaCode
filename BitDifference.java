import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
//commite on git hub directly
class BitDifference {

    public static void main(String[] str) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String abc = br.readLine();

        String search = br.readLine();

        String arr[] = abc.split(",");

        String ans = "";

        byte[] findArr = convertToByte(search);

        byte[] keyArr = null;

        int c;

        for (int i = 0; i < arr.length; i++) {

            c = 0;

            try

                {

                    keyArr = convertToByte(Integer.toBinaryString(Integer.parseInt(arr[i])));

 

                }

            catch(Exception e)

                {

                    continue;

                }

 

            for (int k = 0; k < 31; k++) {

                if (findArr[k] != keyArr[k]) {

                    c++;

                    if (c > 4)

                        break;

                }

                if (findArr[63 - k] != keyArr[63 - k]) {

                    c++;

                    if (c > 4)

                        break;

                }

 

            }

 

            if (c <= 4) {

                ans = ans+arr[i]+",";

            }

        }

        System.out.print(ans);

    }

 

    public static byte[] convertToByte(String input) {

        byte byteArr[] = new byte[64];

        int length = input.length();

        for (int i = 0; i < length; i++) {

            byteArr[63-i]=(byte) ((byte)input.charAt(length-1-i)^48);

        }

        return byteArr;

    }

 

}
