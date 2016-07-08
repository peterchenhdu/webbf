var path = require('path');
var webpack = require('webpack');
var CSS_PATH = path.resolve(__dirname, 'css');

module.exports = {
    entry: {
        user:path.join(__dirname, 'resources/js/user.js'),
        chartdemo:path.join(__dirname, 'resources/js/chartdemo.js'),
        vendors: ['react','reflux','react-mixin']
    },
    output: {
        path: path.join(__dirname, 'build'),
        filename: '[name].js'
    },
    module: {
        loaders: [
            {
                test:/\.js?$/,
                exclude:/node_modules/,
                loader:'babel',
                query:{
                    presets:['react','es2015']
                }
            },
           { test: /\.css$/, loader: "style!css" },
           { test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, loader: 'file' },
           { test: /\.(woff|woff2)$/, loader: 'url?prefix=font/&limit=5000' },
           { test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=application/octet-stream' },
           { test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=image/svg+xml' }
        ]
    },
devServer: { hot: true, inline: true, //其实很简单的，只要配置这个参数就可以了
proxy: {
    '/ajax/*': 'http://your.backend/'
}
 },


    plugins: [
        // kills the compilation upon an error.
        // this keeps the outputed bundle **always** valid
        new webpack.NoErrorsPlugin(),
        //这个使用uglifyJs压缩你的js代码
        //new webpack.optimize.UglifyJsPlugin({minimize: true}),
        new webpack.optimize.CommonsChunkPlugin('vendors', 'vendors.js')
    ]
};
