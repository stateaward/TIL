import React, {useState, useEffect} from "react";

const Info = () => {
    const [name, setName] = useState('');
    const [nickname, setNickname] = useState('');

    /**
     * useEffect
     * - 컴포넌트가 *랜더링 될 때마다 작업 수행
     *  - props 변경
     *  - state 변경
     *  - 부모 컴포넌트의 리랜더링
     *  - 강제 랜더링 트리거 시
     * - 함수형의 componentDidMount + componentDidUpdate의 형태
     *  - 마운트 되었거나, 업데이트 되었거나
     * 
     * useEffect(callback, [검사값배열]);
     *  - 검사값배열 존재 시 : 해당 값이 변경시에만 callback을 실행함
     *  - 빈 배열? -> 검사 false -> 랜더링 X -> 최초 Mount에만 실행
     * 
     * 
     */
    useEffect(() => {
        console.log('effect : 랜더링 완료');
        console.log(name);
        return () => {
            console.log('cleanup => ' + name)
        };
    }, [name])
    

    const onChangeName = e => {
        setName(e.target.value);
    };

    const onChangeNickname = e => {
        setNickname(e.target.value);
    };

    return (
        <div>
            <div>
                <input value={name} onChange={onChangeName} />
                <input value={nickname} onChange={onChangeNickname} />
            </div>
            <div>
                <div>
                    <b>이름 : </b> {name}
                </div>
                <div>
                    <b>닉네임 : </b> {nickname}
                </div>
            </div>
        </div>
    );
}

export default Info;
