package ptp;

import java.util.Scanner;

/**
 * 메인 클래스
 * 
 * @author 26060
 *
 */

public class Main {
    public static <T> void println(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello World, ptp demo");
        System.out.println("enter \"help\"");

        Scanner sc = new Scanner(System.in);

        // 작업디렉토리 관리 객체 생성
        WorkingDirectory workingDirectory;
        workingDirectory = new WorkingDirectory();

        // 명령어 대소문자 상관 없음.
        while (true) {
            System.out.print(workingDirectory.getPwd() + " >> ");
            String[] opArr = sc.nextLine().split(" ");
            String op = opArr[0];

            // 쉘 탈출
            if (op.equalsIgnoreCase("exit")) {
                break;
            }

            // help 명령어
            if (op.equalsIgnoreCase("help")) {
                println(Help.help());
            }
            // 파일 에디터로 열기
            else if (op.equalsIgnoreCase("open")) {

            }
            // cat
            else if (op.equalsIgnoreCase("cat")) {

            }
            // ls
            else if (op.equalsIgnoreCase("ls")) {
                println(workingDirectory.ls());
            }
            // cd
            else if (op.equalsIgnoreCase("cd")) {
                if (opArr.length < 2) {
                    println("No such Directory");
                    continue;
                }
                String arg = opArr[1];
                if (arg.equals("..")) {
                    workingDirectory.setPwdToParent();
                }
                /*
                 * 절대경로를 입력하였는가? 상대경로를 입력하였는가? 상대경로를 입력했다고 가정
                 */
                else if (arg.equals(".")) {
                    continue;
                } else {
                    workingDirectory.cdDir(arg);
                }
            }
            // 맞는 명령이 없을 경우
            else {
                println("please enter \"help\" to know correct Command");
            }

        }

        sc.close();
        System.out.println("ByeBye World, ptp demo");

    }

}
