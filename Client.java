/**
 @author ilke
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client_17290104 {
     private static final int PORT =9090;
     
    public static void main(String[] args) throws IOException {
        
        boolean check=false;
        int result;
        Scanner secim;
        Scanner sc1;
         try (Socket s = new Socket("127.0.0.1",PORT)) {
             secim = new Scanner(System.in);
             sc1 = new Scanner (s.getInputStream());
             int number;
             while(!check)
             {
                 System.out.println("Enter a number between 1-10");
                 number = secim.nextInt();
                 PrintWriter user_input = new PrintWriter(s.getOutputStream(),true);
                 user_input.println(number);
                 
                 InputStream in=s.getInputStream();
                 BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                 result=Integer.parseInt( bf.readLine());
                 
                 switch (result) {
                     case 1:
                         System.out.println("CLİENT::Lost! True number is " +number);
                         check = true;
                         break;
                     case 2:
                         System.out.println("CLİENT::You win!");
                         check= true;
                         break;
                     case 3:
                         System.out.println("CLİENT::LOWER!");
                         break;
                     case 4:
                         System.out.println("CLİENT::HIGHER!!");
                         break;
                     default:
                         break;
                 }
                 
             }
         }
        sc1.close();
        secim.close();
    }
}