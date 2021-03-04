/**
 @author ilke
 */
import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Server_17290104 {
     private static final int PORT =9090;
    @SuppressWarnings("empty-statement")
    public static void main(String args[]) throws IOException
    {
        int answer,guess;
        final int MAX=10;
        boolean correctanswer = false;
        int count=0;  
         try (ServerSocket ss = new ServerSocket(PORT)) {
             Socket s = ss.accept();
             Scanner keybord = new Scanner(s.getInputStream());
             Random  randomnumber = new Random();//basically creating random num with rand function
             answer = randomnumber.nextInt(MAX) + 1;
             System.out.println("SERVER::Random number is " +answer);
             int result;
             while(!correctanswer)
             {
                 InputStreamReader in = new InputStreamReader(s.getInputStream());
                 BufferedReader bf = new BufferedReader(in);
                 
                 guess =Integer.parseInt( bf.readLine());;
                 System.out.println("Server::Your Guess is = " +guess);
                 
                 if(count >= 2 && guess != answer)
                 {
                     result=1;
                     System.out.println("SERVER:YOU LOST, Answer was " +answer);
                     PrintWriter Sending_Result = new PrintWriter(s.getOutputStream(),true);
                     Sending_Result.println(result);
                     correctanswer = true;
                     break;
                 }
                 
                 if(guess == answer)
                 {
                     result=2;
                     System.out.println("SERVER:YOU WİN");
                     PrintWriter Sending_Result = new PrintWriter(s.getOutputStream(),true);
                     Sending_Result.println(result);
                     correctanswer = true;
                     count++;
                 }
                 else if(guess > answer)
                 {
                     result =3;
                     System.out.println("SERVER:lower");
                     PrintWriter Sending_Result = new PrintWriter(s.getOutputStream(),true);
                     Sending_Result.println(result);
                     count++;
                 }
                 else if(guess < answer)
                 {
                     result =4;
                     System.out.println("SERVER:HİGHER");
                     PrintWriter Sending_Result = new PrintWriter(s.getOutputStream(),true);
                     Sending_Result.println(result);
                     count++;
                 }
                 
             }}
    }
}