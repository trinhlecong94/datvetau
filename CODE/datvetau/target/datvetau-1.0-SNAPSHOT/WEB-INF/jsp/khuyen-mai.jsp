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
        <div class="container">
            <jsp:include page="../jsp/include/nav.jsp"/>
            <div class="my-3">  
                <img style='height: 100%; width: 100%; object-fit: contain' src="http://saigonrailway.com.vn/upload/images/2018/12/1349x565-1544083869-single_banner26-1tauqualc.jpg">  
            </div>
            <div>
                <div>
                    <span>
                        <strong>CHÍNH SÁCH KHUYẾN MÃI</strong>
                    </span>
                    
                </div>
                <br>
                <div>
                    <div class="list-group">
                        <a href="http://www.vantaiduongsathanoi.vn/category/tin-tuc/tin-khuyen-mai/">
                            CÔNG TY VẬN TẢI ĐƯỜNG SẮT HÀ NỘI
                        </a> 
                        <br>
                        <a href="http://saigonrailway.com.vn/khuyen-mai-2-22.html">
                            CÔNG TY VẬN TẢI ĐƯỜNG SÀI GÒN
                        </a> 
                        <br>
                    </div>
                </div>
            </div>
            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
