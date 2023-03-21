# Springboot(Gradle) + React 프로젝트 AWS 배포하기
- EC2, RDS, Ubuntu 활용
- Lightsail 활용한 내용은 [링크]() 참고

* * *
<br>

- ### Springboot(Gradle) 빌드
  - terminal   
  ```
  스프링부트 파일의 디렉토리로 이동
  
  [스프링부트 파일 빌드]
  $ ./gradlew build

  해당 폴더\build\libs 디렉토리 이동하여.jar 파일 생성 확인
  
  [.jar 실행]
  (해당 폴더\build\libs 에서 실행)
  $ java -jar 파일명.jar

  [종료]
  ctrl +c 
  
  [git clone 후 ]
  $ chmod +x gradlew
  ```
 <br>

- ### React 빌드
  - terminal
  ```
  스프링부트 파일의 디렉토리로 이동

  [리액트 파일 빌드]
  $ npm run build
  
  해당 폴더\build 디렉토리 파일 생성 확인
  ```

<details>
    <summary> React 빌드 참고 </summary> 
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
  
  mysql> show databases;
  mysql> select user. host from user;
  mysql> create database DB이름;
  mysql> use DB이름;
  mysql> create user 'username'@'%' identified by '비밀번호';
  mysql> grant all privileges on *.* to 'username'@'%' with grant option;
  mysql> flush privileges;
  mysql> select user. host from user;
  
  $ sudo systemctl status mysql
  $ sudo systemctl stop mysql
  $ sudo systemctl start mysql
  ```
  <br>

- ### java, node.js 설치   
  (프로젝트에서 사용한 버전에 따라 숫자 바꿔주면 됨)   
  - terminal   
  ```
  $ sudo apt-get install openjdk-11-jdk   
  $ curl -sL https://deb.nodesource.com/setup_18.x | sudo -E bash -   
  $ sudo apt-get install -y nodejs  
  ```
  * * *
  <br>
  
  
