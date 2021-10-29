import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame implements ChangeListener,ItemListener {
    // aqui definiremos los nombre de las variables, las posiciones y el numero de variables.
    JLabel display;
    JLabel [] labels = new JLabel[14];
    JTextField [] TextField = new JTextField[8];
    String [] TextoLabel ={"Nombre:","Apellido:","Dirección:","telefono:","CP:","NIF:","Email:","Contraseña:","Pais:","Provincia:","Poblacion:","Sexo:","Idiomas:","carta de presentación"};
    String [] Paises ={"España","Francia","Portugal"};
    int [] xLabels = {10,330,10,330,10,330,10,300,10,160,360,10,330,10};
    int [] yLabels = {10,10,60,60,110,110,160,160,210,210,210,260,260,315};
    int [] xTextField = {120,450,120,450,120,450,120,460};
    int [] yTextField = {15,15,65,65,115,115,165,215};
    JTextField Otroidioma;
    private JButton generar;
    private JComboBox Pais,Provincia;
    private JCheckBox Castellano, Ingles, Frances, Mas;
    private JRadioButton Hombre,Mujer,Otros;
    private ButtonGroup Sexo;
    private JTextArea Cartadepresesentación;
    private JMenuBar menuBar;
    private JMenu Colores;
    private JMenuItem Azul,Rojo,Verde,Gris, Salir;
    private JPasswordField modoincognito;
    JTextPane ejecutado = new JTextPane();
    int numLabels = 14;
    int numTextField = 8;
    int anchoLabel = 100;
    int altoLabel = 30;
    int anchoTextField = 150;
    int altoTextField = 20;
    public Formulario(){
        initPasswordField();
        initLabels();
        initTextField();
        initPantalla();
        intitCheckBox();
        intitCombobox();
        intitRadioButton();
        initTextArea();
        initButton();
        initTExtPane();
        initMenu();
    }

    private void initPasswordField() {
        //aqui nos permite que la contraseña no sea visulizable al escribirla
        modoincognito = new JPasswordField();
        modoincognito.setBounds(450, 165, 150, 20);
        add(modoincognito);
    }

    private void initMenu() {
        // Este es un menu donde puedes cambiar el color del fondo y cerrar la aplicación
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        Colores = new JMenu("Colores");
        menuBar.add(Colores);


        Azul = new JMenuItem("Azul");
        Colores.add(Azul);

        Rojo = new JMenuItem("Rojo");
        Colores.add(Rojo);

        Verde = new JMenuItem("Verde");
        Colores.add(Verde);

        Gris = new JMenuItem("Gris");
        Colores.add(Gris);

        Salir = new JMenuItem("Salir");
        menuBar.add(Salir);
        //generamos los ActionListener para poder hacer cambios en pantalla
        Azul.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.BLUE);
            }

        });
        Rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.red);
            }
        });
        Verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.green);
            }
        });
        Gris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.gray);
            }
        });
        Salir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }
    private void initTExtPane() {
        //este text panel es donde se trasmitira toda la información que hemos escrito en nuestro formulario
        ejecutado.setBounds(750,10,400,650);
        ejecutado.setBorder(new LineBorder(Color.DARK_GRAY));
        ejecutado.setVisible(false);
        add(ejecutado);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        ejecutado.setEditorKit(htmlEditorKit);

    }

    private void initButton() {
        //Este botón nos ayuda a generar el text panel en el cual vamos a presentar toda la informacion selecionada
        generar=new JButton("generar");
        generar.setBounds(420,350,100,100);
        generar.setFont(new Font("Monospaced",Font.PLAIN,16));
        generar.setOpaque(true);
        generar.setBackground(Color.WHITE);
        generar.setBorder(new LineBorder(Color.DARK_GRAY));
        generar.setForeground(Color.BLACK);
        generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == generar) {
                    ejecutado.setVisible(true);
                    String sexo;
                    String numero_idiomas="";
                    if(Hombre.isSelected()){sexo= "Hombre";
                    }else if(Mujer.isSelected()){sexo= "Mujer";
                    }else{sexo ="Otro";}
                    if(Castellano.isSelected()){numero_idiomas=numero_idiomas+"Castelllano";}
                    if(Frances.isSelected()){numero_idiomas=numero_idiomas+" Frances";}
                    if(Ingles.isSelected()){numero_idiomas=numero_idiomas+" Inglés";}
                    if(Mas.isSelected()){numero_idiomas=numero_idiomas+" Japonees";}
                    ejecutado.setText(
                            //aqui definimos que se va a trasmitir dentro del jPanel y en que orden y como
                            "<span style='margin-left:50px;'>&nbsp;&nbsp;Nombre</span><br>" + TextField[0].getText()+"<br>"+
                                    "<i>Apellido</i><br>" + TextField[1].getText()+"<br>"+
                                    "<i>Dirección</i><br>"+TextField[2].getText()+"<br>"+
                                    "<i>teléfono</i><br>"+TextField[3].getText()+"<br>"+
                                    "<i>CP</i><br>"+TextField[4].getText()+"<br>"+
                                    "<i>NIF</i><br>"+TextField[5].getText()+"<br>"+
                                    "<i>Email</i><br>"+TextField[6].getText()+"<br>"+
                                    "<i>Contraseña</i><br>"+modoincognito.getText()+"<br>"+
                                    "<i>Pais</i><br>"+Pais.getItemAt(Pais.getSelectedIndex())+"<br>"+
                                    "<i>Provincia</i><br>"+Provincia.getItemAt(Provincia.getSelectedIndex())+"<br>"+
                                    "<i>Población</i><br>"+TextField[7].getText()+"<br>"+
                                    "<i>Sexo</i><br>"+sexo+"<br>"+
                                    "<i>Idiomas</i><br>"+numero_idiomas+"<br>"+
                                    "<i>Cartadepresesentación</i><br>"+Cartadepresesentación.getText().replaceAll("\n","<br>")+"<br>"


                    );
                }
            }
        });
        add(generar);
    }


    private void initTextArea() {
        //En este Text Area crear una carta de presentación
        Cartadepresesentación=new JTextArea();
        Cartadepresesentación.setBounds(10,350,400,300);
        Cartadepresesentación.setBorder(new LineBorder(Color.DARK_GRAY));
        Cartadepresesentación.setLineWrap(true);
        add(Cartadepresesentación);


    }

    private void intitRadioButton() {
        // Este RadioButton sirve para determinar el sexo de la persona que esta escribiendo formulario
        Sexo = new ButtonGroup();

        Hombre=new JRadioButton("Hombre");
        Hombre.setBounds(70,260,70,30);
        Hombre.addChangeListener(this);
        add(Hombre);
        Sexo.add(Hombre);

        Mujer=new JRadioButton("Mujer");
        Mujer.setBounds(150,260,70,30);
        Mujer.addChangeListener(this);
        add(Mujer);
        Sexo.add(Mujer);

        Otros=new JRadioButton("Otros");
        Otros.setBounds(230,260,70,30);
        Otros.addChangeListener(this);
        add(Otros);
        Sexo.add(Otros);
    }

    private void intitCombobox() {
        //En el combo box daremos la opción de elegir el lugar donde vive
        Pais=new JComboBox();
        Pais.setBounds(60,215,80,20);
        add(Pais);
        String paisecogido = "";

        //aqui proponemos los paises
        Pais.addItem(Paises[0]);
        Pais.addItem(Paises[1]);
        Pais.addItem(Paises[2]);
        Pais.addItemListener(this);



        //intente usar change itemStateChanged, pero no conseguí generar los cambios. he pensado en borrarlos cada vez que se cambiaran de
        //seleccion pero sin resultado.
        paisecogido = (String) Pais.getItemAt(Pais.getSelectedIndex());
        System.out.println(paisecogido);
        if (paisecogido.equals("España")) {
            //estas son las provincias definidas
            Provincia = new JComboBox();
            Provincia.setBounds(260, 215, 90, 20);

            add(Provincia);
            Provincia.addItem("Madrid");
            Provincia.addItem("Barcelona");
            Provincia.addItem("Valencia");
            Provincia.addItemListener(this);
        }
    }

    private void intitCheckBox() {
        //Los checkBox no ayudan a definir cuantos idiomas conoce el individuo
        Castellano = new JCheckBox("Castellano");
        Castellano.setBounds(430, 260, 90, 30);
        Castellano.setBackground(Color.WHITE);
        add(Castellano);

        Ingles = new JCheckBox("Inglés");
        Ingles.setBounds(520, 260, 70, 30);
        Ingles.setBackground(Color.WHITE);
        add(Ingles);

        Frances = new JCheckBox("Frances");
        Frances.setBounds(590, 260, 90, 30);
        Frances.setBackground(Color.WHITE);
        add(Frances);

        Mas = new JCheckBox("Otros");
        Mas.setBounds(680, 260, 90, 30);
        Mas.setBackground(Color.WHITE);
        add(Mas);
        Mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Otroidioma = new JTextField("");
                add(Otroidioma);
                Otroidioma.setBounds(6800,300,100,30);
                Otroidioma.setOpaque(true);
                Otroidioma.setBackground(Color.WHITE);
                Otroidioma.setBorder(new LineBorder(Color.DARK_GRAY));
                Otroidioma.setForeground(Color.BLACK);


            }
        });
    }

    private void initTextField() {
        // generamos las zonas de texto
        for(int i = 0; i < numTextField; i++){
            TextField[i] = new JTextField();
            TextField[i].setBounds(xTextField[i], yTextField[i], anchoTextField, altoTextField);
            TextField[i].setFont(new Font("Monospaced",Font.PLAIN,16));
            TextField[i].setOpaque(true);
            TextField[i].setBackground(Color.WHITE);
            TextField[i].setBorder(new LineBorder(Color.DARK_GRAY));
            TextField[i].setForeground(Color.BLACK);
            add(TextField[i]);
        }
        TextField[3].addKeyListener(new KeyAdapter() {
                                        public void keyTyped(KeyEvent e) {
                                            char caracter = e.getKeyChar();
                                            if (((caracter < '0') || (caracter > '9'))
                                                    && (caracter != '\b')) {
                                                e.consume();
                                            }
                                        }
                                    }
        );
    }


    public void initLabels(){
        // los labels son todos los nombres que les hemos puestos a nuestros objetos
        for(int i = 0; i < numLabels; i++){
            labels[i] = new JLabel(TextoLabel[i]);
            int ancho = (i == 8 ||i == 11) ? 50 : anchoLabel;
            if (i == 13) ancho = 250;
            if (i == 7) ancho = 120;
            labels[i].setBounds(xLabels[i], yLabels[i], ancho, altoLabel);
            labels[i].setFont(new Font("Monospaced",Font.PLAIN,16));
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.WHITE);
            labels[i].setForeground(Color.BLACK);
            add(labels[i]);
        }
    }

    private void initPantalla() {
        //aqui definimos la Pantalla de nuestro proyecto
        setLayout(null);
        setTitle("Formulario");
        setSize(450,510);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
    }

    public static void main(String[] args) {
        Formulario formulario1=new Formulario();
        formulario1.setBounds(0,0,800,500);
        formulario1.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("cambio");
    }
}
