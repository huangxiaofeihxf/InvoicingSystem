function Testlogin() {
    var username= $("#u_name").val();
    var pwd=$("#p_pwd").val();
    if(username==null || username==""){
        alert("用户名必填");
    };
    if(pwd==null || pwd==""){
        alert("密码必填");
    };
}

