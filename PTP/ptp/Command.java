package ptp;

/**
 * Command 객체
 * @author 26060
 *
 */

class Command {
    public final String name;
    public final String explain;
    public final Integer index;

    // default 다른 패키지에서 객체 생성 불가능;
    protected Command(String name, String explain, Integer index) {
        this.name = name;
        this.explain = explain;
        this.index = index;
    }
}