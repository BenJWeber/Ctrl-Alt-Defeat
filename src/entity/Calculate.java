/**
 * 
 * Calculate.java
 * Description: Calculate words per minute after using completes level in regular mode. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package src.entity;

public class Calculate {
    public double correctWordsTotal; 
    public int wordsPerMinute; 

    /**
     * Constructor
     */
    public Calculate(){
        setDefaultValues(); 
    } //end Constructor

    /**
     * Set Default Values. 
     */
    public void setDefaultValues(){ 
        correctWordsTotal = 0; 
        wordsPerMinute = 0; 
    } //end setDefaultValues

    /**
     * Calculate words per minute. 1.667 is based on the fact that it always takes about 36 seconds to complete level.
     */
    public void wordsPerMinute(){ 
        wordsPerMinute = (int) ( correctWordsTotal * 1.667 ); 
    } //end wordsPerMinute
} //end class 
