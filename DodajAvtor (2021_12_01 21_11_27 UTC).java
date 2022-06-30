import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DodajAvtor {

    private JFrame frame;
    private JPanel mpanel;
    private JTextField [] textfield;
    private JLabel [] label;
    private JButton button1;
    private JButton button2;
    public String Ime, Priimek;

    public void setPolnoIme (String Ime, String Priimek){
        this.Ime=Ime;
        this.Priimek=Priimek;
    }


    
    public DodajAvtor(){
        frame  = new JFrame();
        mpanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        textfield = new JTextField[2];
        label = new JLabel[2];
        for(int i=0; i<=1;i++){
            textfield [i]= new JTextField( );
            label [i] = new JLabel();
        }
        Ime = new String();
        Priimek = new String();

    }



    public void go (){
        frame.getContentPane().add(mpanel);
        mpanel.setPreferredSize(new Dimension(250,250));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.PAGE_AXIS));

        button1.setText("Submit");
        button2.setText("Nazaj");
        label[0].setText("Ime Avtorja");
        mpanel.add(label[0]);
        mpanel.add(textfield[0]);
        label[1].setText("Priimek Avtorja");
        mpanel.add(label[1]);
        mpanel.add(textfield[1]);
        mpanel.add(button1);
        mpanel.add(button2);

        button1.setMaximumSize(new Dimension(150,30));
        button2.setMaximumSize(new Dimension(150,30));
        for(int i=0;i<2;i++){
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            textfield[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);


        button1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                setPolnoIme(textfield[0].getText(),textfield[1].getText());
                System.out.println(Ime + " "+ Priimek);
                DatabaseConnectionISv2021.insertAvtor(Ime,Priimek);
            }
        });

        button2.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Meni projektna = new Meni();
                projektna.go();
                frame.dispose();
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);

    }
}
