#pragma once
// utf-8
/*
* 파일관리를 위해 필요한
* 전처리(define)이나 함수 선언은 이곳에서 해주세요
*/
#include "share.h"

// 기본인수는 선언에만 사용
int call_file_manager(string txt_path, SHARE_FILE_FLAG flag, int password = 0);

/*
* file manager 요구사항 :
*   UI로 부터 받은 정보를 이용하여 
*   TXT 파일을 열거나 생성하고 닫는 등 관리합니다.
*   파일을 열고 text_editor나 enc_dec 함수를 호출합니다.
*   text_editor나 enc_dec에서 작업이 끝나면
*   끝난 작업에 대한 상태와 정보를 ui에 전달합니다.
*
*/