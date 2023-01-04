// 클래스형 컴포넌트
// state 자체 사용 가능

import React, {Component} from 'react';

class Counter extends Component{
    /**
     * 1) 생성자를 사용해서 초기값 셋팅 방법
        constructor(props){
            super(props);
            // state 초깃값 셋팅
            this.state = {
                number: 0,
                fixedNumber : 100
            }
        };
    */
   
    // 2) 생성자 없이 사용하기
    state = {
        number : 0,
        fixedNumber : 100
    };

    render(){
        const {number, fixedNumber} = this.state;
        return (
            <div>
                <h1>{number}</h1>
                <h2>바뀌지 않는 값 : {fixedNumber}</h2>
                {/* 리액트에서 이벤트는 카멜케이스로! HTML에선 그냥 onclick인데, 리액트에선 onClick 이다! */}
                <button 
                    onClick={()=>{
                        this.setState({number : number + 1}, ()=>{console.log('setState가 실행되었습니다 \n', this.state)});
                        // 2) prevState를 통해 기존 상태를 가져와서 바로 동기 처리
                        // this.setState(prevState => {
                        //     return {number : prevState.number +1}
                        // });
                        // this.setState(prevState => ({number : prevState.number +1}));
                    }}>
                    +1
                </button>
            </div>
        );
    }
}

export default Counter;