# Springboot(Gradle) + React 프로젝트 AWS 배포하기
- EC2, RDS, Ubuntu, MobaXterm 활용
- Lightsail 활용한 내용은 [링크]() 참고
- 참고 : https://3d-yeju.tistory.com/63

* * *
<br>

- ### 인스턴스 퍼블릭 IPv4 주소로 터미널 접속할 때
  - termianl
  ```
  [접속할 때 실시]
  $ sudo apt -y update   
  $ sudo apt -y upgrade   
  
  [처음 접속했을 때 실시]
  $ sudo apt -y install nginx   
  $ sudo systemctl status nginx   
  ```
  <br>

- ### java, node.js 설치   
  (프로젝트에서 사용한 버전에 따라 숫자 바꿔주면 됨)   
  - terminal   
  ```
  (설치 전 항상 실시)
  $ sudo apt -y update
  
  $ sudo apt-get install openjdk-11-jdk
  $ curl -sL https://deb.nodesource.com/setup_18.x | sudo -E bash -   
  $ sudo apt-get install -y nodejs  
  ```
  <br>
  
- ### github  
  - terminal
  ```
  [github 설치]
  $ sudo apt-get update
  $ sudo apt-get install -y git
  $ git version
  
  [git clone]
  $ git clone git주소
  $ chmod +x gradlew
  ```
  <br>

- ### Springboot(Gradle) 빌드
  - terminal   
  ```
  스프링부트 파일의 디렉토리로 이동
  
  [스프링부트 파일 빌드]
  $ ./gradlew build

  [git clone 했다면]
  $ chmod +x gradlew

  해당 폴더\build\libs 디렉토리 이동하여.jar 파일 생성 확인

  [.jar 실행]
  (해당 폴더\build\libs 에서 실행)
  $ java -jar 파일명.jar

  [Linux 종료해도 연결 지속시키려면]
  (& : 백그라운드에서 실행하겠다는 의미)
  $ java -jar project.jar &
  $ nohup java -jar project.jar &

  [종료]
  ctrl +c 
  
  [백그라운드에서 실행 중인 스프링부트 종료]
  $ ps -ef | grep jar
  (.jar PID 번호 확인)
  $ kill -9 PID번호

  ```
 <br>

- ### React 빌드
  - terminal
  ```
  스프링부트 파일의 디렉토리로 이동

  [리액트 파일 빌드]
  $ npm run build
  
  해당 폴더\build 디렉토리 파일 생성 확인
  
  [express 설치]
  $ npm install express --save
  
  [server code 생성(server.js)]
  $ vi server.js
  ``` 
  ``` java script
      ★ server.js 내용 작성
      (작성 :i / 작성한 내용 저장하고 나가기 :wq)

        const http = require("http");
        const express = require("express");
        const path = require("path");

        const app = express();

        const port = 5000; //인스턴스 생성시 만들었던 포트번호 기입

        app.get("/ping", (req, res) => {
        res.send("pong");
        });

        app.use(express.static(path.join(__dirname, "build")));

        app.get("/*", (req, res) => {
        res.set({
        "Cache-Control": "no-cache, no-store, must-revalidate",
        Pragma: "no-cache",
        Date: Date.now()
        });
        res.sendFile(path.join(__dirname, "build", "index.html"));
        });

        http.createServer(app).listen(port, () => {
        console.log(`app listening at ${port}`);
        });
   ```
        
    
  - terminal (server.js 작성 후 이어서)
  ```   
  [서버 실행]
  $ node server.js
  
  [백그라운드에서 서버 실행하고 싶으면]
  $ node server.js &
  ```
      

<details>
    <summary> React 빌드 참고 (클릭:wink:) </summary> 
<br>
 
- 에러1   
  ```
  Creating an optimized production build...
  Failed to compile.

  Module not found: Error: Can't resolve '@ckeditor/ckeditor5-build-classic' in 'C:\bitacademy-bigdata-ai\eclipse-workspace\aws\CocktailprojectFront\src\board'

  ```
  
- 에러1 해결방법
  ```   
  package.json에 "dependencies"에 '@ckeditor/ckeditor5-build-classic' 관련 내용 확인

  [위 내용 있으면 다시 빌드]
  $ npm run build

  불가 시 node_modules 삭제

  $ npm run build 재실행
  $ npm install
  ```
<br>

- 에러2   
  ```
  Creating an optimized production build...
  Failed to compile.

  Module not found: Error: Can't resolve 'react-kakao-maps-sdk' in 'C:\bitacademy-bigdata-ai\eclipse-workspace\aws\CocktailprojectFront\src\map'
   ```
   
 - 에러2 해결방법   
  ``` 
  리액트 파일 있는 디렉토리로 이동하여
  $ npm install react-kakao-maps-sdk
  $ npm run build
  ```
  <br>
  
  - 모듈이 없다고 에러 발생할 경우 오류 내용에 맞게 아래 코드 실행
  ```
  $ npm install @ckeditor/ckeditor5-react
  $ npm install @ckeditor/ckeditor5-build-classic
  
  $ npm install react-kakao-maps-sdk
  ```
  <br>
  
- 추가내용   
  React 빌드 후 index.html이 공백 없는 것으로 확인될텐데 정상임!!   
 
<br>
</details>
<br><br>

- ### mysql   
  - terminal   
  ```
  $ sudo apt-get update
  $ sudo apt install mysql-server
  $ mysql --version
  $ cd /etc/mysql/mysql.conf.d
  $ sudo vi mysqld.cnf
    1. 주석처리
      # bind-address           = 127.0.0.1   
      # mysqlx-bind-address    = 127.0.0.1   
    2. 모든 접근 허용 (특정 IP값으로 지정 가능)
      # bind-address           = 0.0.0.0

  $ sudo mysql -u root -p
  enter 또는 root 비밀번호 설정
  
  [db 및 user 현황 파악]
  mysql> show databases;
  mysql> select user. host from user;
  
  [db 및 user 생성, 권한 부여, 적용]
  mysql> create database DB이름;
  mysql> use DB이름;
  mysql> create user 'username'@'%' identified by '비밀번호';
  mysql> grant all privileges on *.* to 'username'@'%' with grant option;
  mysql> flush privileges;
  mysql> select user. host from user;
  
  [mysql 작동 여부 확인, 중지, 시작]
  $ sudo systemctl status mysql
  $ sudo systemctl stop mysql
  $ sudo systemctl start mysql
  ```
  <br>
  
- ### Redis   
  - terminal 

  * * *
  <br>
  
  
