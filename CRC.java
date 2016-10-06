
public abstract class CRC {

    private static String Sequence(String m, String p) {
        String q,f;
        int n, k, count, minus;
        char[] upper, lower, stemp, ltemp, ret;
        n = m.length();
        k = p.length();
        upper = new char[n + k];
        lower = new char[k];
        stemp = m.toCharArray();
        q = String.valueOf(stemp);
        for (int i = 0; i < k - 1; i++) {
            q = q + 0;
        }
        upper = q.substring(0, k).toCharArray();
        count = lower.length - 1;
        lower = p.toCharArray();
        stemp = q.toCharArray();
        int loops=0;
        while (count < n + k - 1) {
            int i = 0;
            boolean flag = false;
            while (upper[i] == '0' && i < upper.length-1) {
                i++;
                flag = true;
            }
            if(loops==0) flag=false;
            if (flag) {
                if (((n + k - 1) - count) - i > 0) { 
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
                    minus = (n + k - 2) - count;
                    ret = new char[upper.length - 1];
                    int j = 0;
                    for (int l = ret.length - 1; l >= 0; l--) {
                        if (minus > 0) {
                            ret[l] = stemp[count + 1];
                            count++;
                            minus--;
                        } else {
                            ret[l] = upper[upper.length - j - 1];
                            j++;
                        }

                    }
                    f = String.valueOf(ret);
                    return String.valueOf(ret);
                }
            } else {
                ret = upper;
            }
            upper = xor(ret, lower);
            loops++;
        }
        f = String.valueOf(upper);
        return f;
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
    public static String getFrame(String m, String p) {
        String q;
        int k=p.length();
        char[] stemp = m.toCharArray();
        char[] fr=Sequence(m,p).toCharArray();
        q = String.valueOf(stemp);
        for (int i = 0; i < k - 1; i++) {
            q = q + String.valueOf(fr[i]);
        }
        return q;
    }
}
