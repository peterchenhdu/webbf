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
    this.state = {current:'AreaStack'}
  }

  handleClick(e) {
    console.log('click ', e);
    this.setState({
      current: e.key
    });
    //alert(e.key);
  }

  render() {

    var content;
    switch (this.state.current) {
      case 'AreaStack':
        content = <AreaStack />;
        break;
      case 'HeatmapCartesian':
        content = <HeatmapCartesian />;
        break;
      case 'userMgt':
        content = <UserMgt />;
        break;
      default:
        content = <AreaStack />;
    }



    return (
			<div className="main-div">
        <Row>
          <Col span={20} offset={2}>
            <div className="main-top">Java Web工程Demo</div>
          </Col>
        </Row>
        <Row>
          <Col span={4} offset={2}>
            <SiderMenu clickEvent={this.handleClick.bind(this)} current={this.state.current}/>
          </Col>
          <Col span={16} >
            <div className="content-div">
              {content}
            </div>
          </Col>
        </Row>
			</div>
    );
  }
}
