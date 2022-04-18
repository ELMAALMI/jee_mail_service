const inbox_body_table = document.getElementById("inbox_body_table");
const send_mail_btn = document.getElementById("send_mail_btn");
const inbox_mail_btn = document.getElementById("inbox_mail_btn");
const trash_mail_btn = document.getElementById("trash_mail_btn");
const refresh_btn = document.getElementById("refresh_btn");
const getSendEmail = async ()=>{
    try{
        let res = await fetch("emails");
        res = res.json();
        console.log(res);
        return res;
    }catch (e) {
        console.log(e)
    }
}
const htmlComponent = (mail)=>(
     '<tr> <td class="action"><input type="checkbox" /></td>'
    +'<td class="name"><a href="#">'+mail["to"]+'</a></td>'
    +'<td class="subject"> <a href="read-email?='+mail["id"]+'">'+mail["subject"]+'</a> </td>'
    +'<td class="time"> '+mail["createdAt"]+' </td> </tr>'
);

const handleInboxClick = async (e)=>{
    try {
        const mails = await getSendEmail();
        console.log(mails)
        let content='';
        for(let mail of mails){
            content+=htmlComponent(mail)
        }
        console.log(content)
        inbox_body_table.innerHTML = content;
        send_mail_btn.classList.add("active");
        trash_mail_btn.classList.remove("active");
        inbox_mail_btn.classList.remove("active");
    }catch (e){
        console.log(e)
    }
}
const reloadPage = (e)=>{
    location.reload();
}
send_mail_btn.addEventListener("click",handleInboxClick);
inbox_mail_btn.addEventListener("click",reloadPage);
refresh_btn.addEventListener("click",reloadPage);