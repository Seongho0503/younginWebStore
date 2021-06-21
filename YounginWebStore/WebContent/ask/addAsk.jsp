<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"	
   uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/Customer" var="customerURL">
	<c:param name="method" value="addCustomerForm"/>
</c:url>
<c:url value="/Customer" var="editURL">
	<c:param name="method" value="editCustomerForm"/>
</c:url>
<c:url value="/Good" var="purchase">
	<c:param name="method" value="userViewGoodList"/>
</c:url>
<c:url value="/Customer" var="home">
	<c:param name="method" value="userHome"/>
</c:url>
<c:url value="/Buy" var="buyURL">
	<c:param name="method" value="viewBuyList"/>
</c:url>
<c:url value="/Customer" var="loginURL"></c:url>
<c:url var="askURL" value="/Ask"/>
<title>Youngin Web Store</title>
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
                    <td width="107" height="31"><a href="${purchase}"><img src="images/img_user/user_purchase.gif" width="107" height="31" border="0"></a></td>
                    <td width="108" height="31"><a href="${requestProduct}"><img src="images/img_main/requestProduct.gif" width="108" height="31" border="0"></a></td>
                    <td width="96" height="31"><img src="images/img_main/QnA.gif" width="96" height="31" border="0"></td>
                    <td width="73" height="31"><a href="${buyURL}"><img src="images/img_main/details.gif" width="73" height="31" border="0"></a></td>
                    <td width="788" bgcolor="#8D4040" height="31"></td>
                </tr>
            </table>            
            <table width="1258" height="497" cellpadding="0" cellspacing="0" background="images/bg.gif">
                <tr style="border-color:rgb(0,51,204); border-style:none;">
                    <td width="1000" height="580">
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
                                            
                                            
                                            
											<form  method="post" action='${askURL}'>
    <h1 align="center"><font face="맑은 고딕" color="#1F497D">품목신청</font></h1>
	<br/>
    <table width="697" cellspacing=0 bordercolordark="white" bordercolorlight="#CCCCCC" bgcolor="#F1F3F6" height="107" border="1" bordercolor="white" align="center">
    <tr>
        	<td width="140" bgcolor="#F1F3F6"><font face="맑은 고딕">신청ID</font></td>
            <td colspan="3" width="546" bgcolor="#F1F3F6">
         
         <input type="text" name="writer" readonlystyle maxlength="12" size="12" value="${WRITER}">
            
            </td>
        </tr>
        <tr>	
            <td width="140" height="24" bgcolor="#F1F3F6"><font face="맑은 고딕">품목</font></td>
            <td colspan="3" width="546" height="24" bgcolor="#F1F3F6">
                <%-- AskService 에서 넘겨준 전체 학과를 출력하는 반복문--%>
	        	<select name="dept"><%-- DEPT_LIST 에 담긴 전체 학과 리스트중 하나를 꺼내서 DEPT 에 담음 --%>
                    <c:forEach items="${DEPT_LIST}" var="DEPT">
                    <%-- 학과 코드와 학과명을 출력--%>
                    <option value="${DEPT.code}">${DEPT.name}</option>
                    </c:forEach>				</select>

            </td>
        </tr>
	   
	   
        <tr>
            <td width="140" bgcolor="#F1F3F6"><font face="맑은 고딕">신청수량</font></td>
            <td colspan="3" width="546" bgcolor="#F1F3F6">
				<input type="text" name="regNo" size="3" maxlength="3" / style="background-color:white; border-width:1; border-style:solid;">개
            </td>
        </tr>
	    
        <tr>
            <td width="140" bgcolor="#F1F3F6"><font face="맑은 고딕">학과</font></td>
            <td width="546" bgcolor="#F1F3F6">
				<input type="text" name="name" value="" / style="background-color:white; border-width:1; border-color:rgb(204,204,204); border-style:solid;">
            </td>
			
        </tr>
	   
        <tr>
	        
	     <tr>
            <td width="140" bgcolor="#F1F3F6"><font face="맑은 고딕">처리유무</font></td>
            <td colspan="3" width="546" bgcolor="#F1F3F6">
               
				<select name="status"><%-- STATUS_LIST 에 담긴 전체 학적 리스트중 하나를 꺼내서 STATUS 에 담음 --%>
                    <c:forEach items="${STATUS_LIST}" var="STATUS">
                    
                    
                    
                    <option value='${STATUS.codeValue}'>
					${STATUS.codeName}
                    </option>
                    
                    </c:forEach>					</select>
            </td>
        </tr>
        <tr>
        	<td width="140" bgcolor="#F1F3F6"><font face="맑은 고딕">남기는말</font></td>
            <td colspan="3" width="546" bgcolor="#F1F3F6">
            <p><textarea name="details" rows="20" cols="70"></textarea></p>
            </td>
        </tr>
        <tr>
 
	              
		</table>
    <p><input type="hidden" name="method" value="addAsk">
<font face="맑은 고딕" color="black"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><input type="submit" value="신청" / style="background-color:rgb(241,243,246); border-width:1; border-color:rgb(204,204,204); border-style:solid;">
<input type="reset" value="재입력" / style="background-color:rgb(241,243,246); border-width:1; border-style:solid;">
<a href='${askURL}?method=viewAskList'><font face="맑은 고딕" color="black">목록보기</font></a><font face="HY견고딕">
</font></p>
</form>
                                    
                                    
                                    
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
                    	<td width="94" colspan="2" height="26"><a href="${loginURL}"><input type="image" src="images/img_login/login07.gif" width="69" height="26" border="0"></td>
                   </c:if>
                   
                   <c:if test="${!empty sessionScope.CUSTOMER}">
    	        	   	<c:url value="/Customer" var="logoutURL">
	   					<c:param name="method" value="logoutCustomer"/>
	   					</c:url>
                    <td width="69" colspan="2" height="26"><a href="${logoutURL}"><input type="image" src="images/img_login/logout.gif" width="69" height="26" border="0"></a></td>
    	           	</c:if>
    	           	
                </tr>
                <tr>
                    <c:if test="${!empty sessionScope.CUSTOMER}">
                	<td width="52" height="31"><a href="${editURL}"><img src="images/img_login_after/login_after01.gif" width="52" height="31" border="0"></a></td>
                    <td width="42" height="31"><img src="images/img_login_after/login_after02.gif" width="42" height="31" border="0"></td>
                    <td width="69" height="31" colspan="2"><img src="images/img_login_after/login_after03.gif" width="69" height="31" border="0"></td>
                	</c:if>
                	<c:if test="${empty sessionScope.CUSTOMER}">
                    <td width="52" height="31"><a href="apply.jsp" target="_self"><img src="images/img_login/login08.gif" width="52" height="31" border="0"></a></td>
                    <td width="42" height="31"><img src="images/img_login/id_search.gif" width="42" height="31" border="0"></td>
                    <td width="69" height="31" colspan="2"><img src="images/img_login/pw_search.gif" width="69" height="31" border="0"></td>
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