<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
		<%@include file="../include/header.jsp" %>
		<script type="text/javascript">
			$(function(){
				if('${errorPwdMsg}'!=''){
					showResult();
				}
				$("#smit").click(function(){
					$(".main_form").submit();
				})
			})
			
			 //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                if (flag)
                    $("#save_result_info").css("display","block");
                else
                	$("#save_result_info").css("display","none");
            }
		
		</script>
    </head>
    <body>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
        	<%@include file="../include/navi.jsp" %>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败--> 
 
            <div id="save_result_info" class="save_fail" style="display:none">${errorPwdMsg}</div>

            <form action="${pageContext.request.contextPath}/user/updatePwdAction.do" method="post" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldpwd" /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200"  name="newpwd"/><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200"  /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="button_info clearfix">
                    <input id="smit" type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
