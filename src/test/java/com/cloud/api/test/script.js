// //这个获取他们的顶级父类
// let trs = document.getElementById("LbInfo").firstChild.firstChild
// //作为一个对象数组，每个对象放的值是：时间已经对应的节点
// let arr = []
// //2,4,6获取，对应下标为1,3,5
// for (let index = 1; index < trs.length; index++) {
//     let obj = {
//         //存储时间
//         time: trs[index].firstChild.firstChild.textContent,
//         //这个存储的是申请按钮节点
//         morningNode: trs[index].firstChild.nextSibling.nextSibling.nextSibling.firstChild,
//         aftertoon: trs[index + 1].firstChild.nextSibling.nextSibling.firstChild
//     }
//     arr.push(obj)
// }
// // let trs = span.firstChild.firstChild.childNodes
// // let time = trs[1].firstChild.firstChild.textContent
// for (let arrElement of arr) {
//     arrElement.morningNode.click()
//     console.log(arrElement)
// }

new Promise((resolve, reject) => {
    //点击进入新星剧场
    let new_star = document.getElementById("GridView1_ctl02_Button1")
    new_star.click()
    sleep(1000)
    let supports = document.getElementsByClassName("BtnEnable")
    for (let index = 0; index < supports.length; index++) {
        supports[index].click()
        sleep(1000)
        //此时表示进入了填写信息然后可以提交申请的页面
        document.getElementById('MeetThing').value = '迎新晚会'
        document.getElementById('MeetTime').value = '13:00~22:00'
        document.getElementById('PersonCount').value = '200'
        document.getElementById('LinkMen').value = '高光宇'
        document.getElementById('LinkTel').value = '13882262585'
        document.getElementById('AddressInfoApp1_Memo').value = '申请迎新晚会'
        document.getElementById('Save').click()
        document.getElementById('GridView1_ctl04_Button1').click()
    }
    resolve("success")
}).then(res => {
    console.log(res)
})

function sleep(time) {
    return new Promise(((resolve => {
        setTimeout(resolve, time);
    })))
}