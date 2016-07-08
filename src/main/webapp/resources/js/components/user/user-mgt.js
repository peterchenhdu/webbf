import React from 'react'
import Reflux from 'reflux'
import ReactMixin from 'react-mixin'
import ToolsBar from './tools-bar'
import AddUserModal from './add-user-modal'
import User from './user'
import store from '../../stores/user/user-store'
import actions from '../../actions/user/user-actions'
import $ from 'jquery'          //jquery

export default class UserMgt extends React.Component{
  constructor(props){
    super(props);
    this.state = {userList: [],  filterText:"", showAddUserModal:false}
  }

  handleChange(event) {
    actions.handleChange(event.target.value);
  }

  handleDeleteUser(event) {
    actions.deleteUser($(event.target).parent().find("span:first").text());
  }

  componentDidMount() {
    actions.getAllUser();
  }

  addUser(){
    //应该先判断输入校验是否成功，此处省略
    actions.addUser($("#username").val(), $("#address").val());

  }

  closeAddModal() {
    actions.openAddModal(false);
  }

  openAddModal() {
    actions.openAddModal(true);
  }


  render() {
    var rows = [];
    var userList = this.state.userList;
    for(var i = 0; i < userList.length; i++){
      if(userList[i].name.indexOf(this.state.filterText) == -1){
        continue;
      }
      rows.push(<User id={userList[i].id} name={userList[i].name} address={userList[i].address} handleDeleteUser={this.handleDeleteUser}/>);
    }
    if(rows.length == 0 && this.state.filterText!=""){
      rows.push(<p>无查询结果.</p>);
    }

    return (
      <div className="user-mgtbox">
         <AddUserModal showAddUserModal={this.state.showAddUserModal} closeAddModalEvent = {this.closeAddModal} addUserEvent={this.addUser}/>

         <ToolsBar filterText={this.state.filterText} filterTextChange={this.handleChange} addUserEvent={this.openAddModal}/>

         <div className="user-box w700"><span>ID</span><span>名字</span><span>地址</span><span>操作</span></div>
         {rows}
      </div>
    );
  }
}

// ES6 mixin写法，通过mixin将store的与组件连接，功能是监听store带来的state变化并刷新到this.state
ReactMixin.onClass(UserMgt, Reflux.connect(store));
