package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EastPanel extends JPanel {
    JPanel friendPanel;
    JButton sendButton;
    public EastPanel(){
        super();
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Color.black);


        friendPanel=new JPanel();
        sendButton=new JButton();

        friendPanel.setOpaque(true);
        friendPanel.setBackground(Color.black);

        JScrollPane jScrollPane = new JScrollPane(friendPanel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setOpaque(true);
        jScrollPane.setBackground(Color.black);

        sendButton.setContentAreaFilled(false);
        sendButton.setBorderPainted(false);
        sendButton.setFocusPainted(false);
        sendButton.setText("Send music to the friends");
        sendButton.setFont(new Font("Italic",Font.ITALIC,18));
        sendButton.addMouseListener(new MouseListener() {
            Color color=sendButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sendButton.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sendButton.setForeground(color);
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(jScrollPane,BorderLayout.CENTER);
        add(sendButton,BorderLayout.SOUTH);
    }
}
