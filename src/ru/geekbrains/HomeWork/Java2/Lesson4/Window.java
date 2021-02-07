package ru.geekbrains.HomeWork.Java2.Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Window {

    static public class MyWindow extends JFrame {
        public MyWindow() {
            setBounds(500, 500, 400, 300);
            setTitle("Chat");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JLabel text = new JLabel("text");
            add(text, BorderLayout.CENTER);

            JTextField field = new JTextField();
            add(field, BorderLayout.AFTER_LAST_LINE);
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setText(((JTextField)e.getSource()).getText());
                    field.setText(null);
                }
            });


            JButton button = new JButton("Send");
            add(button, BorderLayout.EAST);
            button.addActionListener(e -> {
                text.setText(field.getText());
                field.setText(null);
            });

            setVisible(true);
        }

    }


    public static void main(String[] args) {
        new MyWindow();
    }

}
