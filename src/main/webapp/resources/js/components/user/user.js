import React from 'react'
import SpanItem from './span-item'
import Button from 'react-bootstrap/lib/Button'

export default class User extends React.Component{
  render() {
    return (
			<div className="user-box">
  			<SpanItem value={this.props.id} />
  			<SpanItem value={this.props.name} />
  			<SpanItem value={this.props.address} />
        <Button bsSize="small" bsStyle="danger" onClick={this.props.handleDeleteUser}>删除</Button>
			</div>
    );
  }
}
