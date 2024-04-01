package other;

import java.util.Scanner;

public interface Input {
    Scanner scannerStr=new Scanner(System.in);
    static Integer inputInt(String msg){
        Scanner SCANNER_INT=new Scanner(System.in);
        System.out.print(COLOR.BLUE + msg+": " + COLOR.STOP);
        if(SCANNER_INT.hasNextInt()){
            return SCANNER_INT.nextInt();
        }else {
            return inputInt(msg);
        }
    }
    static String inputStr(String msg){
        System.out.print(COLOR.PURPLE + msg+": " + COLOR.STOP);
        return scannerStr.nextLine();
    }
}
