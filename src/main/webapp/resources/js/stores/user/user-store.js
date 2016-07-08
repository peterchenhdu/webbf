import Reflux from 'reflux'
import actions from '../../actions/user/user-actions'
import $ from 'jquery';          //jquery


export default Reflux.createStore({
  init () {
       console.log("stores init.");
       //this.listenToMany(actions); 方法前面加on，如onHandleChange
       this.listenTo(actions.handleChange, 'handleChange');
       this.listenTo(actions.getAllUser, 'getAllUser');
       this.listenTo(actions.deleteUser, 'deleteUser');
       this.listenTo(actions.addUser, 'addUser');
       this.listenTo(actions.openAddModal, 'openAddModal');
       this.listenTo(actions.setStateValue, 'setStateValue');
   },
   setStateValue(value){
     this.trigger(value);
   },
    handleChange (text) {
        //更新state状态（就是个对象）
        this.trigger({filterText:text});
    },
    getAllUser () {
      $.ajax({
         async: false,
          type : "post",
          url : "/webbf/user/getUserList.do",
          data: {pageNo:0,pageSize:100},
          datatype : 'json',
          success : function(data) {
            this.trigger({userList:data.userList});
          }.bind(this)
        });

    },
    deleteUser(userId){
      $.ajax({
         async: false,
          type : "post",
          url : "/webbf/user/deleteUser.do",
          data: {userId:userId},
          datatype : 'json',
          success : function(data) {
            if(data="sucess"){
              alert("删除成功");
              this.getAllUser();
            }else{
              alert("删除失败");
            }

          }.bind(this)
        });
    },
    addUser(userName, address){
      $.ajax({
         async: false,
          type : "post",
          url : "/webbf/user/saveUserTest.do",
          data: {userName:userName,address:address},
          datatype : 'json',
          success : function(data) {
            if(data="sucess"){
              alert("操作成功");
              this.openAddModal(false);
              this.getAllUser();
            }else{
              alert("操作失败");
            }
          }.bind(this)
        });

    },
    openAddModal(showFlag){
      this.trigger({showAddUserModal:showFlag});
    }
});
