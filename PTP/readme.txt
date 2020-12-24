1. 패키지
ptp : 메인 패키지
    * Main 클래스
        각종 명령어 실행
        
    * Command 클래스
        - name:String
        - explain:String
        - index:Integer
    * CommandList 클래스:static
        커맨드, 커맨드 설명, 인덱스 정의
        - Map<String, Command>
        + Command[]:getAllCommand()
        + Command:getCommand(String)
        
    * WorkingDirectory 클래스
        작업 디렉토리 관리
    
    * Help 클래스
        help명령어 입력시 실행됨
        
    * cat 클래스
        cat명령어 입력시 실행됨

textEditor
textEncDec