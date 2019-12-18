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
            <br>

            <div class="container">
                <div class="row">
                    <div class="col-sm-2">
                    </div>
                    <div class="col-sm-8">
                        <div>
                            <h3>Thông tin liên hệ</h3>
                            <br>
                            <div class="row">
                                <div class="col-xs-12 col-sm-6 et-col-md-6">
                                    <h5>Tổng công ty Đường sắt Việt Nam</h5><br>
                                    <p>Số 118 Lê Duẩn, Hoàn Kiếm, Hà Nội.</p>
                                    <p>
                                        Điện thoại: 19006469<br>
                                        Email: dsvn@vr.com.vn.<br>
                                    </p>
                                </div>            
                                <div class="col-xs-12 col-sm-6 et-col-md-6">
                                    <h5>Tổng đài hỗ trợ khách hàng</h5>
                                    <p>FPT: 19006469</p>
                                    <p>Khu vực miền Bắc: 1900 0109</p>
                                    <p>Khu vực miền Nam: 1900 1520</p>
                                    <p>Email: support1@dsvn.vn<br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2"></div>
                </div>
            </div>
            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
