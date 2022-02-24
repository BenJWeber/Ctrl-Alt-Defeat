import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;

public class test {

    public static void main( String[] args ) throws IOException, InterruptedException { 

        System.out.print("Please type a number for the difficulty: \n1 is easy\n2 is medium\n3 is hard\ninput: ");
        Scanner scan = new Scanner( System.in );
        int input = scan.nextInt();
        
        //check if input is valid
        while(input < 1 || input > 3) {
        System.out.print("\nPlease type: \n1 for easy\n2 for medium\n3 for hard\ninput: ");
        input = scan.nextInt();
        }//end while
    
        //splits words into an array from one of the files
        String correctWords[] = library(input).split(" ");
        
        //countdown
        System.out.println("\nGet Ready!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        int length = 0; 
        int errorCounter = 0; 
        System.out.print( "Enter the following text as fast as possible: "); 

        //randomly prints words from the selected word bank
        Random rand = new Random();
        for(int i = 0; i <= 10; i++)
            System.out.print(correctWords[rand.nextInt(50)] + " ");
        System.out.println();

        String user = userInput(); 
        String insult; 
        scan.close();

        String correct = correctWords.toString();
        char[] systemSet = correct.toLowerCase().toCharArray(); 
        char[] userSet = user.toLowerCase().toCharArray(); 
        length = correct.length(); 

        for( int i = 0; i < length - 1 && i < userSet.length; i++ ) { 
            if( systemSet[i] != userSet[i] )
                errorCounter++; 
        }//end for
        if( errorCounter > 0 )
            insult = "You Suck!"; 
        else 
            insult = "Wow you are amazing!";

        System.out.println( "Total number of errors = " + errorCounter + "\n" + insult ); 

    }//end main

    public static String library(int difficulty) throws IOException{ 
        String files[] = {"easyWords.txt", "mediumWords.txt", "hardWords.txt"};
        String list = ""; 
        
        //opens file selected from user                        minus 1 because arrays start at 0
        BufferedReader br = new BufferedReader( new FileReader( files[difficulty - 1] ) );

        String line = br.readLine();

        while( line != null ){ 
            list += line + " "; 
            line = br.readLine(); 
        }//end while
        br.close(); 

        return list; 
    }//end libray

    public static String userInput(){ 
    Scanner scan = new Scanner( System.in ); 
 
       String user  = scan.nextLine(); 
       System.out.println( "User input was: " + user );
        
        scan.close();
        return user; 
    }
}//end class
  