# Ctrl-Alt-Defeat

## Demo 1 Release 
In Demo 1 we have the building blocks for which our whole game will be based on. Our character has the ability to 
move independently of the world which allows him to speed up, slow down and jump (based on user input). Our world 
also moves in the background to simulate the character running through it. Next, we have a "monster" that is chasing 
our character. This monster only has animation for now but with the use of collision detection will be able to  end 
the game if its run into.

Our text stream also is able to pull words randomly from a text file without repeats. These words are displayed above 
the character and also can move independently of the world so we can control the speed of them independently. This 
will allow us to increase the difficulty by speeding up the words. Lastly, these words can change color with user input. 
This will allow us to eventually make a letter turn green when correctly typed and red when incorrectly typed. 

## Demo 2 Release
In Demo 2 we have added functionality that turns the building blocks made in previous releases into an actual functioning game. 
The game now finishes when the character runs into the monster. Also, A finish line has been added so that if the user stays 
alive for long enough than they can "win". Win the user wins the game ends and displays how fast they were typing in wpm. 

We now also have a start menu for this game. In this start menu you can select "play" which will then prompt you to choose a 
difficulty level. The options are easy, medium, and hard. Depending on which one the user selects will determine which word
bank the game pulls from. Easy is 2-3 letter words. Medium 4-5. and Hard 7-8. Later on there will be more differences added
such as longer maps and faster speeds. 

Lastly, the way the words are displayed has changed. Three words are present at all times. The one on the left is the word that 
was most recently tyoed. If the word was typed correct than this word will appear green and the characters speed will increase, 
incorrect it will appear red and the character will decrease in speed. The word in the middle always appears black and is the 
word that the user must currently type. Lastly the word on the right is the next word that the user will have to type and it appears 
grey. The user iterates through these words by hitting space after they are done typing. The user can also see what they typed below 
the middle word. This allows the user to verify that they are typing the correct word and use the backspace to make any needed changes. 

Finally, we have added a build file for our project that allows for easy compiling and testing of our game. 

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat">Github Page</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/requirements.html">Requirements</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/userstories.html">User Stories</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/design.html">Design</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/architecture.html">Architecture</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/problem.html">Problem</a>

<a href="https://benjweber.github.io/Ctrl-Alt-Defeat/testreport.html">Test Report</a>


