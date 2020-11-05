let btns = []
for (let index = 1; index <= 5; index++) {
    btns.push("GridView1_ctl0" + index + "_Button1")
}
new Promise((resolve, reject) => {
    let supports = document.getElementsByClassName("BtnEnable")
    console.log(supports)
    for (let index = 0; index < supports.length; index++) {
        supports[index].click()
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

})
