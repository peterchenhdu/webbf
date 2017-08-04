import React from 'react'
import {Modal, Table, Icon, Form, Input, Button, Select, DatePicker } from 'antd';
import $ from 'jquery';          //jquery
const FormItem = Form.Item;
const Option = Select.Option;


import classNames from 'classnames';
const InputGroup = Input.Group;

const SearchInput = React.createClass({
  getInitialState() {
    return {
      value: '',
      focus: false,
    };
  },
  handleInputChange(e) {
    this.setState({
      value: e.target.value,
    });
  },
  handleFocusBlur(e) {
    this.setState({
      focus: e.target === document.activeElement,
    });
  },
  handleSearch() {
    if (this.props.onSearch) {
      this.props.onSearch(this.state.value);
    }
  },
  render() {
    const { style, size, placeholder } = this.props;
    const btnCls = classNames({
      'ant-search-btn': true,
      'ant-search-btn-noempty': !!this.state.value.trim(),
    });
    const searchCls = classNames({
      'ant-search-input': true,
      'ant-search-input-focus': this.state.focus,
    });
    return (
      <div className="ant-search-input-wrapper" style={style}>
        <InputGroup className={searchCls}>
          <Input placeholder={placeholder} value={this.state.value} onChange={this.handleInputChange}
            onFocus={this.handleFocusBlur} onBlur={this.handleFocusBlur} onPressEnter={this.handleSearch}
          />
          <div className="ant-input-group-wrap">
            <Button icon="search" className={btnCls} size={size} onClick={this.handleSearch} />
          </div>
        </InputGroup>
      </div>
    );
  },
});

let Demo = React.createClass({
  handleSubmit(e) {
    e.preventDefault();
    console.log('收到表单值：', this.props.form.getFieldsValue());
  },

  render() {
    const { getFieldProps } = this.props.form;
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 14 },
    };
    return (
      <Form horizontal onSubmit={this.handleSubmit}>
        <FormItem required id="sup-title" label="字段1" labelCol={{ span: 6 }} wrapperCol={{ span: 14 } }>
            <Input id="sup-title" placeholder="Please enter..." />
        </FormItem>

        <FormItem required id="sup-summary" label="字段2" labelCol={{ span: 6 }} wrapperCol={{ span: 14 }}>
            <Input id="sup-summary" placeholder="Please enter..." />
        </FormItem>

        <FormItem required id="sup-deadline" label="字段4" labelCol={{ span: 6 }} wrapperCol={{ span: 14 }} >
            <FormItem>
              <DatePicker {...getFieldProps('startDate')} />
            </FormItem>
        </FormItem>

        <FormItem required id="sup-dep" label="字段5" labelCol={{ span: 6 }} wrapperCol={{ span: 14 }}  >
          <Select style={{ width: 150 }} defaultValue="jack" >
            <Option value="jack">法规科</Option>
            <Option value="lucy">办公室</Option>
          </Select>
        </FormItem>

        <FormItem required id="sup-progress" label="字段6" labelCol={{ span: 6 }} wrapperCol={{ span: 14 }}>
            <Input id="sup-progress" placeholder="Please enter..." />
        </FormItem>

      </Form>
    );
  },
});

Demo = Form.create()(Demo);





export default class UserMgt extends React.Component{

  constructor(props){
    super(props);
    this.state={visible: false};

    this.columns = [{
      title: '字段1',
      dataIndex: 'title',
      key: 'title',
    }, {
      title: '字段2',
      dataIndex: 'summary',
      key: 'summary',
    }, {
      title: '字段3',
      dataIndex: 'startTime',
      key: 'startTime',
    }, {
      title: '字段4',
      dataIndex: 'deadline',
      key: 'deadline',
    }, {
      title: '字段5',
      dataIndex: 'progress',
      key: 'progress',
    }, {
      title: '字段6',
      dataIndex: 'state',
      key: 'state',
    }, {
      title: '操作',
      key: 'operation',
      render: (text, record) => (
        <span>
          <a href="javascript:void(0)" onClick={function(record){
            alert('用户id为' + record.key)
          }.bind(this, record)}>修改</a>
        </span>
      ),
    }];

    this.data = [];
    for(var i = 0; i < 60; i++){
      var tmp = {};
      tmp.key=(i+1)+"";
      tmp.title = (i+1)+"";
      tmp.summary = (i+1)+"";
      tmp.startTime = '2016-11-02 00:00:05';
      tmp.deadline = '2016-11-02 00:00:05';
      tmp.progress = i;
      tmp.state = i+'';
      this.data.push(tmp);
    }
    /*
    $.ajax({
     async: false,
      type : "post",
      url : "/dss/not/sup/getByState.do",
      data: {},
      datatype : 'json',
      success : function(data) {
        if(data != "faild"){
          for(var i = 0; i < data.length; i++){
            var tmp = {};
            tmp.key=(i+1)+"";
            tmp.title = data[i].title;
            tmp.summary = data[i].supAbstract;
            tmp.startTime = data[i].createTime;
            tmp.deadline = data[i].deadline;
            tmp.progress = data[i].schedule+"%";
            tmp.state = data[i].state;
            this.data.push(tmp);
          }
        }else{
          Modal.error({title: '请求失败！', content: '请求后端数据失败!'});
        }

      }.bind(this)
    });
*/

  }
  componentDidMount() {

  }



  showModal() {
    this.setState({
      visible: true,
    });
  }
  handleOk() {
    console.log('点击了确定');
    this.setState({
      visible: false,
    });
  }
  handleCancel(e) {
    console.log(e);
    this.setState({
      visible: false,
    });
  }


  render() {

    return (
      <div className="sup-body">
         <div style={{height:40}}>
          <span style={{float:"left"}}>
            <SearchInput placeholder="请输入字段1关键字" onSearch={value => console.log(value)} style={{ width: 300 }}/>
          </span>
          <span style={{float:"right"}}>
            <Button type="primary" onClick={this.showModal.bind(this)}>新增</Button>
          </span>
         </div>

         <Modal title="编辑督办" visible={this.state.visible} onOk={this.handleOk.bind(this)} onCancel={this.handleCancel.bind(this)}>
            <Demo />
          </Modal>
        <Table columns={this.columns} dataSource={this.data} size="middle" />
      </div>
    )
  }
}
