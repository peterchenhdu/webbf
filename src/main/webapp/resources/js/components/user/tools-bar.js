import React from 'react'
import Button from 'react-bootstrap/lib/Button'

export default class ToolsBar extends React.Component{
  render() {
    return (
      <div className="tools-bar">
        <span>名字：</span><input type="text" placeholder="Search name..." value={this.props.filterText} onChange={this.props.filterTextChange}/>
        <Button onClick={this.props.addUserEvent} bsStyle="primary" bsSize="small" className="float-right">新增</Button>
      </div>
    );
  }
}
