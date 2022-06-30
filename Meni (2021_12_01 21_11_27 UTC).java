import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Meni {

    private JFrame frame;
    private JPanel mpanel;
    private JLabel label;
    private JButton button [];


    public Meni (){
        frame  = new JFrame();
        mpanel = new JPanel();
        label = new JLabel();
        button = new JButton [7];
        for (int i=0;i<7;i++) {
            button[i] = new JButton();
        }
    }

    static void Avtor(){
        DodajAvtor  obj = new DodajAvtor();
        obj.go();
    }

    static void Stranka(){
        DodajStranka  obj = new DodajStranka();
        obj.go();
    }

    static void Izposoja(){
        DodajIzposoja  obj = new DodajIzposoja();
        obj.go();
    }

    static void Vrnitev(){
        VrnitevKnjige obj = new VrnitevKnjige();
        obj.go();
    }

    static void AKZ(){
        SpregledAKZ obj = new SpregledAKZ();
        obj.go();
    }

    static void Izposoje(){
        SpregledIzposoje obj = new SpregledIzposoje();
        obj.go();
    }

    static void Strank(){
        SpregledStrank obj = new SpregledStrank ();
        obj.go();
    }

    static void Izp(){
        VsiIzposoje obj = new VsiIzposoje ();
        obj.go();
    }


    public static void main (String [] Args){
        Meni projektna = new Meni ();
        projektna.go();

    }

    public void go (){


        frame.getContentPane().add(mpanel);
        mpanel.setPreferredSize(new Dimension(250,350));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.PAGE_AXIS));


        label.setText("Knjižnica");
        label.setFont(new Font("Calibri",Font.BOLD,20));
        mpanel.add(label);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        for(int i=0;i<7;i++) {
            mpanel.add(button[i]);
            button[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            button[i].setMaximumSize(new Dimension(190,40));
        }
        button[0].setText("Dodaj Avtor");
        button[1].setText("Dodaj Stranka");
        button[2].setText("Dodaj Izposoja");
        button[3].setText("Spregled");
        button[4].setText("Vrnitev Knjige");
        button[5].setText("Spregled Strank");
        button[6].setText("Izposoje");




        button[0].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
               Avtor();
               frame.dispose();
            }
        });

        button[1].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                Stranka();
                frame.dispose();
            }
        });

        button[2].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                Izposoja();
                frame.dispose();
            }
        });


        button[3].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                AKZ();
                frame.dispose();
            }
        });


        button[4].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                Izposoje();
                frame.dispose();
            }
        });

        button[5].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                Strank();
                frame.dispose();
            }
        });

        button[6].addActionListener(new Action() {
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
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                Izp();
                frame.dispose();
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);

    }

}
