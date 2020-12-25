$(function(){
    // 滚轮滑动（背景变化）
    $(window).on('mousewheel',function(e){
        // 监听窗口大小
        let $winwidth = $(window).width();

        let $window = $(this).scrollTop();
        let $addObj = $('.ydx-coop-outbox');
        // 合作共赢
        let $hzgy = $('#ydx-coop-tit');
        if($window > 20 && $winwidth >= 576){
            $addObj.removeClass('tobeWhite tobeBlack').addClass('tobeBlack');
            $hzgy.css({
                color: '#007DFF',
            }).children('p').css({
                color: '#45BCCB',
            });
        }else if($winwidth >= 576){
            $addObj.removeClass('tobeWhite tobeBlack').addClass('tobeWhite');
        }else{
            // 手机端
            $addObj.removeClass('tobeWhite tobeBlack').addClass('tobeBlack');
        }
        
    });

    /* *************************** 上部分图标添加动画 ***************************** */
    // watch
    // 鼠标移入图标
    $('#watch,#jidinghe_2').on('mouseenter',function(){
        $(this).removeClass('animate-watch-down animate-watch').addClass('animate-watch');
    });
    // 鼠标移出图标
    $('#watch,#jidinghe_2').on('mouseleave',function(){
        $(this).removeClass('animate-watch-down animate-watch').addClass('animate-watch-down');
    });

    // jidinghe
    // 鼠标移入图标
    $('#jidinghe,#talk_border').on('mouseenter',function(){
        $(this).removeClass('animate-jidinghe-back animate-jidinghe').addClass('animate-jidinghe');
    });
    // 鼠标移出图标
    $('#jidinghe,#talk_border').on('mouseleave',function(){
        $(this).removeClass('animate-jidinghe-back animate-jidinghe').addClass('animate-jidinghe-back');
    });

    // qukuailian
    // 鼠标移入图标
    $('#qukuailian').on('mouseenter',function(){
        $(this).removeClass('animate-qukuailian-back animate-qukuailian-back').addClass('animate-qukuailian');
    });
    // 鼠标移出图标
    $('#qukuailian').on('mouseleave',function(){
        $(this).removeClass('animate-qukuailian-back animate-qukuailian-back').addClass('animate-qukuailian-back');
    });




});