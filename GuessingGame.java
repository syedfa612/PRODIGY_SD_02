import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGame {
    private JFrame frame;
    private JTextField guessField;
    private JLabel resultLabel;
    private int numberToGuess;
    private int attempts = 0;

    public GuessingGame() {
        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel guessLabel = new JLabel("Guess a number between 1 and 20:");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        frame.add(guessLabel);
        frame.add(guessField);
        frame.add(guessButton);
        frame.add(resultLabel);

        numberToGuess = new Random().nextInt(20) + 1;

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessField.getText());
                attempts++;
                if (guess < numberToGuess) {
                    resultLabel.setText("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    resultLabel.setText("Too high! Try again.");
                } else {
                    resultLabel.setText(" Congratulations! You won in " + attempts + " attempts.");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}