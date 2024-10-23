
package com.mycompany.coracaopet;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Btadocao extends JButton {
    private BufferedImage image;

    public Btadocao(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setClip(new Ellipse2D.Float(0, 0, getWidth(), getHeight()));
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Não desenha bordas
    }
}