import PropTypes from 'prop-types';

/*
    props 가 아니라, foo 라고 지정해도 동일하게 props의 역할을 수행함
    결국 props라고 입력하는 것이 중요한게 아닌,
    컴포넌트로 선언한 함수의 "첫 파라미터가 props의 역할"을 수행하는 것
    
    const MyComponent = (foo)=>{
        return <div>안녕하세요, 제 이름은 {foo.name} 입니다.</div>
    };
 */
const MyComponent = ({name, children, favorNumber}) => {
    // 비구조화 할당(ES6) : 객체 내용을 뜯어옴
    // 미사용시, {props.name} 처럼 파라미터 값 계속 써야함
    // const {name, children} = props;
    return (
        <>
            <div>
                안녕하세요, 제 이름은 {name} 입니다. <br />
                children 값은, {children} 입니다.
            </div>
            <div>
                가장 좋아하는 숫자는 {favorNumber} 입니다.
            </div>
        </>
    );
};

MyComponent.defaultProps = {
    name : '호동이',
    children : '홍구',
};

MyComponent.propTypes = {
    name : PropTypes.string,
    favorNumber : PropTypes.number.isRequired,
};

export default MyComponent;