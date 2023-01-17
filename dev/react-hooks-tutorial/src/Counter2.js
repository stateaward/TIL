import React, {useReducer} from 'react'

// 리듀서 사용시, 로직을 컴포넌트 바깥으로 선언 가능
function reducer(state, action) {
    // action.type 별로 다른 작업을 수행 예정
    switch(action.type){
        case 'UP':
            return {value : state.value + 1};
        case 'DOWN':
            return {value : state.value - 1};
        default:
            // 지정된 타입이 아닐 경우, 그냥 현재 값 반환
            return state;
    }
};

const Counter = ()=>{    
    /*
        Reducer 사용 시, 두개의 값 반환
        - state : 현재 가르키는 상태
        - dispatch : 액션을 발생하는 함수(이걸로 앞서 선언한 리듀서를 실행)
    */
    const [state, dispatch] = useReducer(reducer, {value:0})
    
    return (
        <div>
            <p>
                현재 카운터 값은 <b>{state.value}</b> 입니다.
            </p>
            <button onClick={()=>{dispatch({type:'UP'})}}>+1</button>
            <button onClick={()=>{dispatch({type:'DOWN'})}}>-1</button>
        </div>
    )
}

export default Counter;