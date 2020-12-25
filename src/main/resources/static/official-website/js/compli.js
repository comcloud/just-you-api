$(function(){
    // 鼠标移入电商解决方案
    $('.shop-card').on('mouseenter',function(){
        $(this).addClass('showBoxShadow-shop');
    });
    // 鼠标移出电商解决方案
    $('.shop-card').on('mouseleave',function(){
        $(this).removeClass('showBoxShadow-shop');
    });

    // 鼠标移入视频直播解决方案
    $('.vedio-card').on('mouseenter',function(){
        $(this).addClass('showBoxShadow-vedio');
    });
    // 鼠标移出视频直播解决方案
    $('.vedio-card').on('mouseleave',function(){
        $(this).removeClass('showBoxShadow-vedio');
    });


    // 鼠标移入技术支持图标
    $('.tech-img>img').on('mouseenter',function(){
        $(this).addClass('animate-techo');
    });
    // 鼠标移出技术支持图标
    $('.tech-img>img').on('mouseleave',function(){
        $(this).removeClass('animate-techo');
    });

    /* ********************************EChart生成图表******************************** */
    // *********************************第一图表
    let fir_chart = echarts.init(document.getElementById('compli-fir-chart'));
    // 指定图表的配置项和数据
    let option = {
        baseOption: {
            title: {
                text: '软件需求趋势图'
            },
            tooltip: {},
            legend: {
                data:['软件需求量']
            },
            grid: {
                left: '7%',
                right: '4%',
                bottom: '2%',
                containLabel: true
            },
            xAxis: {
                data: ["教育","商品售卖","企业管理","快递交易","学习工具","外卖"]
            },
            yAxis: {
                data: ['2014', '2015', '2016', '2017', '2018', '2019', {
                    value: '2020',
                    // 突出今年
                    textStyle: {
                        fontSize: 18,
                        color: '#7473EC'
                    }
                }]
            },
            series: [{
                name: '软件需求量',
                type: 'bar',
                data: [1, 1, 1, 2, 2, 3]
            }]
        }
       
    };
    // 使用刚指定的配置项和数据显示图表。
    fir_chart.setOption(option);
    // 添加数据动作
    let count = 0;
    let newArr = [];
    setInterval(()=>{
        // 返回原数组值
        if(count > 4){
            option.baseOption.series[0].data = [0.1, 1, 1, 2, 2, 3];
            fir_chart.setOption(option);
            count = 0;
        }
        newArr = [];
        option.baseOption.series[0].data.forEach(item=>{
            item++;
            newArr.push(item);            
        });
        count++;
        option.baseOption.series[0].data = newArr;
        fir_chart.setOption(option);
    },1000);


    // ******************************第二图表
    let sec_chart = echarts.init(document.getElementById('compli-sec-chart'));
    let sec_option = {
        baseOption:{
            title: {
                text: '各类软件需求图',
                subtext: '数据来自网络'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ['2015年', '2020年']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: ['快递类软件', '学习类软件', '企业管理类软件', '视频软件', '外卖软件', '电商软件']
            },
            series: [
                {
                    name: '2015年',
                    type: 'bar',
                    data: [78203, 23489, 29034, 104970, 131744, 230230]
                },
                {
                    name: '2020年',
                    type: 'bar',
                    data: [299325, 243438, 401000, 521594, 434141, 681807]
                }
            ]
        },
        media: [ // 这里定义了 media query 的逐条规则。
            {
                query: {        // 这里写规则。
                    maxWidth: 500,
                },   
                option: {       // 这里写此规则满足下的option。
                    title: {
                        text: '',
                        subtext: ''
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '3%',
                        bottom: '3%',
                        containLabel: true
                    },
                    legend: {
                        data: ['2015年', '2020年']
                    },
                    xAxis: {
                        type: 'value',
                        boundaryGap: [0, 0.01]
                    },
                    yAxis: {
                        type: 'category',
                        data: ['快递类软件', '学习类软件', '企业管理类软件', '视频软件', '外卖软件', '电商软件']
                    },
                    series: [
                        {
                            name: '2015年',
                            type: 'bar',
                            data: [70, 20, 20, 113, 210, 234]
                        },
                        {
                            name: '2020年',
                            type: 'bar',
                            data: [232, 371, 454, 520, 610, 954]
                        }
                    ]
                }
            },
            
        ]
    };
    // 使用指定的配置项和数据显示图表。
    sec_chart.setOption(sec_option);

   


});