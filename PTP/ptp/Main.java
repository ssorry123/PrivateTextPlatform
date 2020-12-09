package ptp;

import java.util.Scanner;

import ui.UI;
import ui.Command;
import ui.CommandList;

public class Main {
    public static <T> void println(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello World, ptp demo");
        System.out.println("enter \"help\"");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">> ");
            String op = sc.nextLine();

            // 쉘 탈출
            if (op.equalsIgnoreCase("exit")) {
                break;
            }

            // help 명령어
            if (op.equalsIgnoreCase("help")) {
                println(UI.help());
            }
            // 미설정
            else if (op.equalsIgnoreCase("")) {

            }
            // 맞는 명령이 없을 경우
            else {
                println("please enter \"help\" to know collect Command");
            }

        }

        sc.close();
        System.out.println("ByeBye World, ptp demo");

    }

}
