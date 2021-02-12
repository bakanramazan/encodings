package arduinoserial;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;

/**
 *
 * @author ramazanbakan
 */
public class ArduinoSerial implements SerialPortEventListener{

    private serialType st=new serialType();
    private serialLib sLib=new serialLib();
    private String comPort=" ";
    private static SerialPort serialPort;
    
    public static void main(String[] args) {
        ArduinoSerial obj=new ArduinoSerial();
        obj.start("COM 7");
        obj.veriGönder("1");
       // while (true) {
         //   obj.veriGönder("Pong");
       // }
        
    }

   
    @Override
    public void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType()==SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=st.input.readLine();
                System.out.println(inputLine);
                if (inputLine.equals("pong")) {
                    System.out.println("message:"+inputLine);
                }
            } catch (Exception e) {
            }
        }
    }
   
//seri porta veri göndermek için kullanılan fonksiyon. 
    public void veriGönder(String s){
        s=s+"\n";
        try {
            st.output.write(s.getBytes());
            st.output.flush();
        } catch (Exception e) {
            System.out.println("hata:"+e.toString());
        }
    }
    
     public  void start(String comPort){
        this.comPort=comPort;
        st=sLib.serialIntialize(serialPort.comPort);
    }
    
    public void stop(){
        if (serialPort!=null) {
            serialPort.removeEventListener();
            serialPort.close();
            System.out.println("Seri port başarıyla kapatıldı");
        }
    }
    
}
