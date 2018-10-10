
 /***************************************************************************************
* Name:        GameTemplate
* Author:      Andy Zhang
* Date:        Oct 27, 2011
* Purpose:     Shows how to create an interactive, graphical application in Java using
               Dialog Boxes from JOptionPane for user input.
****************************************************************************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class WWTBAM extends JPanel {
    static Image pics[] = new Image[8];  // array of dancing number gifs
    static Image bgInstructions;
    static Image bgMenu;
    static Image bgWelcome;
    static Image bgImage1;              // image displayed while play occurs for part 1
    static Image bgImage2;              // image displayed while play occurs for part 2
    static Image winImage[] = new Image[6];  // image displayed when player wins
    static JPanel panel;                 // main drawing panel
    static JFrame frame;                 // window frame which contains the panel
    static final int WINDOW_WIDTH = 800; // width of display window
    static final int WINDOW_HEIGHT = 619;// height of display window

    static int gameStage = 0;            // stage of game
    static final int WELCOME_SCREEN = 0;
    static final int MENU = 1;
    static final int INSTRUCTIONS = 2;
    static final int PLAY = 3;
    static final int END_GAME = 4;

    static int playStage = 0;           // stage of actual play
    static final int PART_ONE = 0;
    static final int PART_TWO = 1;
    static final int WINNER = 2;

    static boolean inMenuMode = false;  // true when we are waiting for a user to make a specific choice
    static int numPlayers = 0;                     // number of players
    static double runningTotal = 0;                // runningTotal of game
    static int turn = 0;                           // current turn of game (0-9)

    static String playOutput = "";                 // output to panel after play
    static String playOutput2 = "";
    static String playOutputQuestion = "";
    static String playOutputChoice1 = "";
    static String playOutputChoice2 = "";
    static String playOutputChoice3 = "";
    static String playOutputChoice4 = "";



    static String [][] questionBank = null;
    static int question = 1;
    static String questionAnswer = "";
    static int questionNum = 0;
    static int points = 0;
    static int difficultyLevel = 1;
    static int totalMoney = 0;


    // start main program
    public static void main (String args[]) {
        // Create Image Object
        Toolkit tk = Toolkit.getDefaultToolkit();

        // Load background images
        bgInstructions = tk.getImage("instructions.jpg");
        bgWelcome = tk.getImage("wwtbam.png");
        bgMenu = tk.getImage("millionairemenu1.jpg");
        bgImage1 = tk.getImage("bg1.jpg");
        bgImage2 = tk.getImage("bg2.jpg");

        // Create Frame and Panel to display graphics in
  
        panel = new WWTBAM(); /*****MUST CALL THIS CLASS (ie same as filename) ****/
  
        panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));  // set size of application window
        frame = new JFrame ("Hello, this is a window");  // set title of window
        frame.add (panel);
  
        // add a key input listener (defined below) to our canvas so we can respond to key pressed
        frame.addKeyListener(new KeyInputHandler());

        // exits window if close button pressed
        frame.addWindowListener(new ExitListener());
  

        // request the focus so key events come to the frame
        frame.requestFocus();
        frame.pack();
        frame.setVisible(true);

    } // main


    public static void loadQuestionBank() {


        //load Question Bank
        try {
            int bankLength= 0;
            // input
            BufferedReader in = new BufferedReader(new FileReader("Questions.txt"));
            in.mark(Short.MAX_VALUE);  // see api

            // count number of lines in file
            while (in.readLine() != null) {
                bankLength++;
            }//while

            questionBank = new String[bankLength][9];

            in.reset(); // rewind the reader to the start of file

            // read in contents of file and print to screen
            // count number of lines in file

            for (int i = 0; i < questionBank.length; i++) {
                for (int j = 0; j < questionBank[i].length; j++) {
                    questionBank[i][j] = in.readLine();

                }//for
            }//for



            in.close();   //closes file
        } catch (Exception e) {
            System.out.println("ERROR WITH QUESTION BANK FILE");
        }//catch

        }

   /*
   * paintComponent gets called whenever panel.repaint() is
   * called or when frame.pack()/frame.show() is called. It paints
   * to the screen.  Since we want to paint different things
   * depending on what stage of the game we are in, a variable
   * "gamestage" will keep track of this.
   */
    public void paintComponent(Graphics g) {                  //displays the screen of the current stage of game
        super.paintComponent(g);   // calls the paintComponent method of JPanel to display the background

        // display welcome screen
        if (gameStage == WELCOME_SCREEN) {
            g.drawImage(bgWelcome, 0, 0, this);


            // top line of images
            for (int i=0; i < pics.length/2; i++) {
                g.drawImage(pics[2*i], i*194, 0, this);  // display the image
            } // for

            //g.setColor(Color.black);
            g.setColor(new Color(255,255,255));        //change color of font
            g.setFont(new Font("SansSerif", Font.BOLD, 36));   // set font
            g.drawString("Welcome to ", 320, 250);

            g.setFont(new Font("SansSerif", Font.BOLD, 36));   // set font
            //g.drawString("Who Wants to be a Millionaire",280,500);  // display

            // bottom line of images
            for (int i=0; i < pics.length/2 ; i++) {
                g.drawImage(pics[2*i+1], i*194, 400, this);  // display the image
            } // for
        // display game
        } else if (gameStage == MENU) {
            g.drawImage(bgMenu, 0, 0, this);


        // display instructions
        } else if (gameStage == INSTRUCTIONS) {
              g.drawImage(bgInstructions, 0, 0, this);

        // display one player game
        } else if (gameStage == PLAY) {

            // set font and colour
            g.setColor(Color.white);
            g.setFont(new Font("SansSerif", Font.BOLD, 16));

            // show stage one of play
            if (playStage == PART_ONE) {
                g.drawImage(bgImage1, 0, 0, this);
                g.drawString(playOutputQuestion, 50,100);
                g.drawString(playOutput,20,30);  // display
                g.drawString(playOutput2,20,550);
                g.drawString(playOutputChoice1, 50,150);
                g.drawString(playOutputChoice2, 300,150);
                g.drawString(playOutputChoice3, 50, 250);
                g.drawString(playOutputChoice4, 300,250);


              // show stage two of play
            /*} else if (playStage == PART_TWO) {
               g.drawImage(bgImage2, 0, 0, this);
               g.drawString("Part 2 " + playOutput,60,120);  // display */
               
              // show winner
            } else if (playStage == WINNER) {
                g.setColor(Color.blue);
                g.drawString(playOutput,60,120);
                for (int i=0; i < winImage.length; i++) {
                    g.drawImage(winImage[i], i*115, (int)(370+(Math.pow(-1,i)*30)), this);
                } // for
            } // ?
         } else {
             g.setColor(Color.blue);
             g.setFont(new Font("SansSerif", Font.BOLD, 36));   // set font
             g.drawString("Thanks for Playing!",280,300);  // display
          } // else
    } // paintComponent

    /* A class to handle keyboard input from the user.
    * Implemented as a inner class because it is not
    * needed outside the EvenAndOdd class.
    */
    private static class KeyInputHandler extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            // quit if the user presses "escape"
            if (e.getKeyChar() == 27) {
                System.exit(0);
            } else if (inMenuMode == true) {

            // respond to menu selection
                switch (e.getKeyChar()) {
                    case 50:  showInstructions(); break;             // Key "1" pressed
                    case 49:  numPlayers = 1; playGame();  break;    // Key "2" pressed
                    case 51:  numPlayers = 2; playGame(); break;     // Key "3" pressed
                    case 52:  System.exit(0);                        // Key "4" pressed
                } // switch

            } else if (gameStage == PLAY) {
                     switch (e.getKeyChar()) {
                     case 'A': checkAnswer("A");
                               checkAnswer("a");
                     case 'a': checkAnswer("a");
                               checkAnswer("A");
                               break;

                     case 'B': checkAnswer("B");
                               checkAnswer("b");
                     case 'b': checkAnswer("b");
                               checkAnswer("B");
                               break;

                     case 'C': checkAnswer("C");
                               checkAnswer("c");
                     case 'c': checkAnswer("c");
                               checkAnswer("C");
                               break;

                     case 'D': checkAnswer("D");
                               checkAnswer("d");
                     case 'd': checkAnswer("d");
                               checkAnswer("D");
                               break;
                     case 5: System.exit(0);
                             break;
                     }
            } else {
                showMenu();
            } // else
        } // keyTyped
    } // KeyInputHandler class


    /* Shuts program down when close button pressed */
    private static class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        } // windowClosing
    } // ExitListener

    // Pause the program for duration milliseconds
    private static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) { }
    } // pause

    private static void showMenu() {
        // display this stage of the game
        gameStage = MENU;
        playStage = PART_ONE;
        inMenuMode = true;
        panel.repaint();
    } // startGame

    private static void showInstructions() {
        gameStage = INSTRUCTIONS;
        inMenuMode = false;
        panel.repaint();
    } // startGame

    private static void playGame() {
        String playerOne = "";  // name of first player
        int x; // delete this variable, for example only
        int points = 0;     // delete this variable, for example only
        loadQuestionBank();


        // display this stage of game
        gameStage = PLAY;
        playStage = PART_ONE;
        inMenuMode = false;
        playOutput = "Question 1";

        panel.repaint();


        playerOne = JOptionPane.showInputDialog(panel, "Enter player one's name:");
        

        playOutput = "Question " + question;
        question++;
        getRandomQuestion();
        playOutputQuestion = questionBank[questionNum][2];
        playOutputChoice1 = questionBank[questionNum][3];
        playOutputChoice2 = questionBank[questionNum][4];
        playOutputChoice3 = questionBank[questionNum][5];
        playOutputChoice4 = questionBank[questionNum][6];
        playOutput = "Question 1";
        questionNum++;
        playOutput2 = playerOne + ", you have $" + totalMoney; 
        panel.repaint();

        /*while (true) {
        playOutput = "Question " + question;
        question++;
        getRandomQuestion();
        playOutputQuestion = questionBank[questionNum][2];
        //questionAnswer = displayQuestion(playerOne, questionNum);
        //checkAnswer(questionAnswer, questionNum);
        playOutput2 = playerOne + ", you have $" + totalMoney;
        panel.repaint();

        }

        playStage = WINNER;
        JOptionPane.showMessageDialog(panel, "You win with $" + totalMoney);
        panel.repaint();
        /*playStage = PART_TWO;
        playOutput = "This is where another part of the game could go";
        panel.repaint();
        JOptionPane.showMessageDialog(panel, "This is part two of the game");

        // pause the game for a moment
        pause(1000);

        playStage = WINNER;
        panel.repaint();
		*/
        // eventually someone wins
        
    } // playGame

	/**
	 * @param playerOne
	 * @return
	 */
	/**private static String displayQuestion(String playerOne, int questionNum) {
            playOutputQuestion = playerOne + ", " + questionBank[questionNum][2];
            playOutputChoice1 = questionBank[questionNum][3];
            playOutputChoice2 = questionBank[questionNum][4];
            playOutputChoice3 = questionBank[questionNum][5];
            playOutputChoice4 = questionBank[questionNum][6];
            

              return playOutput3;


            return JOptionPane.showInputDialog(panel, playerOne + ", " + questionBank[questionNum][2] + "\n" + questionBank[questionNum][3]
                                                      + "\n" + questionBank[questionNum][4] + "\n" + questionBank[questionNum][5] 
                                                      + "\n" + questionBank[questionNum][6]);

 }          **/


    /*public static boolean checkAnswer(String b, int questionNum) {
      if (b.equalsIgnoreCase(questionBank[questionNum][7])){
        difficultyLevel++;
        String winning = questionBank[questionNum][8];
        totalMoney = Integer.parseInt(winning);
        return true;
      } else if (b.equalsIgnoreCase("leave")) {
        System.exit(0);
        return false;
      } else {
         JOptionPane.showMessageDialog(panel, "You lose!");
         System.exit(0);
         return false;
      }
    } //checkAnswer */

    public static boolean checkAnswer (String userAns) {
        System.out.println("The correct answer is " + questionBank[questionNum][7] + ".");
        System.out.println("The users answer is " + userAns);
        if((questionBank[questionNum][7]).equalsIgnoreCase(userAns)) {
            difficultyLevel++;
            String winning = questionBank[questionNum][8];
            totalMoney = Integer.parseInt(winning);
            JOptionPane.showMessageDialog(panel, "You are correct!");
            return true;
        } else {
           JOptionPane.showMessageDialog(panel, "You lose!");
           System.exit(0);
           return false;
        }
        }//checkAnswer

     public static void getRandomQuestion() {
       //gets random question from file & answer
       Random rand = new Random();
       int min = -1;
       int max = -1;

       if (difficultyLevel == 1){     //(q 1-4)
           min = 0;
           max = 3;
       }//if

       if (difficultyLevel == 2){     //(q 5-8)
           min = 4;
           max = 7;
       }//if

        if (difficultyLevel == 3){     //(q 9-12)
           min = 8;
           max = 11;
       }//if
       
        if (difficultyLevel == 4){     //(q 13-16)
           min = 12;
           max = 15;
       }//if
       
        if (difficultyLevel == 5){     //(q 17-20)
           min = 16;
           max = 19;
       }//if
       
        if (difficultyLevel == 6){     //(q 21-24)
           min = 20;
           max = 23;
       }//if
       
        if (difficultyLevel == 7) {     //(q 25-28)
           min = 24;
           max = 27;
       }//if
       
        if (difficultyLevel == 8){     //(q 29-32)
           min = 28;
           max = 31;
       }//if
       
        if (difficultyLevel == 9){     //(q 33-36)
           min = 32;
           max = 35;
       }//if
       
        if (difficultyLevel == 10){     //(q 37-40)
           min = 36;
           max = 39;
       }//if
       
        if (difficultyLevel == 11){     //(q 41-44)
           min = 40;
           max = 43;
       }//if

        if (difficultyLevel == 12){     //(q 45-48)
           min = 44;
           max = 47;
       }//if
       
        if (difficultyLevel == 13){     //(q 49-52)
           min = 48;
           max = 51;
       }//if
       
        if (difficultyLevel == 14){     //(q 53-56)
           min = 52;
           max = 55;
       }//if

        if (difficultyLevel == 15){     //(q 57-60)
           min = 56;
           max = 59;
       }//if
       int randomNum = rand.nextInt((max - min) + 1) + min;

       questionNum = randomNum;

       System.out.println(questionNum);

    }//getRandomQuestion

} // Even and Odd

