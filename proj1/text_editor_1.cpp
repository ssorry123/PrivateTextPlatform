#pragma once
// utf-8
/*
* test_editor.h 에서 선언된 함수를
* 이곳에서 구현해 주세요
*/
#include "text_editor.h"

int call_text_editor(FILE* const fp) {
    print_func();

    // test code
    fseek(fp, 0, SEEK_END); // 파일 포인터를 파일의 끝으로 이동
    int size = ftell(fp);   // 파일 포인터의 현재 위치를 얻음
    fseek(fp, 0, SEEK_SET); // 파일 포인터를 시작 위치로 이동
    // 파일의 내용 출력
    int c;
    while ((c = fgetc(fp)) != EOF) {
        printf("%c", c);
    }

    // to do something



    return 0;
}