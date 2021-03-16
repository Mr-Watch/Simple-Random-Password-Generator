import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringIndexOutOfBoundsException;
public class Methods {
    static char[] pass_array(int array_length) {
        char empty = 0;
        char[] pass_array = new char[array_length];
        for (int i = 0; i <= pass_array.length - 1; i++)
            pass_array[i] = empty;
        return pass_array;
    }
    static char[] fill_pass_array(char[] pass_array, char[] selections) {
        int range = 0;
        int pos = 0;

        char[] char_num = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
        };
        char[] char_let = {
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'u',
            'v',
            'w',
            'x',
            'y',
            'z',
        };
        char[] char_LET = {
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G',
            'H',
            'I',
            'J',
            'K',
            'L',
            'M',
            'N',
            'O',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'Y',
            'V',
            'W',
            'X',
            'Y',
            'Z',
        };
        char[] char_sym = {
            '!',
            '@',
            '#',
            '$',
            '%',
            '^',
            '&',
            '*',
            '(',
            ')',
            '_',
            '-',
            '~',
            '=',
            '[',
            ']',
            '{',
            '}',
            '|',
            ':',
            ';',
            ',',
            '/',
            '?',
            '.',
            '"',
            ' '
        };

        for (int i = 0; i < selections.length; i++) {
            if (selections[i] == '1')
                range = range + 10;
            else if (selections[i] == '2')
                range = range + 26;
            else if (selections[i] == '3')
                range = range + 26;
            else if (selections[i] == '4')
                range = range + 27;
        }

        char[] pool = new char[range];
        for (int i = 0; i < selections.length; i++) {
            if (selections[i] == '1') {
                System.arraycopy(char_num, 0, pool, pos, char_num.length);
                //System.out.println(Arrays.toString(pool));
                pos = pos + char_num.length;
            } else if (selections[i] == '2') {
                System.arraycopy(char_let, 0, pool, pos, char_let.length);
                //System.out.println(Arrays.toString(pool));
                pos = pos + char_let.length;
            } else if (selections[i] == '3') {
                System.arraycopy(char_LET, 0, pool, pos, char_LET.length);
                //System.out.println(Arrays.toString(pool));
                pos = pos + char_LET.length;
            } else if (selections[i] == '4') {
                System.arraycopy(char_sym, 0, pool, pos, char_sym.length);
                //System.out.println(Arrays.toString(pool));
                pos = pos + char_sym.length;
            }

        }

        for (int i = 0; i < pass_array.length; i++) {
            int v = (int)(Math.random() * range);

            pass_array[i] = pool[v];
        }

        return pass_array;
    }
    static char[] selections() {
        Scanner input = new Scanner(System.in);
        char[] sel = new char[4];
        String s = "";
        int range = 0;
        boolean alarm = false;
        boolean rep = false;
        int alarm_count = 0;

        try {

            do {
                alarm_count = 0;
                s = input.nextLine();
                if (s.length() > 4)
                    System.out.println("You entered more than 4 options\nThe limit is 4");

                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == '1' || s.charAt(k) == '2' || s.charAt(k) == '3' || s.charAt(k) == '4') {
                        alarm = false;
                        if (alarm_count > 0)
                            alarm = true;
                    } else {
                        alarm = true;
                        alarm_count++;
                    }
                }
                if (alarm) System.out.println("The only characters allowed are '1-4'");
                int f = 0;
                int j = 0;
                while (f < s.length()) {
                    j = f + 1;
                    while (j < s.length()) {
                        if (s.charAt(f) == s.charAt(j)) {
                            System.out.println("You cannot have the same option twice");
                            rep = true;
                            f = j = s.length();
                        } else {
                            rep = false;
                            j++;
                        }
                    }
                    f++;
                }

            } while (s.length() > 4 || alarm || rep || alarm_count > 0);
            for (int f = 0; f < sel.length; f++) {
                sel[f] = s.charAt(f);
            }
            Arrays.sort(sel);
            System.out.println("You selected " + s.length() + " options out of 4\n");

        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("You selected " + s.length() + " options out of 4\n\nThe rest will be ignored\n");

            for (int i = s.length(); i < sel.length; i++)
                sel[i] = '0';
            Arrays.sort(sel);
            //System.out.println(Arrays.toString(sel));	
        }
        return sel;
    }

}