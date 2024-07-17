import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class CustomerViewer extends JFrame {
    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JButton prevButton, nextButton;
    private List<Customer> customers;
    private int currentIndex = 0;

    public CustomerViewer(List<Customer> customers) {
        this.customers = customers;
        createView();
        setTitle("Customer Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        getContentPane().add(panel);

        panel.add(new JLabel("ID:"));
        idLabel = new JLabel();
        panel.add(idLabel);

        panel.add(new JLabel("Last Name:"));
        lastNameLabel = new JLabel();
        panel.add(lastNameLabel);

        panel.add(new JLabel("First Name:"));
        firstNameLabel = new JLabel();
        panel.add(firstNameLabel);

        panel.add(new JLabel("Phone:"));
        phoneLabel = new JLabel();
        panel.add(phoneLabel);

        prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateView();
                }
            }
        });
        panel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.size() - 1) {
                    currentIndex++;
                    updateView();
                }
            }
        });
        panel.add(nextButton);

        updateView();
    }

    private void updateView() {
        Customer customer = customers.get(currentIndex);
        idLabel.setText(String.valueOf(customer.getId()));
        lastNameLabel.setText(customer.getLastName());
        firstNameLabel.setText(customer.getFirstName());
        phoneLabel.setText(customer.getPhone());
    }
}