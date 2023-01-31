## How to Execute Code/Game:

1. Firstly please install the library json-simple.jar, it can be any version but use the one provided.
2. Install an IDE preferably IntelliJ and open the project in the IDE.
3. Go to the Main.java class file and run the code from there. Using IntelliJ IDE use the green play button to execute
   the game this will be mostly similar in all IDE's.

### Or

1. Install JDK
2. Open a command prompt window and go to the directory where you saved the java program (WovenMonopoly.java). Assume
   it's C:\.
3. Type 'javac WovenMonopoly.java' and press enter to compile your code. If there are no errors in your code, the
   command prompt will take you to the next line (Assumption: The path variable is set).
4. Now, type ' java WovenMonopoly ' to run your program.

## Questions Answered:

* Who would win each game?
    - Using the Rolls 1 or Rolls 2 dice files each time Peter is the winner.
* How much money does everybody end up with?
    - Using the Rolls 1 file Peter ends with $48, Billy ends with $6, Charlotte ends with $-3 and Sweedal ends with $2.
    - Using the Rolls 2 file Peter ends with $4, Bill ends with $31, Charlotte ends with $18 and Sweedal ends with $-1.
* What spaces does everybody finish on?
    - Using the Rolls 1 file Peter finishes on position 4, Billy finishes on position 4 , Charlotte finishes on position
      1 and Sweedal finishes on position 2.
    - Using the Rolls 2 file Peter finishes on position 2, Billy finishes on position 5 , Charlotte finishes on position
      4 and Sweedal finishes on position 4.

## Rules and Instructions:

## Woven coding test

Your task is to write an application to play the game of Woven Monopoly.

In Woven Monopoly, when the dice rolls are set ahead of time, the game is deterministic.

### Game rules

* There are four players who take turns in the following order:
    * Peter
    * Billy
    * Charlotte
    * Sweedal
* Each player starts with $16
* Everybody starts on GO
* You get $1 when you pass GO (this excludes your starting move)
* If you land on a property, you must buy it
* If you land on an owned property, you must pay rent to the owner
* If the same owner owns all property of the same colour, the rent is doubled
* Once someone is bankrupt, whoever has the most money remaining is the winner
* There are no chance cards, jail or stations
* The board wraps around (i.e. you get to the last space, the next space is the first space)

### Your task

* Load in the board from board.json
* Implement game logic as per the rules
* Load in the given dice rolls files and simulate the game
    * Who would win each game?
    * How much money does everybody end up with?
    * What spaces does everybody finish on?

The specifics and implementation of this code is completely up to you!

### What we are looking for:

* We are a Ruby house, however feel free to pick the language you feel you are strongest in.
* Code that is well thought out and tested
* Clean and readable code
* Extensibility should be considered
* A git commit-history would be preferred, with small changes committed often so we can see your approach

Please include a readme with any additional information you would like to include, including instructions on how to test
and execute your code. You may wish to use it to explain any design decisions.

Despite this being a small command line app, please approach this as you would a production problem using whatever
approach to coding and testing you feel appropriate.
