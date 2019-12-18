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
            <div class="container">
                <div class="et-col-md-12 ng-scope">
                    <div>
                        <div class="row et-page-header">
                            <span class="et-main-label">
                                <strong class="ng-binding">CÁC QUY ĐỊNH</strong>
                            </span>
                        </div>
                        <br>
                        <div>
                            <div class="list-group">
                                <a href="https://dsvn.vn/images/4_QuyDinhMuaVeTauTrucTuyen.pdf">QUY ĐỊNH MUA VÉ TÀU TRỰC TUYẾN</a> 
                                <br>
                                <a href="https://dsvn.vn/images/3_ChinhSachBaoMatThongTin.pdf">CHÍNH SÁCH BẢO MẬT THÔNG TIN</a> 
                                <br>
                                <a href="https://dsvn.vn/images/1_QuyDinhVanChuyen.pdf">QUY ĐỊNH VẬN CHUYỂN</a> 
                                <br>
                                <a href="https://dsvn.vn/images/2_DieuKienSuDung.pdf">ĐIỀU KIỆN SỬ DỤNG</a> 
                                <br>
                                <a href="http://www.vr.com.vn/thong-cao-bao-chi.html">THÔNG CÁO BÁO CHÍ</a> 
                                <br>
                                <a href="https://dsvn.vn/images/6_QuyTrinhHoanTienVeTaiKhoan.pdf">QUY TRÌNH HOÀN TIỀN VỀ TÀI KHOẢN</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>