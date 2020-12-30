package ptp;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 작업 디렉토리는 싱글톤으로 관리한다 작업 디렉토리 관련 모든 메소드는 이 패키지에서 정의한다. 게으른 홀더(Thread safe) 방식,
 * 가장 많이 사용
 * 
 * @author 26060
 *
 */
public class WorkDir {
    // 초기화
    private WorkDir() {

    }

    // 초기화
    private File workDir;

    // 초기화
    private static class InnerInstanceClazz {
        // static과 final의 조합
        private static final WorkDir wD;
        static {
            wD = new WorkDir();
            String tmp = System.getProperty("user.dir");
            wD.workDir = new File(tmp);
        }
    }

    /**
     * @return 현재 작업 디렉토리 절대경로
     */
    public synchronized static String getPwd() {
        return InnerInstanceClazz.wD._getPwd();
    }

    private synchronized String _getPwd() {
        return workDir.getAbsolutePath();
    }

    /**
     * 현재 작업디렉토리의 상위 디렉토리로 이동
     */
    public synchronized static void setWorkDirToParent() {
        InnerInstanceClazz.wD._setWorkDirToParent();
    }

    private synchronized void _setWorkDirToParent() {
        String str = workDir.getParent();
        if (str == null)
            return;

        workDir = new File(str);
    }

    public synchronized static void setDefaultWorkDir() {
        String tmp = System.getProperty("user.dir");
        InnerInstanceClazz.wD.workDir = new File(tmp);
    }

    /**
     * 작업 디렉토리 변경
     * 
     * @param path : 현재 작업 디렉토리의 상대 경로
     */
    public synchronized static void cdDir(String dir) {
        InnerInstanceClazz.wD._cdDir(dir);
    }

    private synchronized void _cdDir(String dir) {
        // 현재 작업 디렉토리의 파일중에 해당하는 디렉토리가 있는지 찾고 있으면 변경
        FilenameFilter filter;
        filter = (file, name) -> {
            if (name.equals(dir))
                return true;
            return false;
        };

        File[] targetFiles = workDir.listFiles(filter);
        if (targetFiles.length != 1) {
            System.out.println(dir + " " + targetFiles.length + " No such Directory\n");
            return;
        }

        workDir = targetFiles[0];

        return;
    }

    public synchronized static void ls() {
        InnerInstanceClazz.wD._ls();
    }

    private synchronized void _ls() {
        String ret = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\taHH:mm");
        List<String> dirs = new ArrayList<>();
        List<String> files = new ArrayList<>();

        String tmp;
        for (File file : workDir.listFiles()) {
            tmp = sdf.format(file.lastModified());

            if (file.isDirectory()) {
                tmp += "\t\t<DIR>\t\t" + file.getName();
                dirs.add(tmp);
            }
            if (file.isFile()) {
                tmp += "\t\t\t" + file.length() + "\t" + file.getName();
                files.add(tmp);
            }
        }

        // 오름차순 정렬로 출력
        Collections.sort(dirs);
        Collections.sort(files);

        System.out.println("--------------------------------------------------------------");
        System.out.println("날짜\t\t시간\t\t형태\t크기byte\t이름");
        System.out.println("--------------------------------------------------------------");

        for (String str : dirs)
            ret += str + "\n";
        for (String str : files)
            ret += str + "\n";
        System.out.println(ret);

        System.out.println("--------------------------------------------------------------\n");
    }
}
