const inbox_body_table = document.getElementById("inbox_body_table");
const send_mail_btn = document.getElementById("send_mail_btn");
const inbox_mail_btn = document.getElementById("inbox_mail_btn");
//const trash_mail_btn = document.getElementById("trash_mail_btn");
const refresh_btn = document.getElementById("refresh_btn");
const model_windows = document.getElementById("inbox-mail");
const close = document.getElementById("close");
const loading = document.getElementById("loading");
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
const getEmailById = async (id,type)=>{
    try{
        loading.style.display="block";
        if(type === 're'){
            let res = await fetch("FindReMailByUuidServlet?uuid="+id);
            res = res.json();
            console.log(res);
            loading.style.display="none";
            return res;
        }else {
            let res = await fetch("email-by-id?id="+id);
            res = res.json();
            console.log(res);
            loading.style.display="none";
            return res;
        }
    }catch (e) {
        console.log(e)
    }
}
const htmlComponent = (mail)=>(
     '<tr style="cursor: pointer" onclick="open_model('+mail['id']+')"> <td class="action"><input type="checkbox" /></td>'
    +'<td class="name">'+mail["to"]+'</td>'
    +'<td class="subject">'+mail["subject"]+'</td>'
    +'<td class="time"> '+mail["createdAt"]+' </td> </tr>'
);

const handleInboxClick = async (e)=>{
    try {
        const mails = await getSendEmail();
        let content='';
        for(let mail of mails){
            content+=htmlComponent(mail)
        }
        console.log(content)
        inbox_body_table.innerHTML = content;
        send_mail_btn.classList.add("active");
        //trash_mail_btn.classList.remove("active");
        inbox_mail_btn.classList.remove("active");
    }catch (e){
        console.log(e)
    }
}
const reloadPage = (e)=>{
    location.reload();
}
// events
send_mail_btn.addEventListener("click",handleInboxClick);
inbox_mail_btn.addEventListener("click",reloadPage);
refresh_btn.addEventListener("click",reloadPage);
close.addEventListener("click",(e)=>{
    model_windows.style.display="none";
})
//get email
const open_model = async (id,type=null)=>{
    const email = await getEmailById(id,type);
    if(type==='re'){
        document.getElementById("to_span").textContent="From"
    }else {
        document.getElementById("to_span").textContent="To"
    }
    document.getElementById("to").value = type==='re'?email["from"]:email["to"];
    document.getElementById("subject").value = email["subject"];
    document.getElementById("message").value = email["message"];
    model_windows.style.display="block";
}




