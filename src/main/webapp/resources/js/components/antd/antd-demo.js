import React from 'react'
import { Calendar } from 'antd';
import { Switch } from 'antd';
import { Rate } from 'antd';
import { Progress } from 'antd';

export default class AntdDemo extends React.Component{
  constructor(props){
    super(props);
    this.state = {}
  }


  render() {
    return (
      <div>
        <div className="antd-calendar">
          <Calendar />
        </div>
        <div className="antd-ib">
          <Switch defaultChecked={true} />
        </div>
        <div className="antd-ib">
          <Rate allowHalf defaultValue={2.5} />
        </div>
        <div className="antd-ib">
          <Progress type="circle" percent={30} width={80} />
          <Progress type="circle" percent={70} width={80} status="exception" />
          <Progress type="circle" percent={100} width={80} />
        </div>
      </div>
    );
  }
}
