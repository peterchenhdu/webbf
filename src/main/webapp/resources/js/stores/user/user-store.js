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
          type : "get",
          url : "/webbf/users",
          data: {},
          datatype : 'json',
		  
          success : function(data,textStatus) {
            this.trigger({userList:data});
          }.bind(this),
		  
		  error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
		  }

        });

    },
    deleteUser(userId){
      $.ajax({
         async: false,
          type : "delete",
          url : "/webbf/users/" + userId,
          data: {},
          datatype : 'json',
          success : function(data) {

              alert("删除成功");
              this.getAllUser();
 
          }.bind(this),
		  
		  error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
		  }
        });
    },
    addUser(userName, address){
      $.ajax({
         async: false,
		 contentType: "application/json; charset=utf-8",
          type : "post",
          url : "/webbf/users",
          data: JSON.stringify({name:userName,address:address}),
          datatype : 'json',
          success : function(data) {

              alert("操作成功");
              this.openAddModal(false);
              this.getAllUser();
  
          }.bind(this),
		  
		  error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
		  }
        });

    },
    openAddModal(showFlag){
      this.trigger({showAddUserModal:showFlag});
    }
});
