import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//tic tac toe class
// we are using implements because this class will listen to actions

public class TicTacToe implements ActionListener{

    //JFrame creates window
    JFrame window = new JFrame("Tic-Tac-Toe");
    //window.setSize(100,100);
    //creating 4 panels 
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel = new JPanel();
    JPanel scorePanel = new JPanel();


    //Labels
    JLabel textField = new JLabel("Tic");
    JLabel scoreLabelPlayerX = new JLabel();
    JLabel scoreLabelPlayerO = new JLabel();

    // buttons
    JButton[] buttons = new JButton[9];
    JButton relaodButton = new JButton("Reload");
    JButton closeButton = new JButton("Close");

    //score of both the players
    int playerXScore = 0;
    int playerOScore = 0;

    //to determine which players turn it is 
    boolean playerXTurn = false;
    boolean playerOTurn = false;

    //constructor
    public TicTacToe(){
        //setting Window size,background,layout,visibility
        window.setSize(1000,800);
        window.getContentPane().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //setting textField properties
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        //setting title-Panel properties
        titlePanel.setLayout(new BorderLayout());
        //titlePanel.setBounds(0,0,0,0);
        titlePanel.add(textField);

        //buttonPanel properties
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        for(int i = 0 ; i < 9;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //for reload panel
        reloadPanel.setLayout(new GridLayout(1,2));
        reloadPanel.setBackground(new Color(150,150,150));
        //reload and close button properties
        relaodButton.setBackground(new Color(0,0,255));
        relaodButton.setFocusable(false);
        relaodButton.addActionListener(this);

        closeButton.setBackground(new Color(255,0,0));
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        //addomg close and reload button to panel
        reloadPanel.add(relaodButton);
        reloadPanel.add(closeButton);

        //scorepanel
        scorePanel.setLayout(new GridLayout(2,1));
        scorePanel.setBackground(new Color(255,255,0));

        scoreLabelPlayerX.setFont(new Font("MV Boli",Font.BOLD,20));
        scoreLabelPlayerX.setText("Player X " + playerXScore);
        scoreLabelPlayerO.setFont(new Font("MV Boli",Font.BOLD,20));
        scoreLabelPlayerO.setText("Player O : " + playerOScore);

        scorePanel.add(scoreLabelPlayerX);
        scorePanel.add(scoreLabelPlayerO);

        //adding all panels to the frame
        window.add(titlePanel,BorderLayout.NORTH);
        window.add(buttonPanel);
        window.add(reloadPanel,BorderLayout.SOUTH);
        window.add(scorePanel,BorderLayout.EAST);

        //starting the game by making player 1 to start the game
        firstTurn();

    }

    public void reload(){

        
        for(int i = 0 ; i < 9 ; i++){
            buttons[i].setText("");
            buttons[i].setBackground(new JButton().getBackground());
        }

        //starting the game again
        firstTurn();

    }

    public void xWins(int x, int y , int z){

        buttons[x].setBackground(Color.green);
        buttons[x].setForeground(Color.BLACK);
        buttons[y].setBackground(Color.green);
        buttons[y].setForeground(Color.BLACK);
        buttons[z].setBackground(Color.green);
        buttons[z].setForeground(Color.BLACK);
        textField.setText("X Wins");
        playerXScore++;
        
        scoreLabelPlayerX.setFont(new Font("MV Boli",Font.BOLD,20));
        scoreLabelPlayerX.setText("Player X " + playerXScore);

    }

    public void OWins(int x , int y , int z){

        buttons[x].setBackground(Color.green);
        buttons[x].setForeground(Color.BLACK);
        buttons[y].setBackground(Color.green);
        buttons[y].setForeground(Color.BLACK);
        buttons[z].setBackground(Color.green);
        buttons[z].setForeground(Color.BLACK);
        textField.setText("O Wins");
        playerOScore++;
        
        scoreLabelPlayerO.setFont(new Font("MV Boli",Font.BOLD,20));
        scoreLabelPlayerO.setText("Player O " + playerOScore);

    }

    public void firstTurn(){

        try {

            Thread.sleep(1500);
            
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //randomly giving first chance to either one of the player
        if(Math.random() < 0.5){
            //player x turn
            playerXTurn = true;
            textField.setText("Player X turn");

        }else{
            //player y turn
            playerXTurn = false;
            textField.setText("Player O turn");

        }
        
    }

    public void check(){

        //horizontal conditions
        for(int i = 0 ; i < 3;i++){

           if(
            buttons[3*i].getText() == "X" &&
            buttons[3*i + 1].getText() == "X" &&
            buttons[3*i + 2].getText() == "X"
           ){
            
            xWins(3*i,3*i + 1 , 3*i + 2);

           }

        }

        //vertical conditions

        for(int i = 0 ; i < 3 ; i++){

            if(
                buttons[i].getText() == "X" &&
                buttons[3 + i].getText() == "X" &&
                buttons[6 + i].getText() == "X" 
            ){
                xWins(i , 3 + i , 6 + i);
            }

        }

        //diagonal Conditions
        if(
                buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "X" 
            ){
                xWins(0 , 4 , 8);
            }

            if(
                buttons[2].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[6].getText() == "X" 
            ){
                xWins(2 ,4 , 6 );
            }

            //FOR Player O 

             //horizontal conditions
        for(int i = 0 ; i < 3;i++){

            if(
             buttons[3*i].getText() == "O" &&
             buttons[3*i + 1].getText() == "O"  &&
             buttons[3*i + 2].getText() == "O" 
            ){
             
             OWins(3*i,3*i + 1 , 3*i + 2);
 
            }
 
         }
 
         //vertical conditions
 
         for(int i = 0 ; i < 3 ; i++){
 
             if(
                 buttons[i].getText() == "O"  &&
                 buttons[3 + i].getText() == "O"  &&
                 buttons[6 + i].getText() == "O"  
             ){
                 OWins(i , 3 + i , 6 + i);
             }
 
         }
 
         //diagonal Conditions
         if(
                 buttons[0].getText() == "O"  &&
                 buttons[4].getText() == "O"  &&
                 buttons[8].getText() == "O" 
             ){
                 OWins(0 , 4 , 8);
             }
 
             if(
                 buttons[2].getText() == "O"  &&
                 buttons[4].getText() == "O"  &&
                 buttons[6].getText() == "O"  
             ){
                 OWins(2 ,4 , 6 );
             }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //checking if clicked button is one of the 9 buttons or not
        for(int i = 0 ; i < 9;i++){
            if(e.getSource() == buttons[i]){

                if(playerXTurn){
                    
                    //if the clicked box was empty
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("X");
                        playerXTurn = false;
                        textField.setText("O Turn");
                        textField.setForeground(new Color(0,0,255));
                        
                        //to check if a player has won or not 
                        check();
                    }

                }else{
                    
                    if(buttons[i].getText() == ""){
                            buttons[i].setForeground(Color.BLUE);
                            buttons[i].setText("O");
                            playerXTurn = true;
                            textField.setText("X Turn");
                            textField.setForeground(Color.GREEN);

                            //to check if a player has won or not
                            check();
                    }

                }

            }
        }

        //check if the source is close button or reload button

        if(e.getSource() == relaodButton){
            reload();
        }

        if(e.getSource() == closeButton){
            window.dispose();
            //window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
    }






}