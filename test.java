import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;

public class test {
    public static void main( String[] args ) throws IOException { 
        String correct = library();
        int length = 0; 
        int errorCounter = 0; 
        System.out.println( "Enter the following text as fast as possible: " + correct ); 
        String user = userInput(); 
        String insult; 

        char[] systemSet = correct.toLowerCase().toCharArray(); 
        char[] userSet = user.toLowerCase().toCharArray(); 
        length = correct.length(); 

        for( int i = 0; i < length - 1; i++ ){ 
            if( systemSet[i] != userSet[i] )
                errorCounter++; 
        }
        if( errorCounter > 0 )
            insult = "You Suck!"; 
        else 
            insult = "Wow you are amazing!";

        System.out.println( "Total number of errors = " + errorCounter + "\n" + insult ); 

    }//end main

    public static String library() throws IOException{ 
        String list = ""; 

        BufferedReader bf = new BufferedReader( new FileReader( "words.txt" ) );

        String line = bf.readLine();

        while( line != null ){ 
            list += line + " "; 
            line = bf.readLine(); 
        }

        bf.close(); 

        return list; 
    }

    public static String userInput(){ 
        Scanner userIn = new Scanner( System.in ); 

        String holder  = userIn.nextLine(); 

        System.out.println( "User input was: " + holder );
        
        userIn.close();
        return holder; 
    }
}//end class
  