## Springboot(Gradle) + React 프로젝트 AWS 배포하기
- EC2 활용
- Lightsail 활용한 내용은 [링크]() 참고
<br>

* * *
<br>

- Springboot(Gradle) 빌드
  - cmd   
  ```
  스프링부트 파일의 디렉토리로 이동
  
  [스프링부트 파일 빌드]
  #./gradlew build

  해당 폴더\build\libs 디렉토리 이동하여.jar 파일 생성 확인
  
  [.jar 실행]
  (해당 폴더\build\libs 에서 실행)
  #java -jar 방금 생성된 .jar 파일명.jar 입력하여 실행

  [종료]
  ctrl +c 
  ```
 <br>

- React 빌드
  - cmd
  ```
  스프링부트 파일의 디렉토리로 이동

  [리액트 파일 빌드]
  #npm run build
  
  해당 폴더\build 디렉토리 파일 생성 확인
  ```
<br>

- React 빌드 참고
  - 에러내용   
  ```
  Creating an optimized production build...
  Failed to compile.

  Module not found: Error: Can't resolve '@ckeditor/ckeditor5-build-classic' in 'C:\bitacademy-bigdata-ai\eclipse-workspace\aws\CocktailprojectFront\src\board'
  ```

- 해결방법
  ```   
  package.json에 "dependencies"에 '@ckeditor/ckeditor5-build-classic' 관련 내용 확인
  
  [위 내용 있으면 다시 빌드]
  #npm run build
  
  불가 시 node_modules 삭제
  
  #npm run build 재실행
  #npm install
  ```

- 추가내용   
  React 빌드 후 index.html이 공백 없는 것으로 확인될텐데 정상임!!
  
  <br>
  
  * * *
  <br>
  
  
