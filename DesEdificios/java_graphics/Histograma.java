import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Histograma extends JFrame {

    private JPanel contentPane;
    private ArrayList<String> xData;
    private ArrayList<Double> yData;
    private int eje_x_l;
    private int eje_y_l;
    private int x_location;
    private int y_location;
    private int x_padding;
    private String eje_x_string;
    private String eje_y_string;
    private String titulo_string;
    private Color color;
    private int n;
    private JLabel titulo_lbl;
    private JLabel eje_x_lbl;
    private JLabel eje_y_lbl;
    private JLabel origen_lbl;
    private JLabel eje_x_valores[];
    private JLabel eje_y_valores[];
    private Color colors[];

    public Histograma(ArrayList<String> x_valores,ArrayList<Double> y_valores) {
        //xData=(ArrayList<String>)x_valores.clone();
	xData=new ArrayList<>();
	for(int iterador=0;iterador<x_valores.size();iterador++){
	 xData.add(x_valores.get(iterador));
	}
        //yData=(ArrayList<Double>)y_valores.clone();
	yData=new ArrayList<>();
	for(int iterador=0;iterador<y_valores.size();iterador++){
	 yData.add(y_valores.get(iterador));
	}
        n=4;
        eje_x_l = 480;
        eje_y_l = 350;
        x_location = 15;
        y_location = 15;
        x_padding = 0;
        eje_x_string = "";
        eje_y_string = "";
        titulo_string = "";
        cargar_interfaz();
    }
    

    private void cargar_interfaz() {
        //Interfaz
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocation(90, 30);
        setSize(eje_x_l + 200, eje_y_l + 170);
        colors= new Color [7];
        colors[0]= Color.YELLOW;
        colors[1]= Color.RED;
        colors[2]= Color.BLUE;
        colors[3]= Color.GREEN;
        colors[4]= Color.PINK;
        colors[5]= Color.MAGENTA;
        colors[6]= Color.ORANGE;
        Random rand = new Random();
        color = colors[rand.nextInt(7)];
        //Componentes
        //Eje X
        eje_x_lbl=new JLabel(eje_x_string);
        eje_x_lbl.setHorizontalAlignment(JLabel.LEFT);
        eje_x_lbl.setBounds(x_location+eje_x_l+80, eje_y_l+y_location+55, 70, 20);
        add(eje_x_lbl);
        //Eje Y
        eje_y_lbl=new JLabel(eje_y_string);
        eje_y_lbl.setHorizontalAlignment(JLabel.RIGHT);
        eje_y_lbl.setBounds(x_location, y_location+10, 70, 20);
        add(eje_y_lbl);
        //Origen del plano
        origen_lbl= new JLabel("0");
        origen_lbl.setHorizontalAlignment(JLabel.RIGHT);
        origen_lbl.setVerticalAlignment(JLabel.NORTH);
        origen_lbl.setBounds(25+x_location, eje_y_l+78+y_location, 50, 30);
        add(origen_lbl);
        //Titulo
        titulo_lbl=new JLabel(titulo_string);
        titulo_lbl.setHorizontalAlignment(JLabel.CENTER);
        titulo_lbl.setBounds(x_location+80, y_location, eje_x_l, 20);
        add(titulo_lbl);
        //Eiquetar ejes
        int amplitud_x = (eje_x_l - 20) / xData.size();
        //Algoritmo de intervalo de datos
        Double max, min;
        max = yData.get(0);
        min = yData.get(0);
        for (int i = 0; i < yData.size(); i++) {
            if (yData.get(i) > max) {
                max = yData.get(i);
            }
            if (yData.get(i) < min) {
                min = yData.get(i);
            }
        }
        double amplitud_intervalo = max/n;
        int amplitud_y=eje_y_l/n;
        //Decimal Format
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        eje_x_valores= new JLabel[xData.size()];
        for (int i = 0; i < xData.size(); i++) {
            //Pintar eje x
            eje_x_valores[i]= new JLabel(xData.get(i));
            eje_x_valores[i].setHorizontalAlignment(JLabel.CENTER);
            eje_x_valores[i].setBounds(80 + amplitud_x * (i) + x_location,
                    eje_y_l + 50 + y_location, amplitud_x, 20);
            add(eje_x_valores[i]);
        }
        eje_y_valores= new JLabel[n];
        for (int i = 0; i < n; i++) {
            //Pintar eje y
            eje_y_valores[i]= new JLabel(decimalFormat.format(amplitud_intervalo * (i + 1)));
            eje_y_valores[i].setHorizontalAlignment(JLabel.RIGHT);
            eje_y_valores[i].setVerticalAlignment(JLabel.NORTH);
            eje_y_valores[i].setBounds(x_location,  eje_y_l + 74 - amplitud_y * (i + 1) + y_location, 70, amplitud_y);
            add(eje_y_valores[i]);
        }
        x_location+=4;
        y_location+=27;
    }

    public void paint(Graphics g) {
        super.paint(g);
        //Eje y
        g.drawLine(80 + x_location, 30 + y_location, 80 + x_location, eje_y_l + 60 + y_location);
        g.drawLine(76 + x_location, 37 + y_location, 80 + x_location, 30 + y_location);
        g.drawLine(84 + x_location, 37 + y_location, 80 + x_location, 30 + y_location);
        //Eje x
        g.drawLine(60 + x_location, eje_y_l + 50 + y_location, eje_x_l + 80 + x_location, eje_y_l + 50 + y_location);
        g.drawLine(eje_x_l + 73 + x_location, eje_y_l + 46 + y_location, eje_x_l + 80 + x_location, eje_y_l + 50 + y_location);
        g.drawLine(eje_x_l + 73 + x_location, eje_y_l + 54 + y_location, eje_x_l + 80 + x_location, eje_y_l + 50 + y_location);
        int amplitud_x = (eje_x_l - 20) / xData.size();
        int x_padding_individual = x_padding / (xData.size());
        //Algoritmo de intervalo de datos
        Double max, min;
        max = yData.get(0);
        min = yData.get(0);
        for (int i = 0; i < yData.size(); i++) {
            if (yData.get(i) > max) {
                max = yData.get(i);
            }
            if (yData.get(i) < min) {
                min = yData.get(i);
            }
        }
        double amplitud_intervalo = max/n;
        int amplitud_y=eje_y_l/n;
        //Decimal Format
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        eje_x_valores= new JLabel[xData.size()];
        for (int i = 0; i < xData.size(); i++) {
            //Pintar eje x
            g.drawLine(80 + amplitud_x * (i + 1) + x_location, eje_y_l + 50 + y_location, 80 + amplitud_x * (i + 1) + x_location, eje_y_l + 55 + y_location);
        }
        eje_y_valores= new JLabel[n];
        for (int i = 0; i < n; i++) {
            //Pintar eje y
            g.drawLine(80 + x_location, eje_y_l + 50 - amplitud_y * (i + 1) + y_location, 75 + x_location, eje_y_l + 50 - amplitud_y * (i + 1) + y_location);
        }
        for (int i = 0, h; i < yData.size(); i++) {
            //Barras
            g.setColor(color);
            h = (int) (amplitud_y * (yData.get(i) / amplitud_intervalo));
            g.fillRect((amplitud_x) * (i) + 80 + x_padding_individual + x_location,(eje_y_l - 10) - h + 60+y_location, amplitud_x - 2 * x_padding_individual, h);
        }
    }
}
