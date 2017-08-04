import Reflux from 'reflux'
import actions from '../../actions/user/user-actions.es6'
import $ from 'jquery';          //jquery


export default Reflux.createStore({
  init () {
       console.log("stores init.");
       //this.listenToMany(actions); 鏂规硶鍓嶉潰鍔爋n锛屽onHandleChange
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
        //鏇存柊state鐘舵�侊紙灏辨槸涓璞★級
        this.trigger({filterText:text});
    },
    getAllUser () {
      $.ajax({
         async: false,
          type : "get",
          url : "users",
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
          url : "users/" + userId,
          data: {},
          datatype : 'json',
          success : function(data) {

              alert("鍒犻櫎鎴愬姛");
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
          url : "users",
          data: JSON.stringify({name:userName,address:address}),
          datatype : 'json',
          success : function(data) {

              alert("鎿嶄綔鎴愬姛");
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
