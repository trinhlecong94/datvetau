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
            <div class="row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-8">
                    <div data-ng-view="" class="shuffle-animation ng-scope" style="padding-right: 0px; padding-left: 0px; text-align: center;">
                        <div class="col-md-12 ng-scope">
                            <div class="form-group ng-binding" style="color:red">Các video clip dưới đây hướng dẫn thực hiện các thao tác mua vé trên website, số lượng vé tối đa một người được phép mua sẽ được Tổng công ty Đường Sắt Việt Nam quy định tại từng thời điểm.
                            </div>
                            <div class="col-md-12 form-group"><a href="http://vr.com.vn/cac-quy-dinh/huong-dan-dat-ve-va-thanh-toan-ve-tau-dien-tu.html" target="_blank">
                                    <strong class="ng-binding">
                                        Hướng dẫn đặt vé và thanh toán vé tầu điện tử
                                    </strong>
                                </a>
                                <br>
                                <a href="http://vr.com.vn/cac-quy-dinh/danh-sach-ngan-hang-chap-nhan-thanh-toan-qua-cong-thanh-toan-banknetvn.html" target="_blank">
                                    <strong class="ng-binding">Danh sách thẻ thanh toán qua Napas</strong></a><br><a href="http://www.saigonrailway.com.vn/category-13-22-29-Cac_diem_giao_dich_Ngan_hang_Quoc_te_(VIB).html" target="_blank"><strong class="ng-binding">Địa chỉ thanh toán tại ngân hàng VIB
                                    </strong>
                                </a>
                                <br>
                                <a href="http://vr.com.vn/cac-quy-dinh/dia-chi-thanh-toan-tai-buu-dien.html" target="_blank">
                                    <strong class="ng-binding">Địa chỉ thanh toán tại bưu điện</strong>
                                </a>
                                <br>
                                <a href="https://www.payoo.vn/tin-tuc/payoo/thanh-toan-ve-tau-chua-bao-gio-don-gian-va-tien-loi-den-the%2521-7536" target="_blank">
                                    <strong class="ng-binding">Điểm thanh toán gần nhà qua Payoo</strong>
                                </a>
                            </div>
                            <h5 class="ng-binding">Giới thiệu vé điện tử</h5><div class="center-block video-guide">
                                <embed class="video-guide" height="400" width="800" src="http://www.youtube.com/v/HYmdGmPrwvM" frameborder="0" allowfullscreen="true">
                            </div>
                            <h5 class="ng-binding">Hướng dẫn mua vé và thanh toán trực tuyến</h5>
                            <div class="center-block video-guide">
                                <embed class="video-guide" height="400" width="800" src="http://www.youtube.com/v/NQI8L7q9yUY" frameborder="0" allowfullscreen="true"></div>
                            <h5 class="ng-binding">Hướng dẫn mua vé và thanh toán trả sau</h5>
                            <div class="center-block video-guide">
                                <embed class="video-guide" height="400" width="800" src="http://www.youtube.com/v/akATHqdUj0Y" frameborder="0" allowfullscreen="true"></div>
                            <h5 class="ng-binding">Hướng dẫn đăng kí hàng đợi</h5>
                            <div class="center-block video-guide">
                                <embed class="video-guide" height="400" width="800" src="http://www.youtube.com/v/DhUUxA3ZkO0" frameborder="0" allowfullscreen="true"></div>
                            <h5 class="ng-binding">Hướng dẫn về quy trình trả vé</h5>
                            <div class="center-block video-guide">
                                <embed class="video-guide" height="400" width="800" src="http://www.youtube.com/v/ZPL8oM5i4Fg" frameborder="0" allowfullscreen="true">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2">
                </div>
            </div>
        </div>
    </body>
</html>
