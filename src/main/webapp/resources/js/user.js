import '../css/user/user.css';              //css
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';    //css
import React from 'react';
import ReactDOM from 'react-dom';
import UserMgt from './components/user/user-mgt';
import $ from 'jquery';          //jquery


ReactDOM.render(
  <div>
    <h1>用户管理 demo示例</h1>
    <UserMgt />
  </div>,
  document.getElementById('user-mgt')
);
