import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dessert {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bakery Surprise!");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 228, 241)); // โทนชมพูอ่อน

        Font thaiFont = new Font("Tahoma", Font.BOLD, 18);

        // ตัวการ์ตูน (เปลี่ยน path เป็นไฟล์ภาพของคุณ)
        ImageIcon cuteIcon = new ImageIcon("cute_cake.png"); // PNG หรือ GIF
        JLabel cartoon = new JLabel(cuteIcon);
        cartoon.setBounds(20, 50, 150, 150);
        frame.add(cartoon);

        // ข้อความ
        JLabel label = new JLabel("ช่วยเลี้ยงขนมเค้าหน่อย~");
        label.setFont(thaiFont);
        label.setForeground(Color.MAGENTA);
        label.setBounds(200, 50, 400, 30);
        frame.add(label);

        // ปุ่ม Yes
        JButton yesBtn = new JButton("Yes 🍰");
        yesBtn.setFont(thaiFont);
        yesBtn.setBackground(new Color(255, 182, 193)); // ชมพู
        yesBtn.setOpaque(true);
        yesBtn.setBounds(200, 250, 120, 50);
        frame.add(yesBtn);

        // ปุ่ม No
        JButton noBtn = new JButton("No ❌");
        noBtn.setFont(thaiFont);
        noBtn.setBackground(new Color(255, 105, 180)); // ชมพูเข้ม
        noBtn.setOpaque(true);
        noBtn.setForeground(Color.WHITE);
        noBtn.setBounds(350, 250, 120, 50);
        frame.add(noBtn);

        Random rand = new Random();

        // ทำให้ปุ่ม No หลบเมาส์แบบสุ่ม
        noBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int x = rand.nextInt(frame.getWidth() - noBtn.getWidth());
                int y = rand.nextInt(frame.getHeight() - noBtn.getHeight() - 50) + 50;
                noBtn.setLocation(x, y);
            }
        });

        // กด Yes แสดงข้อความขอบคุณ
        yesBtn.addActionListener(e -> {
            UIManager.put("OptionPane.messageFont", thaiFont);
            JOptionPane.showMessageDialog(frame, "ขอบคุณสำหรับขนม! 💖");
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
