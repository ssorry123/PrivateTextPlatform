package ptp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UserCommand {
    private boolean allowInput;
    private Queue<String[]> queue;
    private Scanner sc;

    public UserCommand() {
        allowInput = true;
        queue = new LinkedList<>();
        sc = new Scanner(System.in);
    }

    public synchronized void setAllowInput(boolean val) {
        allowInput = val;
//        if (allowInput == true) {
//            System.out.println("잠들어있을수 있는 addCommand를 깨움");
//            notify();
//        }
    }

    public synchronized boolean getAllowInput() {
        return allowInput;
    }

    public synchronized void inputCommand() {
        if (allowInput == false) {
//            try {
//                wait();
//                System.out.println("addCommand 깨어남");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return;
        }

        // 실제로 사용자에게 입력받는 부분
        String[] opArr = sc.nextLine().split(" ");

        // Command 유효성 검사
        if (opArr.length == 0 || !CommandList.checkCommand(opArr[0])) {
            queue.add(new String[] { "_" }); // 의미없는 명령어 큐에 추가
            return;
        }

        // 명령어 정제
        String[] addArr = null;

        // exit, help, ls,
        if (opArr[0].equalsIgnoreCase("exit") || opArr[0].equalsIgnoreCase("help") || opArr[0].equals("ls")) {
            addArr = new String[] { opArr[0] };
        }
        // open, cat,
        else if (opArr[0].equalsIgnoreCase("open") || opArr[0].equalsIgnoreCase("cat")) {
            if (opArr.length >= 1)
                addArr = new String[] { opArr[0], opArr[1] };
        }
        // cd
        else if (opArr[0].equalsIgnoreCase("cd")) {
            String second = "";
            if (opArr.length >= 2)
                second = opArr[1];
            addArr = new String[] { opArr[0], second };
        }

        queue.add(addArr);
        notify();
    }

    public synchronized String[] getCommand() {
        if (queue.isEmpty()) {
            return null;
        }
        // System.out.println("getCommand");
        return queue.poll();
    }
}
