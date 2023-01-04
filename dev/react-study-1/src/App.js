// import MyComponent from './MyComponent';
// import MyComponent2 from './MyComponent2';
// import Counter from './Counter';
// import Say from './Say';
// import EventPractice2 from "./EventPractice2";

// import ValidationSample from './ValidationSample';

/*
import ScrollBox from './ScrollBox'
import IterationSample from './IterationSample'

      <div>
        <ScrollBox ref={ref => this.ScrollBox = ref}></ScrollBox>
        <button onClick={()=>{this.ScrollBox.scrollToBottom()}}>맨 밑으로 이동</button>
        <button onClick={()=>{this.ScrollBox.scrollToTop()}}>맨 위로 이동</button>
        <br/>
        <IterationSample></IterationSample>
      </div>
*/

import React, { Component } from 'react'
import ErrorBoundary from './ErrorBoundary';
import LifeCycleSample from './LifeCycleSample'

function getRandomColor() {
  return '#' + Math.floor(Math.random() * 16777215).toString(16)
};

export default class App extends Component {
  state = {
    color : '#000000'
  }

  handleClick = () => {
    this.setState({
      color : getRandomColor()
    });
  };

  render() {
    return (
      <div>
        <button onClick={this.handleClick}>랜덤 색상</button>
        <ErrorBoundary>
          <LifeCycleSample color={this.state.color} />
        </ErrorBoundary>
      </div>
    )
  }
}

/*
함수형 컴포넌트
const App = ()=>{
  return (
    <>
      <MyComponent name="개똥이" favorNumber={1}>말랑이</MyComponent>
      <MyComponent2 favorNumber={199000}>쇠삥</MyComponent2>
      <Counter></Counter>
      <Say></Say>

      <EventPractice2></EventPractice2>
    </>
  );
};

export default App;
*/
