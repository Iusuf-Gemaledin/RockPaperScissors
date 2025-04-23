// Front-end

package Projects.RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGUI extends JFrame implements ActionListener {
    //creates the Player's buttons
    JButton rockButton, paperButton, scissorsButton;

    //displays the choice of the computer
    JLabel computerChoice;

    //displays the score of the Computer and of the Player
    JLabel computerScoreLabel, playerScoreLabel;

    //creates the Back-end object
    RockPaperScissors rockPaperScissors;
    
    public RockPaperScissorsGUI () {
        // Invoke JFrame constructor and add title to the GUI
        super ("Rock, Paper, Scissors!");

        // Set the size of the frame created
        setSize (450, 574);
        setLayout (null);               //disables layout management, allowing for absolute positioning of the elements.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo (null);         //loads the GUI in the center of the screen every time the application is open.

        //initializes the Back-end object
        rockPaperScissors = new RockPaperScissors();

        addGuiComponents ();
    }

    private void addGuiComponents () {
        //creates the Computer's score label and edits it's properties
        computerScoreLabel = new JLabel ("Computer: 0");
        computerScoreLabel.setBounds (0, 43, 450, 30);
        computerScoreLabel.setFont (new Font ("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add (computerScoreLabel);

        //creates the Computer's choice
        computerChoice = new JLabel ("?");
        computerChoice.setBounds (175, 118, 98, 81);
        computerChoice.setFont (new Font ("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //creates a black border around
        computerChoice.setBorder (BorderFactory.createLineBorder(Color.BLACK));
        add (computerChoice);

        //creates the Player's score label
        playerScoreLabel = new JLabel ("Player: 0");
        playerScoreLabel.setBounds (0, 317, 450, 30);
        playerScoreLabel.setFont (new Font ("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add (playerScoreLabel);



        //creates the Player's buttons

        //creates the Rock button
        rockButton = new JButton ("Rock");
        rockButton.setBounds (40, 387, 105, 81);
        rockButton.setFont (new Font ("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener (this);
        add (rockButton);

        //creates the Paper button
        paperButton = new JButton ("Paper");
        paperButton.setBounds (165, 387, 105, 81);
        paperButton.setFont (new Font ("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener (this);
        add (paperButton);

        //creates the Scissors
        scissorsButton = new JButton ("Scissors");
        scissorsButton.setBounds (290, 387, 105, 81);
        scissorsButton.setFont (new Font ("Dialog", Font.PLAIN, 18));
        scissorsButton.addActionListener (this);
        add (scissorsButton);
    }

    //displays the winner and asks for another round
    private void showDialog (String message) {
        JDialog resultDialog = new JDialog (this, "Result", true);
        resultDialog.setSize (227, 124);
        resultDialog.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        resultDialog.setResizable (false);

        //message label
        JLabel resultLabel = new JLabel (message);
        resultLabel.setFont (new Font ("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment (SwingConstants.CENTER);
        resultDialog.add (resultLabel, BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton ("Try Again?");
        tryAgainButton.addActionListener (new ActionListener() {
            @Override

            public void actionPerformed (ActionEvent e) {
                //resets computer choice
                computerChoice.setText ("?");

                //close the dialog box
                resultDialog.dispose ();
            }
        });

        resultDialog.add (tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo (this);
        resultDialog.setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        //gets the Player's choice
        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissors.playRockPaperScissors(playerChoice);
        computerChoice.setText (rockPaperScissors.getComputerChoice());

        //updates the score
        computerScoreLabel.setText ("Computer: " + rockPaperScissors.getComputerScore());
        playerScoreLabel.setText ("Player: " + rockPaperScissors.getPlayerScore());

        //displays result dialog
        showDialog(result);
    }
}
