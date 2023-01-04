import React, { Component } from 'react'

class EventPractice extends Component {
    state = {
        username: '',
        message: ''
    }

    /**
     * 클래스형에서 임의 메소드 등록하는 방법
     * 1. 생성자를 통해, this에다가 이벤트를 바인딩하기
     */
    /*
    constructor(props){
        super(props);
        this.handelChange = this.handelChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handelChange(e){
        this.setState({
            message : e.target.value
        });
    }

    handleClick(){
        alert(this.state.message);
        this.setState({
            message:''
        });
    }
    */

    /**
     * 2. 바벨의 클래스 속성 변환 문법 활용하여 정의하기
     */
    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleClick = () => {
        alert(this.state.username + ' : ' + this.state.message);
        this.setState({
            username: '',
            message:''
        });
    }

    handleKeyPress = (e) => {
        if(e.key === 'Enter'){
            this.handleClick();
        }
    }

    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type="text"
                    name="username"
                    placeholder="사용자명"
                    value={this.state.username}
                    onChange={this.handleChange}
                />
                <input
                    type="text"
                    name="message"
                    placeholder="아무거나 입력해보세요"
                    value={this.state.message}
                    onChange={this.handleChange}
                    onKeyPress={this.handleKeyPress}
                />

                <button onClick={this.handleClick}>확인하기</button>
            </div>
        )
    }
}

export default EventPractice;