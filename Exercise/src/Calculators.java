import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculators extends JFrame implements ActionListener {
    // Components of the Calculator
    private JTextField firstNumber, secondNumber, result;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;
    private JButton button1;

    // Constructor
    public Calculators() {
        // Create the frame
        setTitle("Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        getContentPane().add(panel);

        // First number field
        panel.add(new JLabel("First Number:"));
        firstNumber = new JTextField();
        panel.add(firstNumber);


        panel.add(new JLabel("Second Number:"));
        secondNumber = new JTextField();
        panel.add(secondNumber);


        panel.add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        panel.add(result);


        addButton = new JButton("+");
        addButton.addActionListener(this);
        panel.add(addButton);


        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        panel.add(subtractButton);


        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        panel.add(multiplyButton);


        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        panel.add(divideButton);

        // Modulus button
        modulusButton = new JButton("%");
        modulusButton.addActionListener(this);
        panel.add(modulusButton);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        panel.add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumber.getText());
            double num2 = Double.parseDouble(secondNumber.getText());
            double res = 0.0;

            if (e.getSource() == addButton) {
                res = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                res = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                res = num1 * num2;
            } else if (e.getSource() == divideButton) {
                res = num1 / num2;
            } else if (e.getSource() == modulusButton) {
                res = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                return;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }
}