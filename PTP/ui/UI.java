package ui;

public class UI {
    public static String help() {
        Command[] comList = CommandList.getAllCommands();

        String ret = "";
        for (Command com : comList) {
            ret += com.name + " : ";
            ret += com.explain + "\n";
            ret += "index : " + com.index + "\n\n";
        }

        return ret;
    }

}
