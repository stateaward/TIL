import React, { Component } from 'react'

export default class ScrollBox extends Component {
    scrollToBottom = ()=>{
        const { scrollHeight, clientHeight } = this.box;    // ref를 통해 DOM을 걸고, 비구조화할당으로 할당

        this.box.scrollTop = scrollHeight - clientHeight;
    };

    scrollToTop = ()=>{
        const {clientHeight} = this.box;
        alert(`현재 높이는 ${clientHeight}px 입니다.`);
        this.box.scrollTop = 0;
    };

    render() {
        const style={
            border: '1px solid black',
            height: '300px',
            width: '300px',
            overflow: 'auto',
            position: 'relative'
        };

        const innerStyle={
            width: '100%',
            height: '650px',
            background: 'linear-gradient(white,black)'
        };

        return (
            <div
            style={style}
            ref={ref => {this.box=ref}}
            >
            <div style={innerStyle}></div>
            </div>
        )
    }
}
