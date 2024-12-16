package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private JFrame ownerFrame;
    public MediaStore(Media media, JFrame ownerFrame) {
        this.media = media;
        this.ownerFrame = ownerFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog(ownerFrame, "Play media", true);
                    JPanel mainGui = new JPanel(new BorderLayout());

                    mainGui.setBorder(new EmptyBorder(20, 20, 20, 20));
                    mainGui.add(new JLabel("Playing: " + media.getClass().getSimpleName() + " " + media.getTitle()), BorderLayout.CENTER);
                    JPanel buttonPanel = new JPanel(new FlowLayout());
                    mainGui.add(buttonPanel, BorderLayout.SOUTH);

                    JButton close = new JButton("Close");
                    close.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.setVisible(false);

                        }

                    });

                    buttonPanel.add(close);

                    ownerFrame.setVisible(true);
                    dialog.setContentPane(mainGui);
                    dialog.pack();
                    dialog.setLocationRelativeTo(ownerFrame);

                    dialog.setVisible(true);
                }

            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}