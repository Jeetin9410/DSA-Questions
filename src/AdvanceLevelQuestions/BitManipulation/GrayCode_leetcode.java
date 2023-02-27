package AdvanceLevelQuestions.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_leetcode {
    /*
      You are given a number N.
      You have to generate and print all n-bit grey code sequence.
      In grey code sequence , successive terms differ by one bit.

      Example
       Input :
       n = 2

       Output:
       00
       01
       11
       10

     */

    public static void main(String[] args) {
        /*
        Appraoch 1:
        to find gray code for  n
              we will find  gray code for n-1.
              Why so ? because If we add "0" and "1" at the beginning of all the gray code of n-1,
                       we will get the gray code of n.

              Example :
               n = 1 ==> [ 0 , 1 ]

               n = 2 ==> [ 0 , 1 , 1 , 0] first we write previous gray code
                         [ 00, 01 , 11 , 10] adding 0 and 1 we get gray code.

                         Question : we didnt write it 0,1,0,1 and then add 0 and 1.Why ?
                         Ans : Because in gray code printing or formation we are allowed to change 1 bit at time ONLY
                               so if duplicate 0,1 twice i.e 0,1,0,1
                               adding 0 and 1 will not  00,01, 10, 11   so going from 01 to  10 2 bits changed

                               So we will take 0 , 1 and reverse of this order i.e 1, 0
         */
       // ArrayList<String> ans = solution(3);

     //   for(int i=0;i<ans.size();i++){
       //     System.out.println(ans.get(i));
       // }
        //Above solution will take time approx 45ms


        /*
        Appraoch 2 : Using Bit manipulation


         */

        int n =3;

        List<Integer> v = new ArrayList<Integer>();
        for(int i=0; i<8; i++) {
            v.add(i^(i>>1));
           // System.out.println(Integer.toBinaryString(i)+" "+Integer.toBinaryString(i>>1)+ " "+Integer.toBinaryString(i^(i>>1)));
        }
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }

    public static ArrayList<String> solution(int n) {

        if( n ==1 ){
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("0");
            baseRes.add("1");
            return baseRes;
        }

        ArrayList<String> rres = solution(n -1);
        ArrayList<String> myres = new ArrayList<>();

        for(int i =0;i< rres.size();i++){
            String rstr = rres.get(i);
            myres.add("0"+rstr);
        }

        for(int i = rres.size()-1; i>=0;i--){
            String rstr = rres.get(i);
            myres.add("1"+rstr);
        }

        return myres;
    }
}
