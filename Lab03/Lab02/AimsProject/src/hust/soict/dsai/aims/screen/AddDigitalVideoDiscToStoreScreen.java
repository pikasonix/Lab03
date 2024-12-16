package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;

    private JTextField id;
    private JTextField title;
    private JTextField category;
    private JTextField director;
    private JTextField length;
    private JTextField cost;
    private JButton submitBtn;
    private JButton backBtn;
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(7,2));

        cp.add(new JLabel("Enter id"));
        id = new JTextField();
        cp.add(id);

        cp.add(new JLabel("Enter title"));
        title = new JTextField();
        cp.add(title);

        cp.add(new JLabel("Enter category"));
        category = new JTextField();
        cp.add(category);

        cp.add(new JLabel("Enter director"));
        director = new JTextField();
        cp.add(director);

        cp.add(new JLabel("Enter length"));
        length = new JTextField();
        cp.add(length);

        cp.add(new JLabel("Enter cost"));
        cost = new JTextField();
        cp.add(cost);

        backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store);
                dispose();
            }
        });

        submitBtn = new JButton("Enter");

        submitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int DvdId = Integer.parseInt(id.getText());
                String DvdTitle = title.getText();
                String DvdCategory = category.getText();
                String DvdDirector = director.getText();
                int DvdLength = Integer.parseInt(length.getText());
                float DvdCost = Float.parseFloat(cost.getText());
                DigitalVideoDisc dvd = new DigitalVideoDisc(DvdId, DvdTitle, DvdCategory, DvdDirector, DvdLength, DvdCost);
                store.addMedia(dvd);
                new StoreScreen(store);
                dispose();
            }

        });
        cp.add(backBtn);
        cp.add(submitBtn);

        setTitle("Add DVD");
        setSize(600,240);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}