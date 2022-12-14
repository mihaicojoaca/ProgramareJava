package org.example;

//public class Main {
//    public static void main(String[] args) {
//        FileUtilty.WriteToFile();
//    }
//}

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.example.Matrice.generate;
import static org.example.FileUtilty.WriteToFile;
import static org.example.FileUtilty.readFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        tableExample();
    }
    public static void tableExample() throws IOException {
        JFrame f = new JFrame();
        String[] column = {"0","0","0","0","0","0"};

        JTable jt = new JTable(generate(), column);
        jt.setBounds(30,40,200,300);

        JScrollPane sp = new JScrollPane(jt);
        jt.setBounds(30,40,200,300);

        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 200, 95, 30);

        ActionListener addAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JDialog dialog = new JDialog();
                    dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setBounds(500, 500, 500, 500);
                    dialog.setVisible(true);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        addButton.addActionListener(addAction);
        f.add(addButton);
        f.add(sp);
        f.getContentPane().setLayout(new FlowLayout());
        f.setSize(300, 400);
        f.setVisible(true);

        WriteToFile();
        readFromFile();
    }
}
