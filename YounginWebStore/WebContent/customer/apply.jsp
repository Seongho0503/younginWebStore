<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/Customer" var="home">
	<c:param name="method" value="loginCustomerForm"/>
</c:url>
<c:url value="/Customer" var="tryLogin">
	<c:param name="method" value="tryLoginForm"/>
</c:url>
<html>
<head>
<title>Youngin Web Store</title>
 	<script>
 		<c:if test="${ERROR != null}">
	     	  alert("${ERROR}");
	     </c:if>
	     
	     function validate(){
	       if(document.form1.customerId.value==""){
		       alert("아이디를 입력하세요");
		       document.form1.customerId.focus();
		       return false;
	       }
	       if(document.form1.customerPassword.value==""){
		       alert("비밀번호를 입력하세요");
		       document.form1.customerPassword.focus();
		       return false;
	       }
	       document.form1.submit();
	     }
	</script>
</head>

<c:url value="/Customer" var="customerURL">
	<c:param name="method" value="addCustomerForm"/>
</c:url>
<c:url value="/Customer" var="loginURL"></c:url>
<c:url value="/Customer" var="addURL"/>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red" leftmargin="0" marginwidth="0" topmargin="0" marginheight="0">
<table border="0" cellpadding="0" cellspacing="0" width="1240" height="630">
    <tr>
        <td width="1240" valign="top">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td width="470" height="102"><img src="images/img_main/logo.gif" width="470" height="102" border="0"></td>
                    <td width="788" height="101"><img src="images/img_main/images_main_02.gif" width="788" height="102" border="0"></td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" width="1258">
                <tr>
                    <td width="86" height="31"><a href="${home}"><img src="images/img_main/images_main_03.gif" width="86" height="31" border="0"></a></td>
                    <td width="107" height="31"><a href="${tryLogin}"><img src="images/img_user/user_purchase.gif" width="107" height="31" border="0"></a></td>
                    <td width="108" height="31"><a href="${tryLogin}"><img src="images/img_main/requestProduct.gif" width="108" height="31" border="0"></a></td>
                    <td width="96" height="31"><a href="${tryLogin}"><img src="images/img_main/QnA.gif" width="96" height="31" border="0"></a></td>
                    <td width="73" height="31"><a href="${tryLogin}"><img src="images/img_main/details.gif" width="73" height="31" border="0"></a></td>
                    <td width="788" bgcolor="#8D4040" height="31"></td>
                </tr>
            </table>            <table width="1258" height="497" cellpadding="0" cellspacing="0" background="images/bg.gif">
                <tr style="border-color:rgb(0,51,204); border-style:none;" valign="middle">
                    <td width="1000" height="497">
                        <table cellpadding="0" cellspacing="0" width="1001">
                            <tr valign="top" align="right">
                                <td width="104" height="451">
&nbsp;
</td>
                                <td width="868" height="451">
                                    <table cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td width="663" height="55" valign="top">

                                                <table border="0" cellpadding="0" cellspacing="0" width="621" bgcolor="white">
                                                    <tr>
                                                        <td width="129" height="55"><img src="images/img_apply/txt_inform.gif" width="129" height="55" border="0"></td>
                                                        <td width="492"></td>
                                                    </tr>
                                                </table>
</td>
                                        </tr>
                                        <tr>
                                            <td width="803" height="242" valign="top">
												<form  name="form1" action="${addURL}" method="post">
                                                <table cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td width="621" height="42"><img src="images/img_apply/top.gif" width="621" height="42" border="0"></td>
                                                    </tr>
                                                </table>
                                                
                                                <table cellpadding="0" cellspacing="0" width="621">
                                                    <tr>
                                                        <td width="43" rowspan="7" bgcolor="white"></td>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;이 름</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerName" maxlength="12" size="12" value="${param.customerName}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;아이디</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerId" maxlength="12" size="12" value="${param.customerId}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;비밀번호</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="password" name="customerPassword" maxlength="12" size="12"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;E-mail</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerEmail" maxlength="20" size="20" value="${param.customerEmail}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;주소</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerAddress" maxlength="40" size="40" value="${param.customerAddress}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;학 과</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerDept" maxlength="15" size="15" value="${param.customerDept}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="140" bgcolor="#F7FDFD" style="margin-left:0;" height="25"><font face="굴림체"><span style="font-size:9pt;">&nbsp;&nbsp;학 번</span></font></td>
                                                        <td width="438" bgcolor="white" height="25"><input type="text" name="customerSno" maxlength="15" size="15" value="${param.customerSno}"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="621" height="18" bgcolor="white" colspan="3">
														<img src="images/img_apply/apply_up.gif" width="621" height="18" border="0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="621" height="26" colspan="3" bgcolor="white" align="center">
                                                        <input type="hidden" name="method" value="addCustomer">
                                                        <input type="image" src="images/img_apply/apply_ok.gif" width="67" height="26" border="0" onClick="validate()"><span style="font-size:1pt;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="image" src="images/img_apply/apply_cancel.gif" width="66" height="26" border="0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="621" height="25" colspan="3" bgcolor="white"></td>
                                                    </tr>
                                                </table>
                                                </form>
</td>
                                        </tr>
                                    </table></td>
                                <td width="29" height="451"></td>
                            </tr>
                        </table>
</td>
                    <td width="240" height="497">
                        <table cellpadding="0" cellspacing="0" width="240" height="497">
                            <tr>
                                <td width="240" height="49"></td>
                            </tr>
                            <tr valign="top">
                                <td width="240" height="497">
                                    <table cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td width="230" height="28">
			<form name="form1" action="${loginURL}" method="post">
            <table border="0" cellpadding="0" cellspacing="0" bordercolordark="white" bordercolorlight="black" width="212" bgcolor="#F8F8F8">
                <tr>
                    <td width="212" colspan="5" height="31"><img src="images/img_login/login01.gif" width="175" height="31" border="0"></td>
                </tr>
                <tr>
                    <td width="14" rowspan="3" height="81"><img src="images/img_login/login02.gif" width="12" height="81" border="0"></td>
                    	<td width="104" height="24" colspan="2">
                        <input type="text" name="customerId" maxlength="12" size="12"></td>
                    	<td width="37" height="24"><input type="checkbox" name="save_id"></td>
                    	<td width="57" height="24">
                        <p align="left"><font size="1" color="#3A6E74">저장</font></p></td>
                </tr>
                <tr>
                    	<td width="104" height="24" colspan="2">
                        <input type="password" name="customerPassword" maxlength="12" size="12"></td>
                        <input type="hidden" name="method" value="loginCustomer">

	      				<c:url value="/Customer" var="loginURL">
	   					<c:param name="method" value="loginCustomer"/>
	  				 	</c:url>
                    	<td width="94" colspan="2" height="26"><a href="${loginURL}"><input type="image" src="images/img_login/login07.gif" width="69" height="26" border="0"></td>
                </tr>
            <tr>
            	<td width="52" height="31"><a href="${customerURL}"  target="_self"><img src="images/img_login/login08.gif" width="52" height="31" border="0"></a></td>
                <td width="52" height="31"></td>
                <td width="94" height="31" colspan="2"></td>
            </tr>
	</table>
	</form>
	</td>
    </tr>
    </table>

	</td>
    </tr>
    </table>
	</td>
    </tr>
    </table>
    <p>
	</p>

</td>
    </tr>
    <tr>
        <td width="1240"></td>
    </tr>
</table>