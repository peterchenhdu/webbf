import '../css/chart/chart.css';  
import React from 'react';
import ReactDOM from 'react-dom';
import ChartDemo from './components/chart/chart-demo';



ReactDOM.render(
  <div>
    <h1>图表示例</h1>
    <ChartDemo />
  </div>,
  document.getElementById('chart-div')
);
