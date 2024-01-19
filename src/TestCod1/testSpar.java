package TestCod1;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




        import java.io.PrintStream;
        import java.util.Random;
        import static java.lang.System.*;
        import java.util.*;
        import java.util.stream.Collectors;
        import java.util.function.Supplier;
        import java.util.function.ObjIntConsumer;
        import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class testSpar {

    static Stack<Integer> myStack;

    public static int binaryDecomp(int N){

        List<Integer> A = new ArrayList<>();
        String S = "";
        int z;
        System.out.println("In binaryDecomp: " + N);
        for(int i=1;i<N/2;i++)
        {
            System.out.println("i = " + i);
            S = Integer.toBinaryString(i);
            if(isSparse(S)){
                z = N-i;
                S = Integer.toBinaryString(N-i);
                System.out.println("N - i = " + z);
                if(isSparse(S)){
                    System.out.println("ADDING TO ARRAY OF SPARSE");
                    A.add(i);
                    A.add(N-i);
                    System.out.println("ADDED TO ARRAY ---------- " + i);
                    System.out.println("ADDED TO ARRAY ---------- " + z);
                }
            }


        }
        try {
            int rnd = new Random().nextInt(A.size());
            System.out.println("RANDOM: " + rnd);
            return A.get(rnd);
        }
        catch (Exception e)
            {
                System.out.println("NO SPARSE IN ARRAY ");
                return 0;
            }


    }

    private static boolean isSparse(String N){
        System.out.println("In isSparse: " + N);
        for(int i=0; i<N.length()-1;i++) {

            System.out.println("i = " + i + " char(i) = " + N.charAt(i));
            System.out.println("i + 1 = " + i+1 + " char(i+1) = " + N.charAt(i+1));
            if(N.charAt(i)=='1' && N.charAt(i+1)=='1') {
                System.out.println("TRUE");
                return true;
            }
        }
        System.out.println("FALSE");
        return false;
    }


    public static int parkingBill(String En, String Ex){

       int sum=2, dif = 0;
       int Eh = Integer.parseInt(En.substring(0,2));
       int Em = Integer.parseInt(En.substring(3));
       int Exh = Integer.parseInt(Ex.substring(0,2));
       int Exm = Integer.parseInt(Ex.substring(3));

       dif = Exh - Eh;
       if (dif > 0) {
            for (int i = 1; i <= dif; i++) {
                if (i == 1)
                    sum = sum + 2;
                else
                    sum = sum + 3;
            }
            if (Exm > Em)
                sum=sum+3;


        }
       else
           sum=2;



       // System.out.println("Enter Hour: " + Eh );
        return sum;

    }

    public static int calcMaxSolitaire(Integer[] A) {
        int res =0;
        res=A[0]+A[A.length-1];

        int[] finArray;

        finArray = IntStream.range(0,A.length).filter(i-> i!= 0 && i!=A.length-1).map(i -> A[i]).toArray();
        System.out.println(Arrays.toString(finArray));
        Arrays.sort(finArray);
        for(int i=finArray.length-1;i>=0;i--)
        {
            if(finArray[i]>0)
              res+=finArray[i];
            else
                break;
        }
        System.out.println(res);
        return res;
     }

     public static  void maintainStack(){
        myStack = new Stack<>();

        stackPush(4);
        stackPush(6);
        stackPush(-1);
        stackPush(2);
        stackPush(-3);




     }
     private static void stackPush(Integer v){
        int tmp;
        if(!myStack.isEmpty())
        {
           if (myStack.peek()>v)
              myStack.push(v);
            else {
               tmp = myStack.pop();
               myStack.push(v);
               myStack.push(tmp);
           }
        }
        else
            myStack.push(v);

         System.out.println("Top value is : " + myStack.peek() );
     }
     private static void duplInarray()
     {
        List <Integer> mlist =  new ArrayList<>(Arrays.asList(1,33,4,33,9,9,90,76,1)) ;
         List <Integer> nlist =  new ArrayList<>() ;
         int val;
         int val1;
         for(int i=0;i<mlist.size();i++){
               val = mlist.get(i);
               val1 = mlist.subList(i+1,mlist.size()).indexOf(val);
             System.out.println("print : " + val );
               if(val1 != -1)
               {
                 nlist.add(val);
               }


           }
         System.out.println("Duplicated list is : " + nlist );
       }
         //System.out.println("Duplicated list is : " + nlist );


    private static int permCheck(Integer[] A)
    {
        int res = 1;
        Arrays.sort(A);
        for(int i=0; i< A.length-1; i++){
            if(A[i+1] - A[i] != 1) {
              res = 0;
            }


        }

        return res;
    }

    private static String threeLetters(Integer A, Integer B) {

        String result = new String();
        int ma = A%2;
        int mb = B%2;

        int numA = A/2;
        int numB = B/2;

        int countA=0,countB=0;

        System.out.println((A+B-(ma+mb))/2);

        for(int i=0; i< ((A+B-(ma+mb))/2); i++) {
            countA++;
            if(countA <= numA)
                if(countB <= numB)
                   result = result+"aa";
                else
                    result = result+"0aa";
            else if(ma>0) {
                if(countB <= numB) {
                    result = result + "a";
                    ma = 0;
                }
                else{
                    result = result + "0a";
                    ma = 0;
                }
            }
            countB++;
            if(countB <= numB)
                if(countA <= numA)
                 result = result + "bb";
                else
                    result = result+"0bb";
            else if(mb>0) {
                if (countA <= numA){
                    result = result + "b";
                    mb = 0;
                }
                else {
                    result = result + "0b";
                    mb = 0;
                }

            }

        }


        return result;
    }


    public  static void main(String[] args) throws Exception{

        //1)
        //System.out.println("the random result is: " + binaryDecomp(100) );

        //2)
        //String E = "12:45";
        //String L = "13:45";

        //System.out.println("SUM:   " + parkingBill(E,L) );
        //3)
        //Integer A[] = {3,-3,0,0,3,12,-4,11,-1,2,-7,7,100,-9,-1};
        //System.out.println("SUM:   " + calcMaxSolitaire(A) );
        //4)

        //maintainStack();
         //5)
        //duplInarray();

        //6) Permutation string. In array of integers find if there is a sequence and only 1 appearence of each nuber

        //Integer A[] = {3,1,2,5};
        //System.out.println("result:   " + permCheck(A) );

        //7) Three letters. Given 2 integers A,B. Create string with A times of 'a' and B times of 'B' witn no
        //   three consecuitive letters
        Integer A = 3;
        Integer B=19;
        System.out.println("result:   " + threeLetters(A,B) );
    }




}








