package ClockApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    public Main(int utc) {
    	setTitle("Simple Clock");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton bt = new JButton("Update Time");
        JTextField jt = new JTextField();
        jt.setPreferredSize(new Dimension(50, 30));

        JPanel jPanelclock = new JPanel();
        JPanel jPanel_duoi = new JPanel();
        jPanel_duoi.add(jt, BorderLayout.EAST);
        jPanel_duoi.add(bt);

        Clock clock = new Clock();
        jPanelclock.add(clock);
        jPanel_duoi.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
        this.add(jPanelclock);
        this.add(jPanel_duoi);
        this.setLayout(new GridLayout(2, 1));
        clock.Start(utc);
        
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jt.getText();
                int newUtc = Integer.parseInt(s);
                new Main(newUtc);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main(7);
    }
}