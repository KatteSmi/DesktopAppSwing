import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static void createWindow() {
        JFrame frame = new JFrame("20_DesktopApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JTextField name = new JTextField(10);
        JTextField surname = new JTextField(10);
        JTextField middleName = new JTextField(10);

        final JLabel labelName = new JLabel("Имя");
        labelName.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        final JLabel labelSurname = new JLabel("Фамилия");
        labelSurname.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        final JLabel labelMiddleName = new JLabel("Отчество");
        labelMiddleName.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));

        JButton collapse = new JButton("Collapse");
        collapse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = name.getText();
                String text2 = surname.getText();
                String text3 = middleName.getText();

                if (text != null && text.length() > 0 && text2 != null && text2.length() > 0) {
                    JOptionPane.showMessageDialog(
                            panel,
                            text + " " + text2 + " " + text3 + " ",
                            "ФИО", JOptionPane.PLAIN_MESSAGE);
                    collapse.setText("Expand");
                } else {
                    JOptionPane.showMessageDialog(panel,
                            "Некорректный ввод! Повторите попытку.",
                            "Ошибка",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton expand = new JButton("Expand");
        expand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = name.getText();
                String text2 = surname.getText();
                String text3 = middleName.getText();

                if (text != null && text.length() > 0 && text2 != null && text2.length() > 0) {
                    JOptionPane.showMessageDialog(
                            panel,
                            text + " ",
                            "Имя", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(
                            panel,
                            text2 + " ",
                            "Фамилия", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(
                            panel,
                            text3 + " ",
                            "Отчество", JOptionPane.PLAIN_MESSAGE);
                    expand.setText("Expand");
                } else {
                    JOptionPane.showMessageDialog(panel,
                            "Некорректный ввод! Повторите попытку.",
                            "Ошибка",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(labelName);
        panel.add(name);
        panel.add(labelSurname);
        panel.add(surname);
        panel.add(labelMiddleName);
        panel.add(middleName);
        panel.add(collapse);
        panel.add(expand);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
