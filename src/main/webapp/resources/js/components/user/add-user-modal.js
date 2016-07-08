import React from 'react'
import Button from 'react-bootstrap/lib/Button'
import Modal from 'react-bootstrap/lib/Modal'
import Input from 'react-bootstrap/lib/Input';
import FormGroup from 'react-bootstrap/lib/FormGroup'
import ControlLabel from 'react-bootstrap/lib/ControlLabel'
import FormControl  from 'react-bootstrap/lib/FormControl'
import HelpBlock from 'react-bootstrap/lib/HelpBlock'
import ValidationUtil from '../../util/Validation-util'

export default class AddUserModal extends React.Component{
  constructor(props){
    super(props);
    this.state = {nameValue:"", addressValue:""}
  }

  handleChangeName(e) {
    //此处比较简单，省略了action
    this.setState({ nameValue: e.target.value })
  }

  handleChangeAddress(e) {
    this.setState({ addressValue: e.target.value });
  }

  render() {
    return (
      <Modal show={this.props.showAddUserModal} onHide={this.props.closeAddModalEvent}>
        <Modal.Header closeButton>
          <Modal.Title>新增用户</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <form>
          <FormGroup controlId="username" validationState={ValidationUtil.getValidationState(this.state.nameValue,5,3,0)}>
            <ControlLabel>名字</ControlLabel>
            <FormControl type="text" value={this.state.value} placeholder="Enter text" onChange={this.handleChangeName.bind(this)}/>
            <FormControl.Feedback />
            <HelpBlock>建议长度大于5个字符.</HelpBlock>
          </FormGroup>
          <FormGroup controlId="address" validationState={ValidationUtil.getValidationState(this.state.addressValue,5,3,0)}>
            <ControlLabel>地址</ControlLabel>
            <FormControl type="text" value={this.state.value} placeholder="Enter text" onChange={this.handleChangeAddress.bind(this)}/>
            <FormControl.Feedback />
            <HelpBlock>建议长度大于5个字符.</HelpBlock>
          </FormGroup>
        </form>
        </Modal.Body>
        <Modal.Footer>
          <Button bsStyle="primary" onClick={this.props.addUserEvent}>保存</Button>
          <Button onClick={this.props.closeAddModalEvent}>关闭</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}
