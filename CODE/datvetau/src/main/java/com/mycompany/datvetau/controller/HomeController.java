package com.mycompany.datvetau.controller;

import com.mycompany.datvetau.entities.CarriageTrainEntity;
import com.mycompany.datvetau.entities.ScheduleEntity;
import com.mycompany.datvetau.entities.SeatEntity;
import com.mycompany.datvetau.entities.StationEntity;
import com.mycompany.datvetau.entities.TrainEntity;
import com.mycompany.datvetau.entities.TicketEntity;
import com.mycompany.datvetau.entities.TrainArrivalTimeEntity;
import com.mycompany.datvetau.service.CarriageTrainService;
import com.mycompany.datvetau.service.ScheduleService;
import com.mycompany.datvetau.service.SeatService;
import com.mycompany.datvetau.service.StationService;
import com.mycompany.datvetau.service.TrainService;
import com.mycompany.datvetau.service.TicketService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private CarriageTrainService carriageTrainService;

    @RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<StationEntity> stations = stationService.findAllStation();
        model.addAttribute("stations", stations);
        return "trang-chu";
    }
    @RequestMapping(value = {"/chon-tau"}, method = RequestMethod.GET)
    public String chooseTrain(Model model, HttpSession session,
            @RequestParam("fromStation") String fromStation,
            @RequestParam("toStation") String toStation,
            @RequestParam("departureDate") String departureDate) {
        session.setAttribute("fromStation", fromStation);
        session.setAttribute("toStation", toStation);
        session.setAttribute("departureDate", departureDate);
        {
            List<ScheduleEntity> scheduleEntity = scheduleService.findScheduleByDate(java.sql.Date.valueOf(departureDate));
            List<TrainEntity> trains = new ArrayList<>();
            for (ScheduleEntity schedule : scheduleEntity) {
                List<TrainArrivalTimeEntity> trainArrivalTimes = schedule.getTrain().getTrainArrivalTime();
                int temp = 0;
                int index = 1;
                int noFromStation = Integer.MAX_VALUE;
                int noToStation = Integer.MIN_VALUE;
                for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                    if (trainArrivalTime.getStation().getStationName() == null ? fromStation == null : trainArrivalTime.getStation().getStationName().equals(fromStation)) {
                        temp += 1;
                        noFromStation = index;
                    }
                    if (trainArrivalTime.getStation().getStationName() == null ? toStation == null : trainArrivalTime.getStation().getStationName().equals(toStation)) {
                        temp += 1;
                        noToStation = index;
                    }
                    index += 1;
                }
                if (noFromStation < noToStation) {
                    trains.add(schedule.getTrain());
                }
            }
            model.addAttribute("trains", trains);
        }
        return "chon-tau";
    }

    @RequestMapping(value = {"/chon-ve"}, method = RequestMethod.GET)
    public String chooseTicket(Model model, HttpSession session, String trainName) {

        String fromStation = (String) session.getAttribute("fromStation");
        String toStation = (String) session.getAttribute("toStation");
        String departureDate = (String) session.getAttribute("departureDate");

        // tìm tàu thỏa điều kiện có ga đến và đi
        List<ScheduleEntity> scheduleEntity = scheduleService.findScheduleByDateAndTrain(java.sql.Date.valueOf(departureDate), trainService.findTrainByName(trainName));

        TrainEntity train = new TrainEntity();

        for (ScheduleEntity schedule : scheduleEntity) {
            List<TrainArrivalTimeEntity> trainArrivalTimes = schedule.getTrain().getTrainArrivalTime();
            int temp = 0;
            int index = 1;
            int noFromStation = Integer.MAX_VALUE;
            int noToStation = Integer.MIN_VALUE;
            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                if (trainArrivalTime.getStation().getStationName() == null ? fromStation == null : trainArrivalTime.getStation().getStationName().equals(fromStation)) {
                    temp += 1;
                    noFromStation = index;
                }
                if (trainArrivalTime.getStation().getStationName() == null ? toStation == null : trainArrivalTime.getStation().getStationName().equals(toStation)) {
                    temp += 1;
                    noToStation = index;
                }
                index += 1;
            }

            if (noFromStation < noToStation) {
                List<CarriageTrainEntity> carriageTrains = schedule.getTrain().getCarriageTrains();
                for (CarriageTrainEntity carriageTrain : carriageTrains) {
                    List<SeatEntity> seats = carriageTrain.getSeats();
                    for (SeatEntity seat : seats) {
                        seat.setStatus(true);
                        List<TicketEntity> tickets = ticketService.findAllTicketByDateAndSeat(java.sql.Date.valueOf(departureDate), seat);
                        for (TicketEntity ticket : tickets) {
                            int index_1 = 1;
                            int noFromStation_1 = Integer.MAX_VALUE;
                            int noToStation_1 = Integer.MIN_VALUE;
                            for (TrainArrivalTimeEntity trainArrivalTime : trainArrivalTimes) {
                                if (trainArrivalTime.getStation().getStationName().equals(ticket.getFromSation().getStationName())) {
                                    noFromStation_1 = index_1;
                                }
                                if (trainArrivalTime.getStation().getStationName().equals(ticket.getToStation().getStationName())) {
                                    noToStation_1 = index_1;
                                }
                                index_1 += 1;
                            }
                            if (((noFromStation < noFromStation_1) && (noFromStation_1 < noToStation))
                                    || ((noFromStation < noToStation_1) && (noFromStation_1 < noToStation_1))) {
                                seat.setStatus(false);
                            }
                        }
                    }
                }
                train = schedule.getTrain();
            }
        }
        model.addAttribute("train", train);
        return "chon-ve";
    }

    @RequestMapping(value = {"/thanh-toan"}, method = RequestMethod.GET)
    public String paymentPage(Model model,
            @RequestParam("seatsID") String[] seatsID,
            @RequestParam("train") String train) {
        if (seatsID != null) {
            model.addAttribute("seatsID", seatsID);
            model.addAttribute("train", train);
            model.addAttribute("carriageTrain", carriageTrainService.findCarriageTrainBySeatId(Integer.parseInt(seatsID[0])));
            return "thanh-toan";
        }
        return "trang-chu";
    }

    @RequestMapping(value = {"/thanh-cong"}, method = RequestMethod.GET)
    public String paymentSuccessPage(Model model, HttpServletResponse response,
            HttpServletRequest request,
            HttpSession session,
            @RequestParam("seatID") String[] seatID,
            @RequestParam("fullName") String[] fullName,
            @RequestParam("identityNumber") String[] identityNumber) throws InterruptedException {

        Cookie[] cookies = request.getCookies();
        long code = 0;
        boolean checkCookie = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("code")) {
                    code = Long.parseLong(cookie.getValue());
                    model.addAttribute("code", cookie.getValue());
                    checkCookie = true;
                }
            }
        }
        if (!checkCookie) {
            code = (int) ((Math.random() * ((999999999 - 100000000) + 1)) + 100000000);
            Cookie ck = new Cookie("code", Long.toString(code));
            ck.setMaxAge(30 * 60);
            response.addCookie(ck);
            model.addAttribute("code", code);
        }
        for (int i = 0; i < identityNumber.length; i++) {
            TicketEntity ticket = new TicketEntity();
            ticket.setCode(String.valueOf(code));
            ticket.setFullName(fullName[i]);
            ticket.setIdentityNumber(identityNumber[i]);
            ticket.setSeat(seatService.findSeatById(Integer.parseInt(seatID[i])));
            java.sql.Date d = java.sql.Date.valueOf((String) session.getAttribute("departureDate"));
            ticket.setDepartureTime(d);
            ticket.setToStation(stationService.findStationByName((String) session.getAttribute("toStation")));
            ticket.setFromSation(stationService.findStationByName((String) session.getAttribute("fromStation")));
            ticketService.saveTicket(ticket);
        }
        return "thanh-cong";
    }

    @RequestMapping(value = {"/kiem-tra-ve"}, method = RequestMethod.GET)
    public String checkTicketPage(Model model,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "identityNumber", required = false) String identityNumber) {
        if ((code != null) && (identityNumber != null)) {
            List<TrainEntity> train = trainService.findAllTrain();
            List<TicketEntity> tickets = ticketService.findAllTicketByCode(code);
            TicketEntity ticketEntity = null;
            for (TicketEntity ticket : tickets) {
                if (ticket.getIdentityNumber().equalsIgnoreCase(identityNumber)) {
                    ticketEntity = ticket;
                }
            }
            if (ticketEntity == null) {
                model.addAttribute("errorMessages", "Vé Không Tồn Tại");
            } else {
                model.addAttribute("succesMessages", "Tra cứu Thành Công");
            }
            model.addAttribute("ticketEntity", ticketEntity);
        }
        return "kiem-tra-ve";
    }

    @RequestMapping(value = {"/gio-tau-gia-ve"}, method = RequestMethod.GET)
    public String schedulePage(Model model,
            @RequestParam(value = "trainName", required = false) String trainName) {
        List<TrainEntity> trains = trainService.findAllTrain();
        TrainEntity train = trainService.findTrainByName(trainName);
        if (train != null) {
            model.addAttribute("size", train.getTrainArrivalTime().size());
        }
        model.addAttribute("trains", trains);
        model.addAttribute("train", train);
        return "gio-tau-gia-ve";
    }

    @RequestMapping(value = {"/khuyen-mai"}, method = RequestMethod.GET)
    public String promotionPage(Model model) {
        return "khuyen-mai";
    }

    @RequestMapping(value = {"/cac-qui-dinh"}, method = RequestMethod.GET)
    public String regulationsPage(Model model) {
        return "cac-qui-dinh";
    }

    @RequestMapping(value = {"lien-he"}, method = RequestMethod.GET)
    public String contactPage(Model model
    ) {
        return "lien-he";
    }
}
