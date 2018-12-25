package painter;

import main.App;

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

    private BufferedImage bufferedImage;
    /**
     * canvas of graph
     */
    private Graphics2D g2d;
    public PainterCells(int numbersOfCells) {
        step = 40;
        numbersOfStep = numbersOfCells + 2;
        size = numbersOfStep*step;
        bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, size, size);
    }
    public void paintLabyrinth(App app){
        for (int i = 0; i < app.getSize()*2+1; i++){
            for (int j = 0;j < app.getSize()*2+1;j++){
                switch (app.getLab().getCells()[i][j]){
                    case '#':
                        g2d.setColor(Color.black);
                        g2d.fillRect(40+j*40,40+i*40,40,40);
                        break;
                    case ' ':
                        g2d.setColor(Color.white);
                        g2d.fillRect(40+j*40,40+i*40,40,40);
                        break;
                    default:
                        g2d.setColor(Color.RED);
                        g2d.fillRect(40+j*40,40+i*40,40,40);
                }
            }
        }
    }

    public void save(String path) throws IOException  {
        File file = new File(path);
        try {
            ImageIO.write(bufferedImage, path.substring(path.length()-3), file);
        } catch (IOException e) {
            throw new IOException("Can't write image.");
        }
    }
}
