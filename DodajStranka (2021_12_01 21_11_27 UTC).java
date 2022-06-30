import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

public class DodajStranka {

    private JFrame frame;
    private JPanel mpanel;
    private JTextField [] textfield;
    private JLabel [] label;
    private JButton button1;
    private JButton button2;
    public String Ime, Priimek, DatumClanarine, Naslov, TelStevilka, VeljavnostMesecov;


    public void setthings (String Ime, String Priimek,String DatumClanarine,String VeljavnostMesescov, String Naslov, String TelStevilka){
        this.Ime=Ime;
        this.Priimek=Priimek;
        this.DatumClanarine = DatumClanarine;
        this.Naslov=Naslov;
        this.TelStevilka=TelStevilka;
        this.VeljavnostMesecov=VeljavnostMesescov;
    }

    public DodajStranka(){
        frame  = new JFrame();
        mpanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        textfield = new JTextField[6];
        label = new JLabel[6];
        for(int i=0; i<=5;i++){
            textfield [i]= new JTextField( );
            label [i] = new JLabel();
        }
        Ime = new String();
        Priimek = new String();
        Naslov = new String();
        TelStevilka = new String();
        DatumClanarine = new String();

    }



    public void go (){
        frame.getContentPane().add(mpanel);
        mpanel.setPreferredSize(new Dimension(250,300));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.PAGE_AXIS));


        for (int i=0;i<6;i++) {
            mpanel.add(label[i]);
            mpanel.add(textfield[i]);
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            textfield[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        button1.setText("Submit");
        button2.setText("Nazaj");
        label[0].setText("Ime Stranke");
        label[1].setText("Priimek Stranke");
        label[2].setText("Datum Članarine");
        label[3].setText("Veljavnost v Mesecov");
        label[4].setText("Naslov");
        label[5].setText("Telefonska Številka");

        mpanel.add(button1);
        mpanel.add(button2);
        button1.setMaximumSize(new Dimension(150,30));
        button2.setMaximumSize(new Dimension(150,30));
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
                setthings (textfield[0].getText(),textfield[1].getText(),textfield[2].getText(),textfield[3].getText(),textfield[4].getText(),textfield[5].getText());
                DatabaseConnectionISv2021.insertStranka(Ime,Priimek,DatumClanarine,VeljavnostMesecov,Naslov,TelStevilka);
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
