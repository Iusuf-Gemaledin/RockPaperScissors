package Projects.RockPaperScissors;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run () {
                RockPaperScissorsGUI RockPaperScissorGUI = new RockPaperScissorsGUI();    //instantiates a RockPaperScissorGUI object
                RockPaperScissorGUI.setVisible (true);
            }
        });
    }
}
