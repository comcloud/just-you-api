$(function(){
    /* 
        联系我们
    */
    // 鼠标移入
    $('.btn-outline-light').mouseenter(function(){
        $('.showPic').stop(true,false).slideDown();
    });

    // 鼠标移出
    $('.btn-outline-light').mouseleave(function(){
        $('.showPic').stop(true,false).slideUp();
    });


    /* 
        多领域的合规建设（动画）
     */
    $('.js-single-part').mouseenter(function(){
        $(this).find('img').css({
            animationName: 'beBig',
            animationDuration: '.8s',
            animationFillMode: 'forwards',
        });
        $(this).find('.down-box').css({
            background: '#F2F2F2',
        });
    });

    $('.js-single-part').mouseleave(function(){
        $(this).find('img').css({
            animationName: 'beSmall',
            animationDuration: '.8s',
            animationFillMode: 'forwards',
        });
        $(this).find('.down-box').css({
            background: '#F8F8F8',
        });
    });


    // ********************举报渠道
    let $winWidth = $(window).width();
    let isBigImage = $winWidth >= 900;
    let $jubao_img = $('#jubao_img');
    $(window).on('resize',function(){
        let sm_img_src = $jubao_img.data('sm-img');
        let bg_img_src = $jubao_img.data('big-img');
        console.log(sm_img_src);
        if(!isBigImage){
            // 构建新的img
            let newImg = $(`<img src=${sm_img_src}>`);
            $jubao_img.empty().append(newImg);
        }else{
            // 还原原来的图
            let backImg = $(`<img src=${bg_img_src}>`);
            $jubao_img.empty().append(backImg);
        }
    });

    $(window).trigger('resize');
    
});