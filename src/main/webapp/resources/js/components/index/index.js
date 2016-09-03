import './style/index.css'
import React from 'react'
import { Row, Col } from 'antd';
import SiderMenu from '../common/sidermenu.js'



export default class Index extends React.Component{

  constructor(props){
    super(props);
    this.state = {}
  }

  render() {
    return (
			<div className="main-div">
        <Row>
          <Col span={20} offset={2}>
            <div className="main-top">测试</div>
          </Col>
        </Row>
        <Row>
          <Col span={4} offset={2}>
            <SiderMenu />
          </Col>
          <Col span={16} >
            <div>
              内容
            </div>
          </Col>
        </Row>
			</div>
    );
  }
}
