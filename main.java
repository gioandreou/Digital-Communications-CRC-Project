
import java.util.Random;
public class main {

    public static void main(String[] args) {
        String m, p;
        Random rand = new Random();
        char[] noise = new char[10];
        int t = 0, f = 0;
        int fal = 0;
        boolean flag;
        p = "110101";
        int i=0;
        while(i < 100000) {
            m =Integer.toBinaryString(rand.nextInt(1023)+512); to 1023;
            if(m.length()!=10){
                continue; 
            }
            m = CRC.getFrame(m, p);
            if (i % 10 == 0) {
                fal++;
                noise = m.toCharArray();
                if (noise[5] == '0') {
                    noise[5] = '1';
                    m = String.valueOf(noise);
                } else {
                    noise[5] = '0';
                    m = String.valueOf(noise);
                }
            }
            flag = Decoder.deCode(m, p);
            if (flag) {
                t++;
            } else {
                f++;
            }
            i++;
        }
        System.out.println("CRC Results:");
        System.out.println("Total Messages=" + i);
        System.out.println("False messages recieved=" + fal);
        System.out.println("Correct Messages=" + t + " Wrong Messages=" + f);

    }
}
