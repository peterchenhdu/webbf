import './style/index.css'
import React from 'react'
import { Row, Col } from 'antd';
import SiderMenu from '../common/sidermenu'
import AreaStack from '../echarts/areastack'
import UserMgt from '../antd/usermgt'
import HeatmapCartesian from '../echarts/heatmapcartesian'

export default class Index extends React.Component{

  constructor(props){
    super(props);
  }

  render() {

    return (
			<div className="main-div">
        <Row>
          <Col span={24} offset={0}>
            <div className="main-top">Java Web工程Demo</div>
          </Col>
        </Row>
        <Row>
          <Col span={4} offset={0}>
            <SiderMenu location={this.props.location} />
          </Col>
          <Col span={20} >
            <div className="content-div">
              {this.props.children}
            </div>
          </Col>
        </Row>
			</div>
    );
  }
}
