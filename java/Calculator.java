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

        if (input.matches("[0-]()

