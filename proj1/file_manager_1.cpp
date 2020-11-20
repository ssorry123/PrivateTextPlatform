#pragma once
// utf-8
/*
* file_manager.h 에서 선언된 함수를
* 이곳에서 구현해 주세요
*/
#include "share.h"
#include "file_manager.h"
#include "enc_dec.h"
#include "text_editor.h"


int call_file_manager(string txt_path, SHARE_FILE_FLAG flag, int password) {
    print_func();
    // txt_path를 flag를 보고 목적에 맞게 열거나 닫습니다
    // 필요한 경우 password를 참고합니다.

    cout <<
        "file name : " << txt_path << "\n" <<
        "flag : " << static_cast<int>(flag) << "\n" <<
        "password : " << password << endl;

    // C++ 이지만 C 입출력 사용
    // FILE* fp = fopen(txt_path.c_str(), "a+");
    FILE* fp = fopen(txt_path.c_str(), "w+");
    fprintf(fp, "abcdefg\nxyzedasdfbb\n");

    // text_editor example
    call_text_editor(fp);
        
    // dec_enc call example
    vector<string> str_arr(2, "abcdef");
    call_enc_dec(str_arr, true, password);


    fclose(fp);
    return 0;
}