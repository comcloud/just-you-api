$(function(){
    // 轮播图
    $(window).on('resize',function(){
        // 1. 监听页面宽度
        let clientW = $(window).width();
        // 2. 判断页面
        let isBigImg = clientW >= 900;
        // 3. 获取所有轮播图
        let $allItems = $('#ydx-index-lb .carousel-item');
        $allItems.each((index,ele)=>{
            // 获取图片src
            let src = isBigImg ? $(ele).data('lg-img') : $(ele).data('sm-img');
            let urlImg = `url(${src})`;
            $(ele).css({
                backgroundImage: urlImg,
            });
            if(!isBigImg){
                let imgEle = $(`<img src='${src}'>`);
                $(ele).empty().append(imgEle);
            }else{
                $(ele).empty();
            }
        })

    });

    $(window).trigger('resize');


    /* ************软件诞生图标动画添加*********** */
    // 鼠标移入图标
    $('.round-pic,.ydx-fa-outbox').on('mouseenter',function(){
        $(this).removeClass('animate-tobig animate-toback').addClass('animate-tobig');
    });
    // 鼠标移出图标
    $('.round-pic,.ydx-fa-outbox').on('mouseleave',function(){
        $(this).removeClass('animate-tobig animate-toback').addClass('animate-toback');
    });
});