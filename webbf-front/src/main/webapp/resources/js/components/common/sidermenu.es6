import { Menu, Icon } from 'antd';
import React from 'react'
const SubMenu = Menu.SubMenu;

export default class SiderMenu extends React.Component {
  constructor(props) {
    super(props);
    this.state={
      current: 'userMgt',
      openKeys: []
    };
  }

  handleClick(e) {
      window.location.hash = e.key;
      this.setState({
          current: e.key,
          openKeys: e.keyPath.slice(1)
      });
  }

  render() {
    return (
      <Menu onClick={this.handleClick.bind(this)}
        style={{ width: '100%' }}
        penKeys = {this.state.openKeys}
        theme={'light'}
        defaultOpenKeys={['sub2','sub4',"sub1"]}
        selectedKeys={[this.state.current]}
        mode="inline"
      >
        <SubMenu key="sub2" title={<span><Icon type="appstore" /><span>Echarts图表示例</span></span>}>
          <Menu.Item key="AreaStack">折线图</Menu.Item>
          <Menu.Item key="HeatmapCartesian">热力图</Menu.Item>
        </SubMenu>
        <SubMenu key="sub4" title={<span><Icon type="setting" /><span>增删改查</span></span>}>
          <Menu.Item key="userMgt">用户管理</Menu.Item>
          <Menu.Item key="10">选项10</Menu.Item>
          <Menu.Item key="11">选项11</Menu.Item>
          <Menu.Item key="12">选项12</Menu.Item>
        </SubMenu>
        <SubMenu key="sub1" title={<span><Icon type="mail" /><span>导航一</span></span>}>
          <Menu.Item key="1">选项1</Menu.Item>
          <Menu.Item key="2">选项2</Menu.Item>
          <Menu.Item key="3">选项3</Menu.Item>
          <Menu.Item key="4">选项4</Menu.Item>
        </SubMenu>
      </Menu>
    );
  }
}
