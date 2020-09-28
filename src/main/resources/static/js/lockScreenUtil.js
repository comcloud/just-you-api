window.onload = function () {
    // 将方法添加到window对象上
    (function ($) {
        console.log(new Date().getSeconds());
        funObj = {
            timeUserFun: 'timeUserFun',
        }
        $[funObj.timeUserFun] = function (time) {
            var time = time || 2;    // 默认参数
            var userTime = time * 60;
            var objTime = {
                init: 0,
                time: function () {
                    objTime.init += 1;
                    if (objTime.init == userTime) {
                        // 用户到达未操作事件 做一些处理
                        location.href = "/justyou/page-lockscreen"
                    }
                },
                eventFun: function () {
                    clearInterval(testUser);
                    objTime.init = 0;
                    testUser = setInterval(objTime.time, 1000);
                }
            }

            var testUser = setInterval(objTime.time, 1000);

            var body = document.querySelector('html');
            body.addEventListener("click", objTime.eventFun);
            body.addEventListener("keydown", objTime.eventFun);
            body.addEventListener("mousemove", objTime.eventFun);
            body.addEventListener("mousewheel", objTime.eventFun);
        }
    })(window);


    // 直接调用 参数代表分钟数,可以有一位小数，不传参默认2分钟
    timeUserFun(2);
}