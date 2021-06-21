<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/Good" var="goodURL"/>
<c:url value="/Dept" var="deptList"/>
<c:url value="/Customer" var="loginURL"></c:url>
<c:url value="/Customer" var="home">
	<c:param name="method" value="adminHome"/>
</c:url>
<c:url value="/Dept" var="addDept">
	<c:param name="method" value="addDeptForm"/>
</c:url>
<c:url value="/Count" var="countURL"/>
<title>Youngin Web Store</title>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red" leftmargin="0" marginwidth="0" topmargin="0" marginheight="0">
<table border="0" cellpadding="0" cellspacing="0" width="1240" height="630">
    <tr>
        <td width="1240" valign="top">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td width="470" height="102"><img src="images/img_main/logo.gif" width="470" height="102" border="0"></td>
                    <td width="788" height="101"><img src="images/img_admin/admin.gif" width="788" height="102" border="0"></td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" width="1258">
                <tr>
                    <td width="86" height="31"><a href="${home}"><img src="images/img_main/images_main_03.gif" width="86" height="31" border="0"></a></td>
                    <td width="107" height="31"><a href="${goodURL}?method=addGoodForm"><img src="images/img_admin/regist.gif" width="107" height="31" border="0"></a></td>
                    <td width="108" height="31"><a href="${deptList}?method=viewDeptList"><img src="images/img_admin/admin_empty01.gif" width="108" height="31" border="0"></a></td>
                    <td width="96" height="31"><a href="${countURL}?method=viewCountList"><img src="images/img_admin/count.gif" width="96" height="31" border="0"></a></td>
                    <td width="73" height="31"><img src="images/img_admin/admin_empty03.gif" width="73" height="31" border="0"></td>
                    <td width="788" bgcolor="#8D4040" height="31"></td>
                </tr>
            </table>            
            <table width="1258" height="497" cellpadding="0" cellspacing="0" background="images/bg.gif">
                <tr style="border-color:rgb(0,51,204); border-style:none;">
                    <td width="1000" height="497">
                    
                    <table cellpadding="0" cellspacing="0" border="0">
                            <tr valign="top">
                                <td width="1004" height="579">
                                    <table cellpadding="0" cellspacing="0" width="1001">
                                        <tr>
                                            <td width="1001" height="48">&nbsp;</td>
                                        </tr>
                                    </table>
                                    <table cellpadding="0" cellspacing="0" width="1002">
                                        <tr valign="top">
                                            <td width="76" height="531">&nbsp;</td>
                                            <td width="926" height="531">
                                            
											<c:url var="deptURL" value="/Dept"/>

<form method="post" action="${deptURL}">
    <h1 align="center"><font face="¸¼Àº °íµñ" color="#1F497D">¹°Ç°Á¤º¸¼öÁ¤</font></h1>
	<br/>
    <table border=1 width="700" cellspacing=0 bgcolor="#F1F3F6" bordercolor="white" bordercolordark="white" bordercolorlight="silver" align="center">
        <tr>
            <td><font face="¸¼Àº °íµñ">Ç°¸ñÄÚµå</font></td>
            <td colspan="3">
				<input type="text" name="code" size="10" maxlength="10" value="${DEPT.code}"/ style="border-width:1; border-style:solid;">
            </td>
        </tr>
        <tr>
            <td><font face="¸¼Àº °íµñ">Ç°¸ñ</font></td>
            <td colspan="3">
				<input type="text" name="name" size="10" maxlength="10" value="${DEPT.name}"/ style="border-width:1; border-style:solid;">
            </td>
        </tr>
        <tr>
            <td><font face="¸¼Àº °íµñ">°¡°Ý</font></td>
            <td>
				<input type="text"   name="price" maxlength="10" size="10" value="${DEPT.price}"/ style="border-width:1; border-style:solid;"><font face="¸¼Àº °íµñ">¿ø</font>
            </td>
            <td><font face="¸¼Àº °íµñ">Á¦°í¼ö·®</font></td>
            <td>
			<select name="max_cnt"><c:forEach begin="0" end="1000" step="10" var="i">
                   <option value="${i}"
						<c:if test="${i == DEPT.maxAskCnt}">
						selected
						</c:if>
					>${i}°³</option>
				</c:forEach>
	        </select>
            </td>
        </tr>
    </table>
    <br>
