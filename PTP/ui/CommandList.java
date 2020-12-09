package ui;

import java.util.HashMap;
import java.util.Map;

public class CommandList {
    // 외부에서 객체 생성 불가능
    private CommandList() {

    }

    // 로드 시 기본 생성
    private static Map<String, Command> comList;
    static {
        comList = new HashMap<>();
        String command;
        String explain;

        int idx = 0;

        command = "pwd";
        explain = "현재 디렉토리의 절대 경로";
        comList.put(command, new Command(command, explain, idx++));

        command = "ls";
        explain = "현재 디렉토리에 존재하는 모든 파일 표시";
        comList.put(command, new Command(command, explain, idx++));

        command = "cd";
        explain = "cd A\n" + "A 디렉토리로 이동";
        comList.put(command, new Command(command, explain, idx++));

        command = "cat";
        explain = "cat A.txt\n" + "A.txt를 있는 그대로 보여준다";
        comList.put(command, new Command(command, explain, idx++));

        command = "open";
        explain = "open A.txt\n" + "A.txt를 에디터로 연다";
        comList.put(command, new Command(command, explain, idx++));

        command = "enc";
        explain = "enc A.txt B.txt\n" + "A.txt를 암호화하여 B.txt로 저장";
        comList.put(command, new Command(command, explain, idx++));

        command = "dec";
        explain = "dec A.txt B.txt\n" + "A.txt를 복호화하여 B.txt로 저장";
        comList.put(command, new Command(command, explain, idx++));

    }

    // 모든 명령어 객체 반환
    public static Command[] getAllCommands() {
        Command[] ret = new Command[comList.size()];

        int idx = 0;
        for (Map.Entry<String, Command> entry : comList.entrySet()) {
            ret[idx++] = entry.getValue();
        }
        return ret;
    }

    // commandName에 해당하는 Command 객체 반환
    public static Command getCommand(String commandName) {
        if (comList.containsKey(commandName)) {
            return comList.get(commandName);
        }
        return null;
    }

}
