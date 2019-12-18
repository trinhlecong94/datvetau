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

            <div class="row mx-auto">
                <div class="col-3 border">
                    <br>    
                    <h5>Nhập thông tin trên vé</h5>
                    <form action="kiem-tra-ve" method="GET">
                        <div class="form-group">
                            <label for="input-code">Mã vé</label>
                            <input type="number" name="code" class="form-control" id="input-code" aria-describedby="emailHelp" placeholder="Nhập mã vé bao gồm 8 hoặc 9 số">
                        </div>
                        <div class="form-group">
                            <label for="identity-Number">Số giấy tờ</label>
                            <input type="text" name="identityNumber" class="form-control" id="identity-Number" placeholder="Nhập giấy tờ các nhân ghi trên vé">
                        </div>
                        <div class="row justify-content-center">                           
                            <button type="submit" class="btn btn-primary">Submit</button>             
                        </div>
                    </form>
                </div>
                <div class="col-9 border">
                    <div class="container col-6">
                        <br>
                        <c:set var = "errorMessages" value = "${errorMessages}"/>
                        <c:set var = "succesMessages" value = "${succesMessages}"/>
                        <c:if test = "${errorMessages != null}">
                            <div class="alert alert-danger" role="alert">
                                ${errorMessages}
                            </div>
                        </c:if>
                        <c:if test = "${succesMessages != null}">
                            <div class="alert alert-success" role="alert">
                                Tra Cứu Thành Công
                            </div>
                            <table class="table table-bordered">
                                <tr>
                                    <td colspan="2">Thông Tin Vé Của Quý Khách</td>
                                </tr>
                                <tr>
                                    <td>Tên Khách Hàng</td>
                                    <td>${ticketEntity.fullName}</td>
                                </tr>
                                <tr>
                                    <td>Ngày Khởi Hành</td>
                                    <td>${ticketEntity.departureTime}</td>
                                </tr>
                                <tr>
                                    <td>Mã Số Nhân Thân</td>
                                    <td>${ticketEntity.identityNumber}</td>
                                </tr>
                                <tr>
                                    <td>Ga Khởi Hành</td>
                                    <td>${ticketEntity.fromSation.stationName}</td>
                                </tr>
                                <tr>
                                    <td>Ga Đến</td>
                                    <td>${ticketEntity.toStation.stationName}</td>
                                </tr>
                                <tr>
                                    <td>Mã Số Ghế Ngồi</td>
                                    <td>${ticketEntity.seat.seatName}</td>
                                </tr>
                            </table>
                        </c:if>
                    </div>



                </div>
            </div>




            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
