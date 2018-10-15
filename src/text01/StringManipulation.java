package text01;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int index;
        boolean end = false;
        boolean start = false;
        StringBuilder sb = new StringBuilder(sc.nextLine());

        while (true) {
            index = sb.indexOf("*");
            if (index == sb.length() - 1) {
                end = true;

            }
            if (index == 0) {
                start = true;
            }
            if (index >= 0) {
                sb = sb.deleteCharAt(index);
            }
            if (index == -1) {
                break;
            }
        }
        if (start == true) {
            sb.insert(0, "*");
        }
        if (end == true) {
            sb.append("*");
        }


    }
}
