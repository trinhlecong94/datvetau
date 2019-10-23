<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../jsp/include/nav.jsp"/>
        <div class="container center-block">
            <h1>Đăng kí thành công</h1>
            <span>Cảm ơn bạn đã đăng kí vé tại công ty chúng tôi</span><br>
            <span>Mã code của bạn là ${code}</span><br>
            <span>Lưu giữ mà code này đến tại nhà ga nhận vé</span>
        </div>




    </body>
</html>
