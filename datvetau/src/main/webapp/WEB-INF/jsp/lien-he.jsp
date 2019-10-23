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
        <br>

        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-8">
                    <div>
                        <h3 class="ng-binding"><!--Thông tin liên hệ-->Thông tin liên hệ</h3>
                        <div class="row">
                            <div class="col-xs-12 col-sm-6 et-col-md-6">
                                <h5 style="color: #e55a05; font-weight: bold;" class="ng-binding"><!--Tổng công ty Đường  sắt Việt Nam-->Tổng công ty Đường sắt Việt Nam</h5><br>
                                <p class="ng-binding"><!--Số 118 Lê Duẩn, Hoàn Kiếm, Hà Nội.-->Số 118 Lê Duẩn, Hoàn Kiếm, Hà Nội.</p>
                                <p class="ng-binding">
                                    <!--Điện thoại: 19006469-->Điện thoại: 19006469<br>
                                    <!--Email: dsvn@vr.com.vn.-->Email: dsvn@vr.com.vn.<br>
                                </p>
                                <p style="font-size:11px;" class="ng-binding">
                                    <!--Giấy chứng nhận ĐKKD số 113642 theo QĐ thành lập số 973/QĐ-TTg ngày 25/06/2010 của Thủ tướng Chính phủ.
                                    <br /><br /> Mã số doanh nghiệp: 0100105052, đăng ký lần đầu ngày 26/07/2010, đăng ký thay đổi lần 4 ngày 27/06/2014 tại Sở KHĐT Thành phố Hà Nội.-->
                                    Giấy chứng nhận ĐKKD số 113642 theo QĐ thành lập số 973/QĐ-TTg ngày 25/06/2010 của Thủ tướng Chính phủ.
                                    <br><br>
                                    Mã số doanh nghiệp: 0100105052, đăng ký lần đầu ngày 26/07/2010, đăng ký thay đổi lần 4 ngày 27/06/2014 tại Sở KHĐT Thành phố Hà Nội.
                                </p>
                            </div>            
                            <div class="col-xs-12 col-sm-6 et-col-md-6">
                                <h5 style="color: #e55a05; font-weight: bold;" class="ng-binding"><!--Tổng đài hỗ trợ khách hàng-->Tổng đài hỗ trợ khách hàng</h5>
                                <p class="ng-binding"><!--FPT: <label>19006469</label>-->FPT: 19006469</p>
                                <p class="ng-binding"><!--Khu vực miền Bắc: <label>1900 0109</label>-->Khu vực miền Bắc: 1900 0109</p>
                                <p class="ng-binding"><!--Khu vực miền Nam: <label>1900 1520</label>-->Khu vực miền Nam: 1900 1520</p>
                                <p>Email: support1@dsvn.vn<br>
                                    <span style="visibility: hidden;">Email: </span>support2@dsvn.vn</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2"></div>
            </div>
        </div>
    </body>
</html>
