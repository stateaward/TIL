import React, {useState} from 'react'

const Counter = ()=>{
    // useState() : 하나의 상태 값만 관리 가능 -> 값을 객체 형태로 묶는 등 처리
    const [value, setValue] = useState(0);

    return (
        <div>
            <p>
                현재 카운터 값은 <b>{value}</b> 입니다.
            </p>
            <button onClick={()=>{setValue(value + 1)}}>+1</button>
            <button onClick={()=>{setValue(value - 1)}}>-1</button>
        </div>
    )
}

export default Counter;