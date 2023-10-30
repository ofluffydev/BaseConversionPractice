package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.topics.BaseConversion;

public class MainGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UIL CS Study Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create a panel to hold the components
        JPanel panel = new JPanel(null);

        // Create text input
        JTextField textInput = new JTextField(20);
        textInput.setBounds(150, 200, 200, 30);

        // Get the question from
        String question = BaseConversion.askQuestion();
        String[] answer = { BaseConversion.currentAnswer }; // make answer an array to make it effectively final

        // Text in center with question using JLabel
        JLabel displayQuestion = new JLabel(question);
        displayQuestion.setBounds(150, 100, 200, 30);

        // Add the text input and the question to the panel
        panel.add(displayQuestion);
        panel.add(textInput);

        // Add a button to submit the answer
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 250, 100, 30);
        panel.add(submitButton);

        // Add a next button to go to the next question
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(250, 250, 100, 30);
        panel.add(nextButton);

        // Add a label to display whether the submitted answer is correct or not
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(150, 300, 200, 30);
        panel.add(resultLabel);

        // Add a label to display the response to the submitted answer
        JLabel responseLabel = new JLabel("");
        responseLabel.setBounds(150, 350, 200, 30);
        panel.add(responseLabel);

        // On submit button click check answer
        submitButton.addActionListener(e -> {
            // Get the text from the text input
            String text = textInput.getText();
            // Check if the answer is correct
            if (text.equals(answer[0])) {
                // If it is correct then say correct
                resultLabel.setText("Correct!");
                responseLabel.setText("Great job!");
            } else {
                // If it is incorrect then say incorrect
                resultLabel.setText("Incorrect. The answer is " + answer[0] + ".");
                responseLabel.setText("Better luck next time!");
            }
        });

        // On next button press get a new question
        nextButton.addActionListener(e -> {
            // Get the question from
            String newQuestion = BaseConversion.askQuestion();
            answer[0] = BaseConversion.currentAnswer; // update answer variable
            // Set the new question
            displayQuestion.setText(newQuestion);
            // Clear the result and response labels
            resultLabel.setText("");
            responseLabel.setText("");
        });

        // Add the panel to the frame
        frame.add(panel);

        // Set visible last
        frame.setVisible(true);
    }
}
