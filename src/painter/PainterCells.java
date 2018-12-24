package painter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PainterCells {
    /**
     * size of image in pixels
     */
    private int size;
    /**
     * required variable for accurate markup
     */
    private int numbersOfStep;
    /**
     * Size of cell in pixels
     */
    private int step;
    /**
     * left border of graph
     */
    private int rightBorder;
    /**
     * upper border of graph
     */
    private int upBorder;
    /**
     * BufferedImage variable
     */
    private BufferedImage bufferedImage;
    /**
     * canvas of graph
     */
    private Graphics2D g2d;
    public PainterCells(int upBorder,int rightBorder) {
        this.numbersOfStep = Math.max(upBorder,rightBorder) + 2;
        this.size = numbersOfStep*40;

        String sx = "";
        String sy = "";
        step = size / (numbersOfStep);
        bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, size, size);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(size / 400));
        for (int i = step; i <= size - step; i += step) {
            g2d.drawString(sx, i - 40, size - step + 12);
            g2d.drawString(sy, 15, i + 8);
            g2d.drawLine(step, i, size - step, i);
            g2d.drawLine(i, step, i, size - step);
        }
    }
    public void save(String path)  {
        File file = new File(path);
        try {
            ImageIO.write(bufferedImage, path.substring(path.length()-3), file);
        } catch (IOException e) {
            System.out.println("ImageIO.write error" + e.getMessage());
        }
    }
}
