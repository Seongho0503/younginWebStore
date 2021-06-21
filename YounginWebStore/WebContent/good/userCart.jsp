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
<c:url value="/Good" var="purchase">
	<c:param name="method" value="userViewGoodList"/>
</c:url>
<c:url value="/Customer" var="loginURL"></c:url>
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
                    <td width="108" height="31"><img src="images/img_main/requestProduct.gif" width="108" height="31" border="0"></td>
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
											<%--@ page 
 import="kr.or.dip.wshop.Good,java.util.ArrayList"--%>
<%--
 Object o1=request.getAttribute("good");
 Object o2=session.getAttribute("cart");
 
 Good good=new Good();
 ArrayList <Good>cart=new ArrayList<Good>();
 
 if(o1!=null)
	 good=(Good)o1;
 
 if(o2!=null)
	 cart=(ArrayList)o2;
--%>

<h1>${good.gname}<%--good.getGname()--%> 을 장바구니에 담으셨습니다.</h1>
<center>
	<table border=1>
	  <tr>
	  	<td>아이디</td>
	  	<td>이  름</td>
	  	<td>단  가</td>
	  	<td>수  량</td>
	  	<td>가  격</td>
	  </tr>
	  <%--for(int i=0;i<cart.size();i++){
		 Good cartItem=cart.get(i);
	  --%>
<c:forEach var="cartItem" items="${sessionScope.cart}">
	    <tr>
	    	<td>${cartItem.gid}<%--cartItem.getGid()--%></td>
	    	<td>${cartItem.gname}<%--cartItem.getGname()--%></td>
	    	<td>${cartItem.price}<%--cartItem.getPrice()--%></td>
	    	<td>${cartItem.gty}</td>
	    	<td>${cartItem.price * cartItem.gty}</td>
	    </tr>
	   <%--} --%>
</c:forEach>

</table>
</center>
<br>[<a href="${purchase}">쇼핑하러 가기</a>]
<br>[<a href=Buy>구입하기</a>]
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