<font face="¸¼Àº °íµñ"><span style="font-family:±¼¸²; font-size:11pt; color:rgb(102,102,102); text-decoration:none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></font><input type="hidden" name="method" value="editDept">
<input type="submit" value="¿Ï·á" / style="background-color:rgb(241,243,246); border-width:1; border-color:rgb(241,243,246); border-style:solid;">
<input type="reset" value="ÀçÀÔ·Â" / style="background-color:rgb(241,243,246); border-width:1; border-style:solid;">
<a href='<%= request.getContextPath() %>/Dept?method=viewDeptList'><font face="¸¼Àº °íµñ">¸ñ·Ïº¸±â</font></a><font face="¸¼Àº °íµñ">
</font>
</form>

											</td>
                                        </tr>
                                    </table>
								</td>
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
                    
                    <c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="104" height="24" colspan="2">
                        <input type="text" name="customerId" maxlength="12" size="12"></td>
                    </c:if>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                    	<td width="104" height="24" colspan="2"><h5>${sessionScope.CUSTOMER.m_name}´Ô</h5></td>
                    </c:if>
                        
                    <c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="37" height="24"><input type="checkbox" name="save_id"></td>
                    </c:if>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                    	<td width="37" height="24">
                    </c:if>
                    
                    <c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="57" height="24">
                        <p align="left"><font size="1" color="#3A6E74">ÀúÀå</font></p></td>
                    </c:if>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                    	<td width="57" height="24">
                    </c:if>
                </tr>
                <tr>
					<c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="104" height="24" colspan="2">
                        <input type="password" name="customerPassword" maxlength="12" size="12"></td>
                        <input type="hidden" name="method" value="loginCustomer">
                    </c:if>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                    	<td width="104" height="24" colspan="2"><h5>È¯¿µÇÕ´Ï´Ù.</h5></td>
                    </c:if>
                        
	      			<c:if test="${empty sessionScope.CUSTOMER}">
	      				<c:url value="/Customer" var="loginURL">
	   					<c:param name="method" value="loginCustomer"/>
	  				 	</c:url>
                    <td width="94" colspan="2" height="26"><a href="${loginURL}"><input type="image" src="images/img_login/login07.gif" width="69" height="26" border="0"></a></td>
    	           	</c:if>
    	           	
    	           	<c:if test="${!empty sessionScope.CUSTOMER}">
    	        	   	<c:url value="/Customer" var="logoutURL">
	   					<c:param name="method" value="logoutCustomer"/>
	   					</c:url>
                    <td width="94" colspan="2" height="26"><a href="${logoutURL}"><input type="image" src="images/img_login/logout.gif" width="69" height="26" border="0"></a></td>
    	           	</c:if>

                </tr>
                <tr>
                	<c:if test="${!empty sessionScope.CUSTOMER}">
                	<td width="52" height="31"></td>
                    <td width="52" height="31"><img src="images/img_login_after/login_after02.gif" width="42" height="31" border="0"></td>
                    <td width="94" height="31" colspan="2"><img src="images/img_login_after/login_after03.gif" width="69" height="31" border="0"></td>
                	</c:if>
                	<c:if test="${empty sessionScope.CUSTOMER}">
                    <td width="52" height="31"><a href="apply.jsp" target="_self"><img src="images/img_login/login08.gif" width="52" height="31" border="0"></a></td>
                    <td width="52" height="31"><img src="images/img_login/id_search.gif" width="42" height="31" border="0"></td>
                    <td width="94" height="31" colspan="2"><img src="images/img_login/pw_search.gif" width="69" height="31" border="0"></td>
                    </c:if>
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
</body>