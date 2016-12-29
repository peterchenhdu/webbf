import React from 'react'
import echarts from 'echarts'
import $ from 'jquery';          //jquery

export default class AreaStack extends React.Component{

  constructor(props){
    super(props);
    this.chartData = {};
    $.ajax({
     async: false,
      type : "get",
      url : "/webbf/addatas",
      data: {},
      datatype : 'json',
      success : function(data) {

		  this.chartData.emailList = data.emailList;
		  this.chartData.allianceList = data.allianceList;
		  this.chartData.vedioList = data.vedioList;
		  this.chartData.directList = data.directList;
		  this.chartData.searchList = data.searchList;
		  this.chartData.xTitleList = data.xTitleList;

      }.bind(this),
	  error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
	  }
    });

  }
  autoResize() {
    var areastack = document.getElementById('areastack-chart');
    areastack.style.width = '100%';
    areastack.style.height = '500px';
  }


  componentDidMount() {
    this.autoResize();
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('areastack-chart'));
    // 绘制图表
    myChart.setOption({
        title: {
            text: '1小时访问来源堆积图'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : this.chartData.xTitleList
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'邮件营销',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:this.chartData.emailList
            },
            {
                name:'联盟广告',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:this.chartData.allianceList
            },
            {
                name:'视频广告',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:this.chartData.vedioList
            },
            {
                name:'直接访问',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:this.chartData.directList
            },
            {
                name:'搜索引擎',
                type:'line',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                areaStyle: {normal: {}},
                data:this.chartData.searchList
            }
        ]
    });
    window.onresize = function () {
        this.autoResize();
        myChart.resize();
    }.bind(this);
  }

  render() {
    return (
			<div id = "areastack-chart">
			</div>
    );
  }
}
