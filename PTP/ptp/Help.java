package ptp;

import java.util.Collections;
import java.util.Map;

/**
 * help 명령어 입력시 실행되는 정적 메소드
 * 
 * @author 26060
 *
 */

class Help {
    private Help() {

    }

    public static void help() {
        Map<String, String> list = CommandList.getCommandListWithHelp();
        // 명령어 알파벳순 정렬 나중에 추가

        for (Map.Entry<String, String> entry : list.entrySet()) {
            String ret = "";
            ret += "\"" + entry.getKey() + "\"\n";
            ret += entry.getValue() + "\n";
            System.out.println(ret);
        }
    }

}
