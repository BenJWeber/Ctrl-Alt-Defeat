package GUI_attempt.src.entity;

public class Calculate {
    public double correctWordsTotal; 
    public int wordsPerMinute; 

    public Calculate(){
        setDefaultValues(); 
    } //end Player

    public void setDefaultValues(){ 
        correctWordsTotal = 0; 
        wordsPerMinute = 0; 
    } //end setDefaultValues

    public void wordsPerMinute(){ 
        wordsPerMinute = (int) ( correctWordsTotal * 1.667 ); 
    }
}
