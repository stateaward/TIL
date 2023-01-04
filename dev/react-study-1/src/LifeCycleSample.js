import React, { Component } from "react";

export default class LifeCycleSample extends Component {
    state = {
        number: 0,
        color: null
    }
    myRef = null; // ref 설정

    // [컴포넌트 마운트 1] 최초 실행
    // 부모 컴포넌트에서 주는 props를 받음
    constructor(props){
        super(props);
        console.log('constructor');
    }

    // [컴포넌트 마운트 2] props 값을 state에 넣을 때 사용
    // [컴포넌트 업데이트 1] 업데이트 시작 전에 호출, props의 변화에 따라 state에도 변화 줄 때 사용
    static getDerivedStateFromPops(nextProps, prevState){
        console.log('getDerivedStateFromPops');
        if(nextProps.color !== prevState.color){
            return {color : nextProps.color}
        }
        return null;
    }

    // [컴포넌트 마운트 4] 웹 브라우저에 나타난 후 호출
    componentDidMount(){
        console.log('componentDidMount')
    }

    // [컴포넌트 업데이트 2] 컴포넌트의 리랜더링을 결정
    // true: 당음 라이프 사이클(render ...) 실행 || false:작업 중지->업데이트 X
    shouldComponentUpdate(nextProps, nextState){
        console.log('shouldComponentUpdate', nextProps, nextState);
        return nextState.number % 10 !==4;
    }

    // [컴포넌트 언마운트] 컴포넌트 사라지기 전에 호출
    componentWillUnmount() {
        console.log('componentWillUnmount')
    }

    handleClick = () => {
        this.setState({
            number: this.state.number + 1
        });
    };

    // [컴포넌트 업데이트 4] 컴포넌트 변화를 DOM에 반영하기 바로 직전 단계
    // -> 이거 이후 바로 브라우저상 실제 DOM 변화
    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getSnapshotBeforeUpdate');
        if (prevProps.color !== this.props.color) {
            return this.myRef.style.color;
        }
        return null;
    }

    // [컴포넌트 업데이트 5] 컴포넌트 업데이트 작업 끝난 후 호출
    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('componentDidUpdate', prevProps, prevState);
        if (snapshot) {
            console.log('업데이트되기 직전 색상: ', snapshot);
        }
    }

    // [컴포넌트 마운트 3/업데이트 3] UI를 랜더링
    render() {
        console.log('render');
        const style = {
            color: this.props.color
        };
        return (
            <div>
                {this.props.missing.value}
                <h1 style={style} ref={ref => (this.myRef = ref)}>
                    {this.state.number}
                </h1>
                <p>color: {this.state.color}</p>
                <button onClick={this.handleClick}>더하기</button>
            </div>
        );
    }
}
