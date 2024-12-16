package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private JTextField id;
    private JTextField title;
    private JTextField category;
    private JTextField cost;
    private JTextField authors;
    private JButton submitBtn;
    private JButton backBtn;

    public AddBookToStoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6,2));

        cp.add(new JLabel("Enter id"));
        id = new JTextField();
        cp.add(id);

        cp.add(new JLabel("Enter title"));
        title = new JTextField();
        cp.add(title);

        cp.add(new JLabel("Enter authors ( separated by space )"));
        authors = new JTextField();
        cp.add(authors);

        cp.add(new JLabel("Enter category"));
        category = new JTextField();
        cp.add(category);

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
                String bookTitle = title.getText();
                String bookCategory = category.getText();
                int bookId = Integer.parseInt(id.getText());
                float bookCost = Float.parseFloat(cost.getText());
                Book book = new Book(bookId, bookTitle, bookCategory, bookCost);
                List<String> authorsList = new ArrayList<String>();
                String[] authorsArray = authors.getText().split(" ");
                for (String author: authorsArray) {
                    authorsList.add(author);
                }
                store.addMedia(book);
                new StoreScreen(store);
                dispose();
            }

        });
        cp.add(backBtn);
        cp.add(submitBtn);

        setTitle("Add Book");
        setSize(600,240);

        setLocationRelativeTo(null);
        setVisible(true);

    }
}