package ptp;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class WorkingDirectory {
    private File workFile;
    private String workPath;

    public File getWorkFile() {
        return workFile;
    }

    public String workPath() {
        return workPath;
    }

    /**
     * 현재 디렉터리 경로 정보를 가진 클래스 생성
     */
    WorkingDirectory() {
        this.workPath = System.getProperty("user.dir");
        this.workFile = new File(workPath);
    }

    /**
     * 현재 작업디렉토리의 상위 디렉토리로 이동
     */
    public synchronized void setPwdToParent() {
        String str = workFile.getParent();
        // 루트인 경우
        if (str == null) {
            return;
        }

        // 갱신
        workPath = str;
        workFile = new File(workPath);
    }

    /**
     * @return 현재 작업 디렉토리 절대경로
     */
    public String getPwd() {
        return workPath;
    }

    /**
     * @return 현재작업디렉토리의 파일과 디렉토리들 출력
     */
    public void ls() {
        String ret = "";
        List<String> dirs = new ArrayList<>();
        List<String> files = new ArrayList<>();

        String msgFormat = "{0} : {1}\n"; // 굳이 메세지 포맷 사용

        String tmp;
        for (File file : workFile.listFiles()) {

            if (file.isDirectory()) {
                tmp = MessageFormat.format(msgFormat, "D", file.getName());
                dirs.add(tmp);
            }
            if (file.isFile()) {
                tmp = MessageFormat.format(msgFormat, "F", file.getName());
                files.add(tmp);
            }
        }

        // 오름차순 정렬로 출력
        Collections.sort(dirs);
        Collections.sort(files);

        for (String str : dirs)
            ret += str;
        for (String str : files)
            ret += str;

        System.out.println(ret);
    }

    /**
     * 작업 디렉토리 변경, 해당 디렉토리가 없을 경우, 새로운 디렉토리를 만듬??
     * 
     * @param path : 현재 작업 디렉토리의 상대 경로
     */
    public void cdDir(String dir) {
        // 현재 작업 디렉토리의 파일중에 해당하는 디렉토리가 있는지 찾고
        // 있으면 변경
        for (File file : this.workFile.listFiles()) {
            if (file.isDirectory())
                if (file.getName().equals(dir)) {
                    this.workPath += File.separator + dir;
                    this.workFile = new File(this.workPath);
                    return;
                }
        }

        System.out.println("No such Directory\n");
        return;
    }
}
