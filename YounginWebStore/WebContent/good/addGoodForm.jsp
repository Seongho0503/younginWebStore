<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/Good" var="goodURL"/>
<c:url value="/Customer" var="loginURL"></c:url>
<title>Youngin Web Store</title>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red" leftmargin="0" marginwidth="0" topmargin="0" marginheight="0">
<table border="0" cellpadding="0" cellspacing="0" width="1240" height="630">
    <tr>
        <td width="1240" valign="top">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td width="470" height="102"><img src="images/img_main/images_main_01.gif" width="470" height="102" border="0"></td>
                    <td width="788" height="101"><img src="images/img_admin/admin.gif" width="788" height="102" border="0"></td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" width="1258">
                <tr>
                    <td width="86" height="31"><a href="admin.jsp" target="_self"><img src="images/img_main/images_main_03.gif" width="86" height="31" border="0"></a></td>
                    <td width="107" height="31"><a href="${goodURL}?method=addGoodForm"><img src="images/img_admin/regist.gif" width="107" height="31" border="0"></td>
                    <td width="108" height="31"><img src="images/img_admin/admin_empty01.gif" width="108" height="31" border="0"></td>
                    <td width="96" height="31"><img src="images/img_admin/count.gif" width="96" height="31" border="0"></td>
                    <td width="73" height="31"><img src="images/img_admin/admin_empty03.gif" width="73" height="31" border="0"></td>
                    <td width="788" bgcolor="#8D4040" height="31"></td>
                </tr>
            </table>            
            <table width="1258" height="497" cellpadding="0" cellspacing="0" background="images/bg.gif">
                <tr style="border-color:rgb(0,51,204); border-style:none;">
                    <td width="1000" height="497">
	                    <h1>물품 등록</h1>
						<form method=post action="AddGood" 
						    enctype="multipart/form-data"> 
						물품명:<input type="text" name="gname"><br>
						가  격:<input type="text" name="price"><br>
						설  명:<br>
						<textarea name="detail" rows="10" cols="50"></textarea>
						<br>
						사  진:<input type="file" name="image" size="40"><br>
						<input type="submit" value="등    록">
						 &nbsp;<input type="reset" value="취    소"><br>
						</form>
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
                    	<td width="104" height="24" colspan="2"><h5>${sessionScope.CUSTOMER.m_name}님</h5></td>
                    </c:if>
                        
                    <c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="37" height="24"><input type="checkbox" name="save_id"></td>
                    </c:if>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                    	<td width="37" height="24">
                    </c:if>
                    
                    <c:if test="${empty sessionScope.CUSTOMER}">
                    	<td width="57" height="24">
                        <p align="left"><font size="1" color="#3A6E74">저장</font></p></td>
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
                    	<td width="104" height="24" colspan="2"><h5>환영합니다.</h5></td>
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
                	<td width="52" height="31"><a href="" target="_self"><img src="images/img_login_after/login_after01.gif" width="52" height="31" border="0"></a></td>
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