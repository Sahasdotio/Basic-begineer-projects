import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    char operator;

    Calculator() {
        // Frame title
        setTitle("Basic Calculator");
        setSize(350, 450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Text Field
        textField = new JTextField();
        textField.setBounds(30, 40, 280, 30);
        add(textField);

        // Number Buttons
        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, y, 60, 40);
            add(button);
            button.addActionListener(this);
            x += 70;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 50;
            }
        }

        // Clear Button
        JButton clearButton = new JButton("C");
        clearButton.setBounds(30, 300, 280, 40);
        add(clearButton);
        clearButton.addActionListener(e -> textField.setText(""));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Double.parseDouble(textField.getText());
                operator = command.charAt(0);
                textField.setText("");
                break;
            case "=":
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': result = num1 / num2; break;
                }
                textField.setText("" + result);
                break;
            default:
                textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
