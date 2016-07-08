import React from 'react'

export default class SpanItem extends React.Component{
  render() {
    return (
      <span>{this.props.value}</span>
    );
  }
}
