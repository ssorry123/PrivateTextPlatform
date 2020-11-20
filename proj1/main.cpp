#pragma once
// utf-8


#include "share.h"  // 참고해주세요
// #include "text_editor.h"
#include "ui.h"
#include "file_manager.h"
// #include "enc_dec.h"

using namespace std;

/*
* UI 작업 후, main에 이식해 주세요
*/
int main() {
    print_func();
    // utf-8로 인코딩 되어있어, c, c++에서는 한글이 깨집니다.
    // 한글이 깨지지 않았다면, 파일이 ANSI로 인코딩 되어있는 것입니다.
    // 주석은 상관 없지만, 일단 txt 문서에 사용되는 언어는 영어로 제한하겠습니다.
    // 추후에 한글로 확장하겠습니다.
    // 또한 UI 제작시, printf, cout 등 출력은 일단 영어를 사용해주세요

    // example
    printf("Hello World\n");
    cout << "Hello World\n";

    printf("안녕 세계야\n");
    cout << "안녕 세계야\n";

    // cat 명령어 실행 example
    string file_path = "a.txt"; // 상대경로
    SHARE_FILE_FLAG flag = SHARE_FILE_FLAG::TXT_CAT;    // 파일 목적
    call_file_manager(file_path, flag);

    return 0;
}