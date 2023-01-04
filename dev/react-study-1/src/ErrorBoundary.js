import React, { Component } from 'react';

class ErrorBoundary extends Component {
  state = {
    error: false
  };

  // v16에 도입된 메소드
  // 랜더링 도중 에러 발생하였을 시 처리
  componentDidCatch(error, info) {
    this.setState({
      error: true
    });
    console.log({ error, info });
  }
  
  render() {
    if (this.state.error) return <div>에러가 발생했습니다!</div>;
    return this.props.children;
  }
}

export default ErrorBoundary;