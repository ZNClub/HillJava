/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hillcipherjava;
/**
 *
 * @author Leon
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HillCipherJava {
    
    /**
     * 
     * @param arg
     * @throws Exception 
     */
    public static void main(String[] arg) throws Exception {
        int k[][] = new int[3][3]; //={{17,17,5}, {21,18,21}, {2,2,19}};
        int p[] = new int[300];
        int c[] = new int[300];
        int i = 0;
        System.out.println("Enter key");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str = br.readLine();
                k[i][j] = Integer.parseInt(str);
            }
        }

        System.out.println("enter plain text");
        String str = br.readLine();

        for (i = 0; i < str.length(); i++) {
            int c1 = str.charAt(i);
            //System.out.println(c1);
            p[i] = (c1) - 97;
        }
        i = 0;
        int zz = 0;
        for (int b = 0; b < str.length() / 3; b++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 3; x++) {
                    c[i] += k[j][x] * p[x + zz];
                }
                i++;
            }
            zz += 3;
        }
        System.out.println("Encrypted Text : ");
        for (int z = 0; z < str.length(); z++) {
            System.out.print((char) ((c[z] % 26) + 97));
        }
        System.out.println();

    }
}

/*
Output : 
Test Case 1 : 
Enter key
6
24
1
13
16
10
20
17
15
enter plain text
act
Encrypted Text : 
poh
BUILD SUCCESSFUL (total time: 4 seconds)

Test Case 2 : 
Enter key
6
24
1
13
16
10
20
17
15
enter plain text
cat
Encrypted Text : 
fin

*/
