package ptp;

import java.io.IOException;
import java.util.Arrays;
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

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("Hello World, ptp demo");
        System.out.println("enter \"help\"");

//        // 작업디렉토리 관리 객체 생성
//        WorkDirectory workingDirectory;
//        workingDirectory = new WorkDirectory();

        UserCommand userCommand = new UserCommand();

        // 명령어 대소문자 상관 없음.
        while (true) {
            if (userCommand.getAllowInput())
                System.out.print(WorkDir.getPwd() + " >> ");

            userCommand.inputCommand(); // 명령어 입력받기
            String[] opArr = userCommand.getCommand(); // 명령어 가져오기
            if (opArr == null)
                continue;
            String op = opArr[0];
            // System.out.println(Arrays.toString(opArr));

            // 쉘 탈출
            if (op.equalsIgnoreCase("exit")) {
                break;
            }

            // help 명령어
            if (op.equalsIgnoreCase("help")) {
                Help.help();
            }
            // 파일 에디터로 열기
            else if (op.equalsIgnoreCase("open")) {
                Open.open(userCommand, opArr[1], false);
            }
            // cat
            else if (op.equalsIgnoreCase("cat")) {
                Cat.cat(opArr[1]);
            }
            // ls
            else if (op.equalsIgnoreCase("ls")) {
                WorkDir.ls();
                //Ls.ls(workingDirectory.getWorkFile());
                // workingDirectory.ls();
            }
            // cd
            else if (op.equalsIgnoreCase("cd")) {
                if (opArr[1] == "") {
                    println("Go default path");
                    // workingDirectory = new WorkDirectory();
                    WorkDir.setDefaultWorkDir();
                    continue;
                }
                //
                else if (opArr[1].equals("..")) {
                    // workingDirectory.setPwdToParent();
                    WorkDir.setWorkDirToParent();
                }
                //
                else if (opArr[1].equals(".")) {
                    continue;
                }
                //
                else {
                    // workingDirectory.cdDir(opArr[1]);
                    WorkDir.cdDir(opArr[1]);
                }
            }
            // 맞는 명령이 없을 경우
            else {
                println("please enter \"help\" to know correct Command");
            }

        }

        System.out.println("ByeBye World, ptp demo");

    }

}
