import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        int[] koords = new int[5];
        JTextField smallField = new JTextField("300, 250, 25, 45, 20");
        JTextField numbers = new JTextField("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, а, б, в, г, е, н, о, п, р, с");
        JFrame f = new JFrame("Swing Paint Demo");
        Button OutputBtn = new Button("Вывод");
        MyPanel myPanel = new MyPanel();
        OutputBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                String[] parm = smallField.getText().replaceAll(" ", "").split(",");


                if (parm.length != parm.length) {

                    JOptionPane.showMessageDialog( null,  "Ошибка в количестве параметров");
                }

                for(int i =0;i<parm.length;i++)
                {
                    koords[i]=getInteger(parm[i]);
                }

                myPanel.setX(koords[0]);
                myPanel.setY(koords[1]);
                myPanel.setWidth(koords[2]);
                myPanel.setHeight(koords[3]);
                myPanel.setStep(koords[4]);

                myPanel.setSymbols(numbers.getText());
                myPanel.repaint();
                f.add(myPanel);
                f.pack();
                f.setVisible(true);
            }
        });





        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(numbers);
        contents.add(smallField);
        contents.add(OutputBtn);
        f.setContentPane(contents);

        myPanel.repaint();
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
    private static int getInteger(String parm) {

        try {

            return Integer.parseInt(parm);

        } catch (Exception e) {

            new Exception("Это не цифра");

        }


        return 0;

    }
}

