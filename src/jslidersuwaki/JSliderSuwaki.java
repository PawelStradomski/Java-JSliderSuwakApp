
package jslidersuwaki;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.SwingConstants.VERTICAL;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author pawelstradomski
 */
public class JSliderSuwaki extends JFrame
{

    private int Horizontal;
    JSliderSuwaki()
    {
        this.setTitle("Suwaki");
        this.setBounds(600, 300, 400, 200);
        this.setDefaultCloseOperation(3);
        initComponent();
    }
    public void initComponent()
    {
        this.getContentPane().add(suwak, BorderLayout.NORTH);
        this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH);
        this.getContentPane().add(etykieta, BorderLayout.CENTER);
        wartoscSuwaka.setEditable(false);                                       //wylacza mozliwosc edycji w polu textowym
        suwak.setMajorTickSpacing(10);                                          //odstepy tickowania
        suwak.setMinorTickSpacing(5);                                           //odstepy tickowania z mniejsza przedzialka
        suwak.setPaintTicks(true);                                              //rysuje skale liczbowa odstepow
        suwak.setPaintLabels(true);                                             //wypisuje etykiety wartosci odstepow na skali
        suwak.setSnapToTicks(true);                                             //suwak wskakuje w przegrudki tickowania
                                                                                //sluchacz suwaka tworzy obiekt ChangeEvent i przekazuje wartosc do zmiennej e
        suwak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wartoscSuwaka.setText(""+ ((JSlider)e.getSource()).getValue()); //wypisuje w okienku text pobrana wartosc z suwaka
                
                etykieta.setFont(new Font(etykieta.getFont().getFontName(), etykieta.getFont().getStyle(),((JSlider)e.getSource()).getValue()));
            }
        });
        
    }
                                                                                //JSlider suwak = new JSlider();    //goToSource JSlider lub:
    JSlider suwak = new JSlider(Horizontal, 0, 100, 30);                        //(Horizontal,0,100,30) lub (JSlider.Horizontal,0,100,30) itp.
    JTextField wartoscSuwaka = new JTextField(""+suwak.getValue());             //okienko text + pobiera wartosc suwaka. Jako, ze to String dodano""
    JLabel etykieta = new JLabel("Zmiana rozmiaru czcionki");
   
    public static void main(String[] args) {
        new JSliderSuwaki().setVisible(true);
    }
    
}
