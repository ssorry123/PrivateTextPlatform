package ptp;

import java.io.File;
import java.io.IOException;

class Open {
    public static void open(UserCommand userCommand, String txtName, boolean backGround)
            throws IOException, InterruptedException {
        // 작업 디렉토리 절대경로 + 상대경로 -> 타겟파일의 절대 경로
        String path = WorkDir.getPwd() + File.separator + txtName;
        System.out.println("Editing " + path);

        File targetFile = new File(path);
        if (targetFile.exists()) {
            System.out.println("해당파일이 존재함");
        }
        // 파일이 존재하지 않으면 만든다
        else {
            System.out.println("create new file : " + txtName);
            targetFile.createNewFile(); // 실제로 파일을 만든다
        }

        // 외부 프로세스 실행
        // txt파일 메모장으로 열고 기다리기
        userCommand.setAllowInput(false); // 유저 명령 입력 잠금

        Runtime runtime = Runtime.getRuntime(); // 런타임 객체
        String[] command = new String[] { "notepad.exe", path };
        Process notePad = runtime.exec(command); // 프로세스 생성 후 실행
        notePad.waitFor(); // 해당 프로세스 종료때까지 기다림

        userCommand.setAllowInput(true); // 유저 명령 입력 잠금 해제

    }
}
