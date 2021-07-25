# TypeScript

## What Is `TypeScript`?

자바스크립트의 대용품. 문법은 동일하나, 타입부분이 엄격하게 정의됨

-  타입을 엄격히 검사해줌
-  에러 메세지가 더욱 명확해짐

> **자바스크립트** : 다이나믹 타이핑(dynamic typing)을 가능
>
> > ```
> > //dynamic typing
> > 5 - '3' 은 원래 안되지만, JS에선 자동으로 형변환을 해줌
> > ```
>
> -  프로젝트 볼륨이 커질수록 이렇게 `자유도`, `유연성`이 높은게 프로젝트의 무결성을 헤칠 수 있음

## How to Use

### Install

1. node.js 최신 버젼 다운로드
   1. 홈페이지에서 다운 받기
   2. **npm으로 업데이트하기**
      1. 현재 버젼 확인 `node -v`
      2. 강제 캐시 삭제 `npm cache clean -f`
      3. node.js 버젼 관리하는 n 모듈 설치 `sudo npm install -g n`
      4. n 모듈로 node.js 설치
         ```
         sudo n stable : 안정 버전
         sudo n latest : 최신 버전
         sudo n lts : LTS 버전(Long Term Support)
         sudo n x.x.x : 특정 x.x.x 버전
         ```
2. 전역에 typescript 설치하기 `sudo npm install -g typescript`
3. `AAA.ts` 파일 만들기
4. `tsconfing.json` 파일 만들고, 아래 내용 넣기
   ```
   {
    "compilerOptions" : {
        "target": "es5",
        "module": "commonjs",
    }
   }
   ```

### Usage

브라우저에선 `.ts` 파일을 못읽음.  
따라서, VSCode 명령어로 `tsc -w` 을 입력하면 자동으로 `.js` 파일로 컴파일됨(실시간)

이때 `tsconfig.json`의 설정대로 컴파일이 진행됨
