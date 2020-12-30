package ptp;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Cat {
    private Cat() {

    }

    // 단순 터미널 출력, 쉘에 맞게 수정??
    public static void cat(String txtName) {
        try {
            // 작업디렉토리에서 파일이름이 같고, 읽을 수 있는 파일을 거름
            FileFilter filter;
            filter = (f) -> {
                if (f.getName().equals(txtName))
                    if (f.canRead())
                        return true;
                return false;
            };

            File workDir = new File(WorkDir.getPwd());
            File[] targetFiles = workDir.listFiles(filter);

            // 이름이 같은 파일은 한개이거나, 없어야함
            if (targetFiles.length != 1) {
                System.out.println("No such File");
                return;
            }

            // File을 Stream<String>으로 받기
            File targetFile = targetFiles[0];
            Stream<String> stream = Files.lines(Paths.get(targetFile.getAbsolutePath()));
            stream.forEach(System.out::println);
            System.out.println();
            stream.close();

//            for (File file : wD.getWorkFile().listFiles()) {
//                if (file.getName().equals(txtName) && file.canRead()) {
//                    // txt 파일 절대 경로
//                    String filePath = wD.getPwd() + File.separator + txtName;
//                    // Path 객체
//                    Path path = Paths.get(filePath);
//
//                    // 스트림 생성
//                    Stream<String> stream = Files.lines(path);
//                    stream.forEach(System.out::println);
//                    System.out.println();
//
//                    return;
//                }
//            }
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
