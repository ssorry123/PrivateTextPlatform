package ptp;

/**
 * help 명령어 입력시 실행되는 정적 메소드
 * @author 26060
 *
 */

class Help {
    public static String help() {
        Command[] comList = CommandList.getAllCommands();

        String ret = "";
        for (Command com : comList) {
            ret += "\""+ com.name + "\"\n";
            ret += com.explain + "\n";
            ret += "index=" + com.index + "\n\n";
        }

        return ret;
    }

}
