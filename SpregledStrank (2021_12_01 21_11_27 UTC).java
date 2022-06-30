import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class SpregledStrank {

    private JFrame frame;
    private JPanel mpanel;
    private JTextField [] textfield;
    private JLabel [] label;
    private JButton button1;
    private JButton button2;
    private JTextArea area;
    public String Ime, Priimek;


    public SpregledStrank(){
        frame  = new JFrame();
        mpanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        textfield = new JTextField[2];
        label = new JLabel[2];
        area = new JTextArea();
        for(int i=0; i<=1;i++){
            textfield [i]= new JTextField( );
            label [i] = new JLabel();
        }
        Ime = new String();
        Priimek = new String();

    }



    public void go (){
        frame.getContentPane().add(mpanel);
        mpanel.setPreferredSize(new Dimension(600,350));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.PAGE_AXIS));

        button1.setText("Spregled");
        button2.setText("Nazaj");
        label[0].setText("StrankaID | Ime | Priimek | DatumClanarine | Veljavnost v Mesecov | Naslov | Telefonska Stevilka ");
        mpanel.add(label[0]);



        mpanel.add(area);
        mpanel.add(button1);
        mpanel.add(button2);

        area.setEditable(false);
        button1.setMaximumSize(new Dimension(150,30));
        button2.setMaximumSize(new Dimension(150,30));
        for(int i=0;i<2;i++){
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            //textfield[i].setAlignmentX(Component.CENTER_ALIGNMENT);
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



                area.setText(DatabaseConnectionISv2021.Strank().get(0)+"\n");



                for (int i=1; i<DatabaseConnectionISv2021.Strank().size();i++) {

                    area.append(DatabaseConnectionISv2021.Strank().get(i)+"\n");
                }
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
