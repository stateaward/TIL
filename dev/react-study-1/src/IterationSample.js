import React, {useState} from 'react'

const IterationSample = () => {
    const [names, setNames] = useState([
        {id : 1, text : '눈사람'},
        {id : 2, text : '얼음'},
        {id : 3, text : '눈'},
        {id : 4, text : '사람'},
    ]);
    const [inputText, setInputText] = useState('');
    const [nextId, setNextId] = useState(5);

    const onChange = e => setInputText(e.target.value);
    
    const onClick = () => {
        // console.log(names);
        const nextNames = names.concat({id:nextId, text:inputText});
        setNextId(nextId+1);
        setNames(nextNames);
        setInputText('');
    };

    const onKeyDown = e => {
        // console.log(e.key);
        if(e.key==='Enter'){
            onClick();
        }
    };

    const onRemove = id => {
        // 필터링을 해서, 해당 값이 없는 신규 배열로 대체하는 방식
        const nextNames = names.filter(name => name.id !== id);
        setNames(nextNames);
    };

    const namesList = names.map(name => (
        <li key={name.id} onDoubleClick={()=>onRemove(name.id)}>{name.text}</li>
    ));
    return (
        <>
            <input value={inputText} onChange={onChange} onKeyDown={onKeyDown}/>
            <button onClick={onClick}>추가</button>
            <ul>{namesList}</ul>
        </>
    );
}

export default IterationSample;