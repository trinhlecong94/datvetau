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
                <div class="col-5 border">
                    <h5>Thông Tin Hành Trình</h5> 
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Chọn Tàu Cần Kiểm Tra</label>
                            <input class="form-control" list="trainName" name="trainName">
                            <datalist id="trainName">
                                <c:forEach var="train" items="${trains}">
                                    <option value="${train.trainName}"> 
                                    </c:forEach>
                            </datalist>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <div class="col-7 border">
             
                    <c:if test="${size != 0 }">
                        <table class="table table-bordered">
                            <br>
                            <h5>Thông tin hành trình</h5>  <br>
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Ga</th>
                                    <th>Thời Gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="time" items="${train.trainArrivalTime}">
                                    <tr>
                                        <td>${time.noStation}</td>
                                        <td>${time.station.stationName}</td>
                                        <td>${time.timeTrain}</td>
                                    </tr>
                                </c:forEach>  
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
