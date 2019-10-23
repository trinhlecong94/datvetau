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
                            <strong class="ng-binding">CÁC QUY ĐỊNH</strong>
                        </span>
                    </div>
                    <div>
                        <div class="list-group">
                            <a href="https://dsvn.vn/images/4_QuyDinhMuaVeTauTrucTuyen.pdf" class="list-group-item ng-binding">QUY ĐỊNH MUA VÉ TÀU TRỰC TUYẾN</a> 
                            <a href="https://dsvn.vn/images/3_ChinhSachBaoMatThongTin.pdf" class="list-group-item ng-binding">CHÍNH SÁCH BẢO MẬT THÔNG TIN</a> 
                            <a href="https://dsvn.vn/images/1_QuyDinhVanChuyen.pdf" class="list-group-item ng-binding">QUY ĐỊNH VẬN CHUYỂN</a> 
                            <a href="https://dsvn.vn/images/2_DieuKienSuDung.pdf" class="list-group-item ng-binding">ĐIỀU KIỆN SỬ DỤNG</a> 
                            <a href="http://www.vr.com.vn/thong-cao-bao-chi.html" class="list-group-item ng-binding" target="_blank">THÔNG CÁO BÁO CHÍ</a> 
                            <a href="https://dsvn.vn/images/6_QuyTrinhHoanTienVeTaiKhoan.pdf" class="list-group-item ng-binding" target="_blank">QUY TRÌNH HOÀN TIỀN VỀ TÀI KHOẢN</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
