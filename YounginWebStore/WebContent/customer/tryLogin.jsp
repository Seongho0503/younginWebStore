<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/Customer" var="customerURL">
	<c:param name="method" value="addCustomerForm"/>
</c:url>
<c:url value="/Customer" var="tryLogin">
	<c:param name="method" value="tryLoginForm"/>
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
                    <td width="86" height="31"><a href="index.jsp" target="_self"><img src="images/img_main/images_main_03.gif" width="86" height="31" border="0"></a></td>
                    <td width="107" height="31"><a href="${tryLogin}"><img src="images/img_user/user_purchase.gif" width="107" height="31" border="0"></a></td>
                    <td width="108" height="31"><a href="${tryLogin}"><img src="images/img_main/requestProduct.gif" width="108" height="31" border="0"></a></td>
                    <td width="96" height="31"><a href="${tryLogin}"><img src="images/img_main/QnA.gif" width="96" height="31" border="0"></a></td>
                    <td width="73" height="31"><a href="${tryLogin}"><img src="images/img_main/details.gif" width="73" height="31" border="0"></a></td>
                    <td width="788" bgcolor="#8D4040" height="31"></td>
                </tr>
            </table>            
            <table width="1258" height="497" cellpadding="0" cellspacing="0" background="images/bg.gif">
                <tr style="border-color:rgb(0,51,204); border-style:none;">
                    <td width="1000" height="497">
                    
                    <table cellpadding="0" cellspacing="0" border="0">
                            <tr valign="top">
                                <td width="1004" height="425">
                                    <table cellpadding="0" cellspacing="0" width="1001">
                                        <tr>
                                            <td width="1001" height="48">&nbsp;</td>
                                        </tr>
                                    </table>
                                    <table cellspacing="0" width="1002" border="1" bordercolor="#F7FDFD" bordercolordark="#F7FDFD" bordercolorlight="#F7FDFD">
                                        <tr valign="top">
                                            <td width="76" height="367" rowspan="4">&nbsp;</td>
                                            <td width="185" height="103" valign="middle" align="center"><img src="images/img_main/doksu.JPG" width="108" height="122" border="0"></td>
                                            <td width="741" height="103" colspan="4" valign="middle" align="left">
                                            <LI>로그인이 필요한 페이지입니다.</LI>
                                            <LI>오른쪽 로그인 창에서 로그인을 해 주세요.</LI>
                                            </td>
                                            
                                        </tr>
                                        <tr valign="top">
                                            <td width="185" height="112" valign="middle" align="center"><img src="images/img_main/126031995457323700.jpg" width="108" height="78" border="0"></td>
                                            <td width="185" height="112" valign="middle" align="center"><img src="images/img_main/126092573656256300.jpg" width="108" height="78" border="0"></td>
                                            <td width="185" height="112" valign="middle" align="center"><img src="images/img_main/126092573666029300.jpg" width="108" height="78" border="0"></td>
                                            <td width="185" height="112" valign="middle" align="center"><img src="images/img_main/126092573674617500.jpg" width="108" height="78" border="0"></td>
                                            <td width="185" height="112" valign="middle" align="center"><img src="images/img_main/126092573682419400.jpg" width="108" height="78" border="0"></td>
                                        </tr>
                                        <tr valign="top">
                                            <td width="185" height="35" align="center" valign="middle"><span style="font-size:10pt;">크리스마스 베스트 선물</span></td>
                                            <td width="185" height="35" align="center" valign="middle"><span style="font-size:10pt;">패션에 빠져보자</span></td>
                                            <td width="185" height="35" align="center" valign="middle"><span style="font-size:10pt;">커플 선물</span></td>
                                            <td width="185" height="35" align="center" valign="middle"><span style="font-size:10pt;">쿠폰 혜택</span></td>
                                            <td width="185" height="35" align="center" valign="middle"><span style="font-size:10pt;">배달 음식</span></td>
                                        </tr>
                                        <tr valign="top">
                                            <td width="926" height="117" colspan="5">&nbsp;</td>
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
                    	<td width="104" height="24" colspan="2">
                        <input type="text" name="customerId" maxlength="12" size="12"></td>
                    	<td width="37" height="24"></td>
                    	<td width="57" height="24">
                        <p align="left"><font size="1" color="#3A6E74"></font></p></td>
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
                    <td width="52" height="31"><img src="images/img_login/id_search.gif" width="42" height="31" border="0"></td>
                    <td width="94" height="31" colspan="2"><img src="images/img_login/pw_search.gif" width="69" height="31" border="0"></td>
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