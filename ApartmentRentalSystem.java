package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApartmentRentalSystem extends JFrame {
    private JTextField apartmentNameField;
    private JTextField rentField;
    private JTextArea outputArea;

    public ApartmentRentalSystem() {
        setTitle("Apartment Rental System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input fields
        apartmentNameField = new JTextField(15);
        rentField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        outputArea = new JTextArea(20, 30);
        outputArea.setEditable(false);

        // Adding components to the frame
        add(new JLabel("Apartment Name:"));
        add(apartmentNameField);
        add(new JLabel("Rent:"));
        add(rentField);
        add(submitButton);
        add(new JScrollPane(outputArea));

        // Button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String apartmentName = apartmentNameField.getText();
                String rent = rentField.getText();
                addApartment(apartmentName, rent);
            }
        });
    }

    private void addApartment(String name, String rent) {
        if (name.isEmpty() || rent.isEmpty()) {
            outputArea.append("Please fill in all fields.\n");
            return;
        }
        outputArea.append("Apartment Added: " + name + " with Rent: $" + rent + "\n");
        apartmentNameField.setText("");
        rentField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ApartmentRentalSystem frame = new ApartmentRentalSystem();
            frame.setVisible(true);
        });
    }
}