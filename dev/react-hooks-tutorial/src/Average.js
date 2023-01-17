import React, { useState, useMemo, useCallback } from 'react';

// 로직(계산용)
const getAverage = numbers => {
    console.log('평균값 계산중...')
    if(numbers.length === 0) return 0;
    const sum = numbers.reduce((a, b) => a + b);
    return sum / numbers.length;
};

const Average = () => {
    const [list, setList] = useState([]);
    const [number, setNumber] = useState('');

    // 컴포넌트가 리랜더링 될 때마다, onChane/onInsert 함수가 새로 만들어짐
    // useCallback(함수, [검사값]);
    const onChane = useCallback(e => {
        console.log('onChane!')
        setNumber(e.target.value);
    }, []); // 빈 검사값 배열 : 처음 랜더링 될 때만 -> 새로운 함수 사용!

    const onInsert = useCallback(e => {
        console.log('onInsert!')
        const nextList = list.concat(parseInt(number));
        setList(nextList);
        setNumber('');
    }, [number, list]); // number || list 값이 변했을 때만 -> 새로운 함수 사용!

    // 검사값 배열에 있는 list가 변경될 때만, 함수를 실행한다
    const avg = useMemo(() => getAverage(list) ,[list]);

    return (
        <div>
            <input value={number} onChange={onChane} />
            <button onClick={onInsert}>등록</button>
            <ul>
                {list.map((value, index) => (
                    <li key={index}>{value}</li>
                ))}
            </ul>
            <div>
                {/* <b>평균값:</b> {getAverage(list)} */}
                <b>평균값:</b> {avg}
            </div>
        </div>
    );
}

export default Average;