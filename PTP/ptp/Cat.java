package ptp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Cat {
    private Cat() {

    }

    // 단순 터미널 출력, 쉘에 맞게 수정??
    public static void cat(WorkingDirectory wD, String txtName) {
        try {
            for (File file : wD.getWorkFile().listFiles()) {
                if (file.getName().equals(txtName) && file.canRead()) {
                    // txt 파일 절대 경로
                    String filePath = wD.getPwd() + File.separator + txtName;
                    // Path 객체
                    Path path = Paths.get(filePath);

                    // 스트림 생성
                    Stream<String> stream = Files.lines(path);
                    stream.forEach(System.out::println);
                    System.out.println();

                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception");
        }
        System.out.println("No Such File");
    }
}
