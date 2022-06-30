import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DodajIzposoja {

    private JFrame frame;
    private JPanel mpanel;
    private JTextField [] textfield;
    private JLabel [] label;
    private JButton button1;
    private JButton button2;
    public String DatumIzposoje, Rok,  KnjigeID, StrankaID;


    public void setthings (String DatumIzposoje, String Rok, String KnjigeID, String StrankaID){
        this.DatumIzposoje=DatumIzposoje;
        this.Rok=Rok;
        this.KnjigeID=KnjigeID;
        this.StrankaID=StrankaID;

    }

    public DodajIzposoja(){
        frame  = new JFrame();
        mpanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        textfield = new JTextField[4];
        label = new JLabel[4];
        for(int i=0; i<=3;i++){
            textfield [i]= new JTextField( );
            label [i] = new JLabel();
        }
        DatumIzposoje=new String ();
        Rok=new String ();
        KnjigeID=new String ();
        StrankaID = new String ();

    }



    public void go (){
        frame.getContentPane().add(mpanel);
        mpanel.setPreferredSize(new Dimension(250,300));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.PAGE_AXIS));


        for (int i=0;i<4;i++) {
            mpanel.add(label[i]);
            mpanel.add(textfield[i]);
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            textfield[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        button1.setText("Submit");
        button2.setText("Nazaj");
        label[0].setText("Datum Izposoje");
        label[1].setText("Rok");
        label[2].setText("KnjigeID");
        label[3].setText("StrankaID");

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
                setthings (textfield[0].getText(),textfield[1].getText(),textfield[2].getText(),textfield[3].getText());
                DatabaseConnectionISv2021.insertIzposoja(DatumIzposoje, Rok,KnjigeID, StrankaID);
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



        frame.setResizable(true);
        frame.setVisible(true);

    }

}
