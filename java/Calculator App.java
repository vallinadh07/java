import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    JTextField inputField;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.BOLD, 24));
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        // Buttons
        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+",
            "C"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 22));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = ((JButton)e.getSource()).getText();

        if (input.matches("[0-9.]")) {
            inputField.setText(inputField.getText() + input);
        } else if (input.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = input.charAt(0);
            inputField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(inputField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 != 0) result = num1 / num2;
                    else {
                        inputField.setText("Error: /0");
                        return;
                    }
                    break;
            }

            inputField.setText(String.valueOf(result));
        } else if (input.equals("C")) {
            inputField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
