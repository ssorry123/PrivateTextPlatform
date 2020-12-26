package ptp;

import java.util.Hashtable;
import java.util.Map;

/**
 * Command와 관련된 정적 메소드를 지원, 객체 생성은 불가능
 * 
 * @author 26060
 *
 */

class CommandList {
    // 외부에서 객체 생성 불가능
    private CommandList() {

    }

    // 로드 시 기본 생성
    // private static Map<String, Command> comList;
    private static Map<String, String> comHelp;

    static {
        comHelp = new Hashtable<>(); // thread safe
        String str;

        comHelp.put(Command.help.name(), "");

        str = "현재 디렉토리에 존재하는 모든 파일 표시";
        comHelp.put(Command.ls.name(), str);

        str = "cd A\n";
        str += "\t 현재 디렉토리의 A 디렉토리로 이동\n";
        str += "cd ..\n";
        str += "\t 현재 디렉토리의 상위 디렉토리로 이동\n";
        str += "cd\n";
        str += "\t 기본 디렉토리로 이동";
        comHelp.put(Command.cd.name(), str);

        str = "cat A.txt\n";
        str += "\tA.txt를 있는 그대로 보여준다";
        comHelp.put(Command.cat.name(), str);

        str = "open A.txt\n";
        str += "\tA.txt를 에디터로 연다";
        comHelp.put(Command.open.name(), str);

        str = "enc A.txt B.txt\n";
        str += "\tA.txt를 암호화하여 B.txt로 저장";
        comHelp.put(Command.enc.name(), str);

        str = "dec A.txt B.txt\n";
        str += "\tA.txt를 복호화하여 B.txt로 저장";
        comHelp.put(Command.dec.name(), str);

        str = "프로그램 종료";
        comHelp.put(Command.exit.name(), str);

    }

    public static Map<String, String> getCommandListWithHelp() {
        return comHelp;
    }

    public static boolean checkCommand(String command) {
        // 대소문자 상관없이 명령어 받아주자
        if (comHelp.containsKey(command.toLowerCase())) {
            return true;
        }
        return false;
    }
}
