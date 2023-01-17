// 함수형 컴포넌트
import React, {useState} from 'react'

const EventPractice2 = () => {
  const [form, setForm] = useState({
    username: '',
    message: ''
  });
  const {username, message} = form;
  // const [username, setUsername] = useState('기본유저');
  // const [message, setMessage] = useState('기본메세지');

  // const onChangeUsername = e => setUsername(e.target.value);
  // const onChangeMessage = e => setMessage(e.target.value);
  // const onClick = ()=>{
  //   alert(username + ' : ' + message);
  //   setUsername('');
  //   setMessage('');
  // };

  const onChange = e => {
    const nextForm = {
      ...form,
      [e.target.name]: e.target.value
    }
    setForm(nextForm);
  }

  const onClick = ()=>{
    alert(username + ' : ' + message);
    setForm({
      username: '',
      message: ''
    });
  };

  const onKeyPress = e => {
    if(e.key === 'Enter'){
      onClick();
    }
  };

  return (
    <div>
      <h1>이벤트 연습2</h1>
      <input
          type="text"
          name="username"
          placeholder="사용자명"
          value={username}
          onChange={onChange}
      />
      <input
          type="text"
          name="message"
          placeholder="아무거나 입력해보세요"
          value={message}
          onChange={onChange}
          onKeyPress={onKeyPress}
      />

      <button onClick={onClick}>확인하기</button>
  </div>
  )
}

export default EventPractice2