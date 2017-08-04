import React from 'react';
import ReactDOM from 'react-dom';
import Index from './components/index/index.es6';
import { Router, Route, Link, hashHistory, IndexRoute } from 'react-router';
import SiderMenu from './components/common/sidermenu.es6'
import AreaStack from './components/echarts/areastack.es6'
import UserMgt from './components/antd/usermgt.es6'
import HeatmapCartesian from './components/echarts/heatmapcartesian.es6'


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
