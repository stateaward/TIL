import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  /**
   * React.StrictMod : 리액트에서 레거시 기능을 사용하지 못하게 체크하는 옵션
   *  - ref, componentWillMount 등 나중에는 사라지게 될 기능을 사용했을 때, 경고 출력
   *  - 선언시, 일부 라이프사이클이 두번씩 호출됨(로컬에서만 그러며, 프로덕트 환경에선 이상 없음)
   */
  // <React.StrictMode>
    <App />
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
