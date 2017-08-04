import React from 'react'
import Reflux from 'reflux'
import ReactMixin from 'react-mixin'
import ToolsBar from './tools-bar.es6'
import AddUserModal from './add-user-modal.es6'
import User from './user.es6'
import store from '../../stores/user/user-store.es6'
import actions from '../../actions/user/user-actions.es6'
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
    //搴旇鍏堝垽鏂緭鍏ユ牎楠屾槸鍚︽垚鍔燂紝姝ゅ鐪佺暐
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
      rows.push(<p>鏃犳煡璇㈢粨鏋�.</p>);
    }

    return (
      <div className="user-mgtbox">
         <AddUserModal showAddUserModal={this.state.showAddUserModal} closeAddModalEvent = {this.closeAddModal} addUserEvent={this.addUser}/>

         <ToolsBar filterText={this.state.filterText} filterTextChange={this.handleChange} addUserEvent={this.openAddModal}/>

         <div className="user-box w700"><span>ID</span><span>鍚嶅瓧</span><span>鍦板潃</span><span>鎿嶄綔</span></div>
         {rows}
      </div>
    );
  }
}

// ES6 mixin鍐欐硶锛岄�氳繃mixin灏唖tore鐨勪笌缁勪欢杩炴帴锛屽姛鑳芥槸鐩戝惉store甯︽潵鐨剆tate鍙樺寲骞跺埛鏂板埌this.state
ReactMixin.onClass(UserMgt, Reflux.connect(store));
