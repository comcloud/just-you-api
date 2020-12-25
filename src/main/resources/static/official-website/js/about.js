$(function(){
    // 设置全局变量记录点击对象
    var count;
    // 点击对应 .nav-link 为其添加类active
    $('.nav-link').click(function(){
        $(this).addClass('active').siblings('.nav-link').removeClass('active');
        // 获取当前jquery对象索引
        var index = $(this).index();
        // 存储对应索引
        count = index;
        // 为对应jquery对象添加showThis类
        $('.rightAll>div').eq(index).addClass('showThis').siblings('div').removeClass('showThis');

    });

    // 核心团队设置鼠标移入事件
    $('.innerbox').mouseenter(function(){
        $(this).addClass('shadowBox');
    });

    // 核心团队设置鼠标移入事件
    $('.innerbox').mouseleave(function(){
        $(this).removeClass('shadowBox');
    });


    // 鼠标移入
    $('.btn-outline-light').mouseenter(function(){
        // 判断是否处在联系我们页面
        if(count != 2){
            $('.showPic').stop(true,false).slideDown();
        }
    });

    // 鼠标移出
    $('.btn-outline-light').mouseleave(function(){
        $('.showPic').stop(true,false).slideUp();
    });
    


    // 核心团队
    $('.innerbox').click(function(){
        location = "/justyou/about2";
    });

});