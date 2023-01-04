// 클래스형 컴포넌트
import React, {Component} from 'react';
import PropTypes from 'prop-types';

class MyComponent2 extends Component {
    render(){
        const {name, children, favorNumber} = this.props;
        return (
            <>
                <div>
                    안녕하세요, 제 이름은 {name} 입니다. <br />
                    children 값은, {children} 입니다.
                </div>
                <div>
                    가장 좋아하는 숫자는 {favorNumber} 입니다.
                </div>
            </>
        );
    };
};

MyComponent2.defaultProps = {
    name : '호동이',
    children : '홍구',
};

MyComponent2.propTypes = {
    name : PropTypes.string,
    favorNumber : PropTypes.number.isRequired,
};

export default MyComponent2;