package ClockApp;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Clock extends JPanel {
    private JLabel timeLabel;

    public Clock() {
        setBounds(0,0,200,100);
        setLayout(new FlowLayout());
        timeLabel = new JLabel();
        add(timeLabel);
    }

    public void Start(int utc) {
        new Thread(()->{
            while (true) {
                updateTime(utc);
            }
        }).start();
    }

    private void updateTime(int utc) {
        ZoneOffset utcPlusOneOffset = ZoneOffset.ofHours(utc);
        
        // Lấy thời gian hiện tại theo múi giờ UTC+1
        LocalDateTime now = LocalDateTime.now(utcPlusOneOffset);
        
        // Định dạng thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        timeLabel.setText(formattedTime);
    }
}

