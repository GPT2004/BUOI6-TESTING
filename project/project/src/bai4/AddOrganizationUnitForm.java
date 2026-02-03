package bai4;

import javax.swing.*;
import java.awt.*;

public class AddOrganizationUnitForm extends JFrame {

    private JTextField txtUnitId;
    private JTextField txtName;
    private JTextArea txtDescription;
    private JLabel lblStatus;

    private final AddOrganizationUnitService service = new AddOrganizationUnitService();

    public AddOrganizationUnitForm() {
        setTitle("Add Organization Unit");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Unit Id
        c.gridx = 0; c.gridy = 0;
        form.add(new JLabel("Unit Id"), c);
        c.gridx = 1;
        txtUnitId = new JTextField();
        form.add(txtUnitId, c);

        // Name*
        c.gridx = 0; c.gridy = 1;
        form.add(new JLabel("Name*"), c);
        c.gridx = 1;
        txtName = new JTextField();
        form.add(txtName, c);

        // Description
        c.gridx = 0; c.gridy = 2;
        form.add(new JLabel("Description"), c);
        c.gridx = 1;
        txtDescription = new JTextArea(4, 20);
        form.add(new JScrollPane(txtDescription), c);

        panel.add(form, BorderLayout.CENTER);

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnCancel = new JButton("Cancel");
        JButton btnSave = new JButton("Save");
        buttons.add(btnCancel);
        buttons.add(btnSave);

        panel.add(buttons, BorderLayout.SOUTH);

        // Status
        lblStatus = new JLabel(" ");
        panel.add(lblStatus, BorderLayout.NORTH);

        // Actions
        btnSave.addActionListener(e -> onSave());
        btnCancel.addActionListener(e -> onCancel());

        setContentPane(panel);
    }

    private void onSave() {
        String result = service.add(
                txtUnitId.getText(),
                txtName.getText(),
                txtDescription.getText()
        );

        if ("SUCCESS".equals(result)) {
            lblStatus.setText("✔ Saved successfully");
            lblStatus.setForeground(new Color(0, 128, 0));
            onCancel();
        } else {
            lblStatus.setText("✖ " + result);
            lblStatus.setForeground(Color.RED);
        }
    }

    private void onCancel() {
        txtUnitId.setText("");
        txtName.setText("");
        txtDescription.setText("");
    }

    // 👉 CHẠY FILE NÀY
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddOrganizationUnitForm().setVisible(true));
    }
}