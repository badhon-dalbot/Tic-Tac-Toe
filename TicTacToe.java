
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Font.ITALIC;

public class TicTacToe implements ActionListener {
    Frame gameFrame = new Frame("Tic Tac Toe");
    Panel textPanel = new Panel();
    Panel boardPanel = new Panel();
    Button buttons[] = new Button[9];
    Label textField = new Label();
    Random random = new Random();
    boolean player1Turn;
    int count =0;

    public TicTacToe(){
        textField.setBounds(200, 20, 400, 100);
        textField.setText("Tic Tac Toe");
        textField.setFont(new Font("Times New Roman", Font.BOLD | ITALIC, 30));
        textField.setAlignment(Label.CENTER);


        textPanel.setBounds(100, 0, 600, 100);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textField, BorderLayout.CENTER);
        textPanel.setBackground(Color.blue);
        textPanel.setForeground(Color.white);

        boardPanel.setBounds(100, 120, 600, 600);
        boardPanel.setLayout(new GridLayout(3, 3));
        for(int i=0; i<9; i++){
            buttons[i] = new Button("");
            boardPanel.add(buttons[i]);
            buttons[i].setForeground(Color.blue);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD | ITALIC, 40));
            buttons[i].addActionListener(this);
        }

        gameFrame.add(textPanel, BorderLayout.SOUTH);
        gameFrame.add(boardPanel, BorderLayout.CENTER);
        gameFrame.setLocation(400, 200);
        gameFrame.setSize(800, 800);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setVisible(true);
        xTurn();
    }
    public void xTurn(){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2) == 0){
            player1Turn = true;
            textField.setText("X turn");
        }
        else {
            player1Turn = false;
            textField.setText(" O turn");
        }
    }
    public void check(){
        if((buttons[0].getLabel() == "X") && (buttons[1].getLabel() == "X") && (buttons[2].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[3].getLabel() == "X") && (buttons[4].getLabel() == "X") && (buttons[5].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[6].getLabel() == "X") && (buttons[7].getLabel() == "X") && (buttons[8].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[0].getLabel() == "X") && (buttons[4].getLabel() == "X") && (buttons[8].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[1].getLabel() == "X") && (buttons[4].getLabel() == "X") && (buttons[7].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[2].getLabel() == "X") && (buttons[5].getLabel() == "X") && (buttons[8].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }
        else if((buttons[2].getLabel() == "X") && (buttons[4].getLabel() == "X") && (buttons[6].getLabel()=="X")){
            textField.setText("X wins");
            endGame();
        }

        else if((buttons[0].getLabel() == "O") && (buttons[1].getLabel() == "O") && (buttons[2].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if((buttons[3].getLabel() == "O") && (buttons[4].getLabel() == "O") && (buttons[5].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if((buttons[6].getLabel() == "O") && (buttons[7].getLabel() == "O") && (buttons[8].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if((buttons[0].getLabel() == "O") && (buttons[4].getLabel() == "O") && (buttons[8].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if((buttons[1].getLabel() == "O") && (buttons[4].getLabel() == "O") && (buttons[7].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if((buttons[2].getLabel() == "O") && (buttons[5].getLabel() == "O") && (buttons[8].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
         else if((buttons[2].getLabel() == "O") && (buttons[4].getLabel() == "O") && (buttons[6].getLabel()=="O")){
            textField.setText("O wins");
            endGame();
        }
        else if(count == 9){
            textField.setText("Draw");
            endGame();
        }
    }
    public void endGame(){
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<9; i++){
            if(e.getSource() == buttons[i]){
               if(player1Turn){
                   if(buttons[i].getLabel() == ""){
                       buttons[i].setLabel("X");
                       buttons[i].setBackground(Color.green);
                       player1Turn = false;

                       count++;
                       check();
                   }
               }
               else {
                   if(buttons[i].getLabel() == ""){
                       buttons[i].setLabel("O");
                       buttons[i].setBackground(Color.orange);
                       player1Turn = true;
                       textField.setText("X turn");
                       count++;
                       check();
                   }
               }
           }
        }

    }
    public static void main(String [] args){
        new TicTacToe();
    }


}
