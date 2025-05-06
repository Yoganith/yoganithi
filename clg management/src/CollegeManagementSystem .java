//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CollegeManagementSystem extends JFrame implements ActionListener {

    private JTextField nameField, rollField, dobField, phoneField, branchField, bloodGroupField;
    private JTextArea displayArea;
    private JButton addButton, viewButton, exitButton;

    private ArrayList<Student> students = new ArrayList<>();

    public CollegeManagementSystem() {
        setTitle("College Management System");
        setSize(700, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel with dark background
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(34, 40, 49));

        // Title
        JLabel titleLabel = new JLabel("College Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(57, 62, 70));
        titleLabel.setForeground(new Color(0, 173, 181));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Input panel with styled border
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(44, 52, 62));
        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 173, 181)),
                "Student Information",
                0, 0, new Font("Segoe UI", Font.BOLD, 16),
                new Color(0, 173, 181)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int y = 0;

        nameField = createInputRow(inputPanel, "Name:", y++);
        rollField = createInputRow(inputPanel, "Roll No:", y++);
        dobField = createInputRow(inputPanel, "Date of Birth (dd-mm-yyyy):", y++);
        phoneField = createInputRow(inputPanel, "Phone No:", y++);
        branchField = createInputRow(inputPanel, "Branch:", y++);
        bloodGroupField = createInputRow(inputPanel, "Blood Group:", y++);

        // Buttons
        addButton = createStyledButton("Add Student", new Color(0, 173, 181));
        viewButton = createStyledButton("View Students", new Color(255, 193, 7));
        exitButton = createStyledButton("Exit", new Color(244, 67, 54));

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        exitButton.addActionListener(e -> System.exit(0));

        gbc.gridy = y;
        gbc.gridx = 0;
        inputPanel.add(addButton, gbc);
        gbc.gridx = 1;
        inputPanel.add(viewButton, gbc);
        gbc.gridx = 2;
        inputPanel.add(exitButton, gbc);

        // Display area
        displayArea = new JTextArea();
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setBackground(new Color(57, 62, 70));
        displayArea.setForeground(Color.WHITE);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 173, 181)),
                "Student Records",
                0, 0, new Font("Segoe UI", Font.BOLD, 14),
                new Color(0, 173, 181)
        ));

        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add to frame
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextField createInputRow(JPanel panel, String label, int yPos) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
