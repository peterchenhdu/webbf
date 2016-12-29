import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/index/index';
import { Router, Route, Link, hashHistory, IndexRoute } from 'react-router';
import SiderMenu from './components/common/sidermenu'
import AreaStack from './components/echarts/areastack'
import UserMgt from './components/antd/usermgt'
import HeatmapCartesian from './components/echarts/heatmapcartesian'


ReactDOM.render((
    <Router history={hashHistory}>
        <Route path="/" component={Index}>
            <IndexRoute component={UserMgt} />
            <Route path="AreaStack" component={AreaStack} />
            <Route path="HeatmapCartesian" component={HeatmapCartesian} />
            <Route path="userMgt" component={UserMgt} />
        </Route>
    </Router>
), document.getElementById("main"));
