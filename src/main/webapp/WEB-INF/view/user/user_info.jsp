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
				$("#smit").click(function(){
					$.post({
						url: '${pageContext.request.contextPath}/user/updateAdminInfo.do',
						data: $(".main_form").serialize(),
					    success : function(result){
					    	showResult(result);
					    }
					})
				})
			})
            //保存成功的提示信息
            function showResult(msg) {
				var m;
				if("ok" == msg){
					m = "修改成功";
				}else{
					m = "修改失败";
				}
				$("#save_result_info").text(m);
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
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success" style="display:none"></div><!--保存失败，数据并发错误！-->
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.acname}" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="${admin.lr_string }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name ="aname" value="${admin.aname}" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="atel" value="${admin.atel }" />
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="aemail" value="${admin.aemail }" />
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.createTime }"/></div>
                <div class="button_info clearfix">
                    <input id="smit" type="button" value="保存" class="btn_save"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type="hidden" name="aid" value="${admin.id }"/>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
