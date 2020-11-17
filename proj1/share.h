#pragma once
// utf-8
/*
* 프로젝트 전체에서 사용될
* 전처리나, 공유 함수에 대해 선언 하는 곳입니다.
*
* 그 외에, 전체와의 약속을 적어놓는 곳입니다.
*/

#include <cstdio>   // 또는 #include <stdio.h>
#include <iostream>
#include <string>





// 파일 인코딩 관련
/* visual studio에서 파일 기본 생성시 
* 인코딩 ANSI로 생성됩니다.
* 
* 저희는 인코딩을 utf-8을 사용합니다.
* git에 업로드 할때, 한글이 깨지지 않기 위함과
* utf-8을 많이 사용하기 때문입니다.
* .editorconfig 파일은, 소스 코드 파일 생성시 utf-8로 생성되게 만들어주며
* visul studio 폴더 가장 바깥쪽에 위치하여야 합니다.(/proj/.editorconfig)
* 
* 소스 코드에 한글 주석을 사용할 수 있지만
* utf-8 사용시, printf, cout로 한글을 출력하게 되면 한글이 깨지게 됩니다.
* 일단 영어만 지원하는 txt 플랫폼을 만들고
* 그 후에, 한글을 지원할 수 있도록 확장하도록 하겠습니다.
* 
* 그러므로, txt 파일 또한 utf-8 인코딩을 사용하겠습니다.
*/

// 1. char 배열 대신, c++의 string 클래스를 이용해 주세요




