import java.util.ArrayList;
public class DestruyendoEdificios{

 public static void main(String args[]){
  ArrayList<String> x=new ArrayList<>();
  ArrayList<Double> y=new ArrayList<>();
  int n=Leer.datoInt();
  double d=0f;
  for(int i=0;i<n;i++){
   d=Leer.datoDouble();
   x.add(Integer.toString(i));
   y.add(d);
  }
  Histograma histograma = new Histograma(x,y);
  histograma.setVisible(true);
 }
}
