// 강의 정리 : https://www.youtube.com/watch?v=xkpcNolC270
// 일반 선언
var 이름 = 'KIM';
// 타입 지정
// string, number, boolean, null, undefined, bigint, [], {}, ...
var 이름2 = 'KIM';
var names = ['KIM', 'PARK'];
var numbers = [132, 555];
// tel? : tel 속성은 들어올수도 있고, 안올수도 있고. 옵션이다!
var obj = { name: 'JO' };
// Union Type : 다양한 타입이 들어오는 경우
var 속성 = 123; // 문자배열 혹은 숫자가 들어온다!
var 붕어빵1 = { name: '슈크림', price: 2000, opt: 0 };
var 붕어빵2 = { name: '슈크림', price: 2000 };
var 장난감1 = { 축구공: 10000, 농구공: 20000, 탁구공: 400 };
var john = [123, true];
var mike = [123, true, 123];
// ==============================================================
// 함수 파라미터에 타입 지정
function func1(x) {
    return x * 2;
}
// 함수 파라미터 + 리턴값에 타입 지정
function func2(x) {
    return x * 2;
}
func1(123);
// ==============================================================
// class
var User = /** @class */ (function () {
    function User(name) {
        this.name = name;
    }
    return User;
}());
