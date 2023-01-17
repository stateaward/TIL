import React, { useState, useMemo } from 'react';

const getAverage = numbers => {
    console.log('평균값 계산중...')
    if(numbers.length === 0) return 0;
    const sum = numbers.reduce((a, b) => a + b);
    return sum / numbers.length;
};

const Average = () => {
    const [list, setList] = useState([]);
    const [number, setNumber] = useState('');

    const onChane = e => {
        setNumber(e.target.value);
    };

    const onInsert = e => {
        const nextList = list.concat(parseInt(number));
        setList(nextList);
        setNumber('');
    };

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