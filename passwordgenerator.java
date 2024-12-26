import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class passwordgenerator extends JFrame {
    passwordgenerator()
    {
        super("Password Generator");
        setSize(800,570);
        //prevent GUI from being resized 
        setResizable(false);
        //we will set layout to null to have control over the position and size of our components in our app
        setLayout(null);
        //terminate the porgram when GUI is closed 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //center the GUI to Screen
        setLocationRelativeTo(null);
        addComponents();
    }
    private void addComponents() {
        // Create title text
        JLabel titleLabel = new JLabel("Password Generator");
        // Increase the font size and make it bold
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        // Center the text to screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Set x, y coordinates and width and height values
        titleLabel.setBounds(200, 10, 400, 50);
        // Add to the GUI
        add(titleLabel);

        // Create a result text area
        JTextArea output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Dialog", Font.BOLD, 32));
        JScrollPane outputpane = new JScrollPane(output);
        outputpane.setBounds(25, 80, 750, 50);
        outputpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(outputpane);

        // Create password length label
        JLabel password_length = new JLabel("Password length:");
        password_length.setFont(new Font("Dialog", Font.PLAIN, 24));
        password_length.setBounds(25, 160, 200, 30);
        add(password_length);

        // Create password length input area
        JTextArea password_lengthArea = new JTextArea();
        password_lengthArea.setFont(new Font("Dialog", Font.PLAIN, 24));
        password_lengthArea.setBounds(230, 160, 100, 30);
        add(password_lengthArea);

        // Create toggle buttons
           // Uppercase letter toggle button
           JToggleButton uppercase = new JToggleButton("Uppercase");
           uppercase.setBounds(25, 220, 150, 40);
           add(uppercase);
   
           // Lowercase letter toggle button
           JToggleButton lowercase = new JToggleButton("Lowercase");
           lowercase.setBounds(200, 220, 150, 40);
           add(lowercase);
   
           // Numbers Button
           JToggleButton numbers = new JToggleButton("Numbers");
           numbers.setBounds(375, 220, 150, 40);
           add(numbers);
   
           // Symbols Button
           JToggleButton symbols = new JToggleButton("Symbols");
           symbols.setBounds(550, 220, 150, 40);
           add(symbols);
           //Generate Button
           JButton generate=new JButton("Generate");
           generate.setBounds(250,300,150,40);
           generate.addActionListener(new ActionListener() {
//This method is fixed for new ActionListener()
            public void actionPerformed(ActionEvent e) {
                // Generate password if length > 0 and any toggle button is enabled
                if (password_lengthArea.getText().length() <= 0)
                    return;
        
                boolean anyButtonSelected = uppercase.isSelected() || lowercase.isSelected() || numbers.isSelected() || symbols.isSelected();
                if (!anyButtonSelected)
                    return;
        
                passwordlogic pwl = new passwordlogic();
                int passwordLength = Integer.parseInt(password_lengthArea.getText());
                String res = pwl.generatepassword(passwordLength, uppercase.isSelected(), lowercase.isSelected(), numbers.isSelected(), symbols.isSelected());
                output.setText(res); // Assuming you want to display the result in the output text area
            }
        });
        
           add(generate);
    }

    
}
