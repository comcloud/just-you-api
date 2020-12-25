$(function(){
    var index2 = 0;/*初始化一个变量 指向下彪*/
    //点击点
    $(".tab-btn .btn").click(function () {
        index2 = $(this).index();//获取点击该元素下彪
        $(this).addClass("active").siblings().removeClass("active");
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
    });
    //点击切换效果
    $(".lr-tab .right").click(function () {
        index2 ++;
        if (index2 >4){ index2 = 0;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");

    });
    $(".lr-tab .left").click(function () {
        index2 --;
        if(index2 < 0){index2 = 4;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");

    });
    var time2 = setInterval(function () {
        index2 ++;
        if (index2 >4){ index2 = 0;}
        $(".item").eq(index2).fadeIn().siblings().fadeOut();
        $(".tab-btn .btn").eq(index2).addClass("active").siblings().removeClass("active");

    },4000); //定时器 重复

    // 鼠标移入
    $('.btn-outline-light').mouseenter(function(){
        $('.showPic').stop(true,false).slideDown();
    });

    // 鼠标移出
    $('.btn-outline-light').mouseleave(function(){
        $('.showPic').stop(true,false).slideUp();
    });

});