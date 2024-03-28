import javax.swing.*;

import java.awt.*;

import java.util.ArrayList;


public class MyPanel extends JPanel {


    private int x = 100;

    private int y = 100;

    private int width = 200;

    private int height = 200;
    private int step = 30;

    private int delta = 3;

    private ArrayList<Rectangle> outlist = new ArrayList<Rectangle>();


    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

    }


    public Dimension getPreferredSize() {

        return new Dimension(1560, 700);

    }


    public  void setSymbols(String parm) {

        String[] arr = parm.replace(",", "").split(" ");
        for (String cifra : arr) {
            switch (cifra) {

                case "1":

                    segment(2);

                    segment(4);

                    break;

                case "2":

                    segment(1);

                    segment(2);

                    segment(3);

                    segment(6);

                    segment(5);

                    break;

                case "3":

                    segment(1);

                    segment(2);

                    segment(3);

                    segment(4);

                    segment(5);

                    break;

            }

            x = x + step + width;

        }
    }


    private void segment(int number) {
        switch (number) {
            case 1:
                outlist.add(new Rectangle(x+delta, y, x+width - delta, y));

                break;

            case 2:

                outlist.add(new Rectangle(x+width, y + delta, x+width, y + (height / 2) - delta));

                break;

            case 3:

                outlist.add(new Rectangle(x + delta, y + height / 2, x+width - delta, y + height / 2));

                break;

            case 4:

                outlist.add(new Rectangle(x+width, y + (height / 2) + delta, x+width, y + height - delta));

                break;

            case 5:

                outlist.add(new Rectangle(x + delta, y + height, x+width - delta, y + height));

                break;

            case 6:

                outlist.add(new Rectangle(x, y + (height / 2) + delta, x, y + height - delta));

                break;

            case 7:

                outlist.add(new Rectangle(x, y + delta, x, y + (height / 2) - delta));

                break;

        }

    }


    public void setX(int x) {

        this.x = x;

    }


    public void setY(int y) {

        this.y = y;

    }


    public void setWidth(int width) {

        this.width = width;

    }


    public void setHeight(int height) {

        this.height = height;

    }


    public void setStep(int step) {

        this.step = step;

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);


        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 16));

        g.drawString("Drawing shapes using ArrayList", 10, 25);


        g.setColor(Color.BLUE);

        for (Rectangle rectangle : outlist) {

            g.drawLine(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        }

    }

}
