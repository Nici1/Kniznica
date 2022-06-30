import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SpregledIzposoje {

    private JFrame frame;
    private JPanel mpanel, mpanel1, mpanel2;
    private JTextField [] textfield;
    private JLabel [] label;
    private ArrayList<JButton> button;
    private JButton button1;
    private JButton button2;
    private JTextArea area;
    public String Ime, Priimek;


    public SpregledIzposoje(){
        frame  = new JFrame();
        mpanel1 = new JPanel();
        mpanel2 = new JPanel();
        mpanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button = new ArrayList<>();
        textfield = new JTextField[2];
        label = new JLabel[2];
        area = new JTextArea();

        for(int i=0;i<DatabaseConnectionISv2021.Izposoje().size();i++) {
            button.add( new JButton());
        }


        for(int i=0; i<=1;i++){
            textfield [i]= new JTextField( );
            label [i] = new JLabel();
        }
        Ime = new String();
        Priimek = new String();

    }



    public void go (){
        frame.getContentPane().add(mpanel);
        mpanel.setLayout(new FlowLayout());
        mpanel.add(mpanel1);
        mpanel.add(mpanel2);
        mpanel.setPreferredSize(new Dimension(770,415));
        mpanel1.setPreferredSize(new Dimension(100,350));
        mpanel2.setPreferredSize(new Dimension(650,400));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        mpanel2.setLayout(new BoxLayout(mpanel2,BoxLayout.PAGE_AXIS));


        button2.setText("Nazaj");
        label[0].setText("ID | Datum Izposoje | Rok | Datum Vrnitve | Knjige ID | Stranka ID");
        label[0].setFont(new Font("SanSerif",Font.CENTER_BASELINE,15));
        mpanel2.add(label[0]);



        mpanel2.add(area);
        area.setFont(new Font("SanSerif",Font.CENTER_BASELINE,15));
        mpanel2.add(button1);
        mpanel2.add(button2);
        button1.setText("Refresh");


        mpanel1.setLayout(new BoxLayout(mpanel1,BoxLayout.PAGE_AXIS));

        for (int i=0;i< DatabaseConnectionISv2021.Izposoje().size();i++){
            mpanel1.add(button.get(i));
            button.get(i).setMaximumSize(new Dimension(100,19));
            button.get(i).setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        area.setEditable(false);
        button1.setMaximumSize(new Dimension(150,30));
        button2.setMaximumSize(new Dimension(150,30));
        for(int i=0;i<2;i++){
            label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            //textfield[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);


        area.setText(String.format("%4s \n",DatabaseConnectionISv2021.Izposoje().get(0)));
        String parts [] = DatabaseConnectionISv2021.Izposoje().get(0).split(" ");
        button.get(0).setText(parts[0]);
        button.get(0).addActionListener(new Action() {
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

                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                String delcek0 [] = DatabaseConnectionISv2021.Izposoje().get(0).split(" ");

                DatabaseConnectionISv2021.insertVrnitev( delcek0[1],delcek0[2],formatter.format(date),delcek0[4],delcek0[5]);
            }
        });

        for( int i=1;i<DatabaseConnectionISv2021.Izposoje().size();i++) {
            area.append(String.format("%4s \n", DatabaseConnectionISv2021.Izposoje().get(i)));
            String kos [] = DatabaseConnectionISv2021.Izposoje().get(i).split(" ");
            button.get(i).setText(kos[0]);
            final int a = i;

            button.get(i).addActionListener(new Action() {
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

                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                    String delcek [] = DatabaseConnectionISv2021.Izposoje().get(a).split(" ");

                    DatabaseConnectionISv2021.insertVrnitev( delcek[1],delcek[2],formatter.format(date),delcek[4],delcek[5]);
                }
            });
        }


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
            frame.dispose();
            Meni.Izposoje();
        }
    });


}
}
