// 강의 정리 : https://www.youtube.com/watch?v=xkpcNolC270

// 일반 선언
let 이름 = 'KIM';

// 타입 지정
// string, number, boolean, null, undefined, bigint, [], {}, ...
let 이름2: string = 'KIM';
let names: string[] = ['KIM', 'PARK'];
let numbers: number[] = [132, 555];

// tel? : tel 속성은 들어올수도 있고, 안올수도 있고. 옵션이다!
let obj: { name: string; tel?: number } = { name: 'JO' };

// Union Type : 다양한 타입이 들어오는 경우
let 속성: string[] | number = 123; // 문자배열 혹은 숫자가 들어온다!

// Type Alias : 타입이 길어? 미리 저장해!
type Obj1 = {
   // 정의한 type은 보통 대문자로
   name: string;
   price: number;
   opt?: string | number;
};
let 붕어빵1: Obj1 = { name: '슈크림', price: 2000, opt: 0 };
let 붕어빵2: Obj1 = { name: '슈크림', price: 2000 };

// Type Alias : 모든 속성값에 동일하게 지정할 때
type Obj2 = {
   // 모든 key는 string이고, 값은 number;
   [key: string]: number;
};
let 장난감1: Obj2 = { 축구공: 10000, 농구공: 20000, 탁구공: 400 };

// Tuple Type : array에 쓸 수 있는 속성!, array대로 해당 속성이 입력되어야 함.
type Member = [number, boolean]; // 처음엔 number, 그리고 boolean | 사이즈는 2
let john: Member = [123, true];
let mike: Member = [123, true, 123];

// ==============================================================

// 함수 파라미터에 타입 지정
function func1(x: number) {
   return x * 2;
}

// 함수 파라미터 + 리턴값에 타입 지정
function func2(x: number): number {
   return x * 2;
}

func1(123);

// ==============================================================

// class
class User {
   name: string;
   constructor(name: string) {
      this.name = name;
   }
}
