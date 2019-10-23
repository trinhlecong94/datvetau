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

        <div class="container">
            <div class="et-col-md-12 ng-scope">
                <div>
                    <div class="row et-page-header">
                        <span class="et-main-label">
                            <strong class="ng-binding">CHÍNH SÁCH KHUYẾN MÃI</strong>
                        </span>
                    </div>
                    <div>
                        <div class="list-group">
                            <a href="http://www.vantaiduongsathanoi.vn/category/tin-tuc/tin-khuyen-mai/" class="list-group-item ng-binding">CÔNG TY VẬN TẢI ĐƯỜNG SẮT HÀ NỘI</a> 
                            <a href="http://saigonrailway.com.vn/khuyen-mai-2-22.html" class="list-group-item ng-binding">CÔNG TY VẬN TẢI ĐƯỜNG SÀI GÒN</a> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
