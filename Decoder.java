public abstract class Decoder {
 public static boolean deCode(String m, String r){
        int n, k, count, minus;
        char[] upper, lower, stemp, ltemp, ret;
        n = m.length();
        k = r.length();
        upper = new char[m.length()];
        lower = new char[r.length()];
        stemp = m.toCharArray();
        upper = m.substring(0, k).toCharArray();
        count = lower.length - 1;
        lower = r.toCharArray();
        stemp = m.toCharArray();
        while (count < n + k - 1) {        
            int i = 0;
            boolean flag = false;
            while (upper[i] == '0' && i < upper.length-1) {
                i++;
                flag = true;
            }
            if (flag) {
                if ((stemp.length - count) - i > 0) {
                    ret = new char[upper.length];
                    for (int l = 0; l < upper.length; l++) {
                        if (l < upper.length - i) {
                            ret[l] = upper[l + i];
                        } else {
                            ret[l] = stemp[count + 1];
                            count++;
                        }
                    }

                } else {
                   if(Integer.valueOf(String.valueOf(upper))==0){
                       return true;
                    }else{
                        return false;
                    }

                }
            } else {
                ret = upper;
                    }
            upper = xor(ret, lower);
        }
        return false;
    }
    
 
   private static char[] xor(char[] a, char[] b) {
        char[] e;
        int temp1, temp2, i;
        e = new char[a.length];
        for (i = 0; i < a.length; i++) {
            temp1 = Integer.parseInt(Character.toString(a[i]));
            temp2 = Integer.parseInt(Character.toString(b[i]));
            temp1 = temp1 + temp2;
            if (temp1 == 0 || temp1 == 2) {
                e[i] = '0';
            } else if (temp1 == 1) {
                e[i] = '1';
            } else {
                System.err.println("Error\n");
            }
        }

        return e;
    }
}
