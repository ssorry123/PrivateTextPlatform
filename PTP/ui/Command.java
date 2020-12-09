package ui;

public class Command {
    public final String name;
    public final String explain;
    public final int index;

    // default 다른 패키지에서 객체 생성 불가능;
    Command(String name, String explain, int index) {
        this.name = name;
        this.explain = explain;
        this.index = index;
    }
}
