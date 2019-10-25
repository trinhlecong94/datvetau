package com.mycompany.datvetau.controller;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import com.mycompany.datvetau.entities.NhaGaEntity;
import com.mycompany.datvetau.entities.TauEntity;
import com.mycompany.datvetau.entities.VeTauEntity;
import com.mycompany.datvetau.service.LichTrinhService;
import com.mycompany.datvetau.service.NhaGaService;
import com.mycompany.datvetau.service.TauService;
import com.mycompany.datvetau.service.VeTauService;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private LichTrinhService lichTrinhService;

    @Autowired
    private TauService tauService;

    @Autowired
    private NhaGaService nhaGaService;

    @Autowired
    private VeTauService veTauService;

    @RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<NhaGaEntity> nhaGa = nhaGaService.getNhaGas();
        model.addAttribute("nhaGa", nhaGa);
        return "trang-chu";
    }

    @RequestMapping(value = {"/chon-ve"}, method = RequestMethod.GET)
    public String homeChonVe(Model model,
            @RequestParam("loaiVe") String loaiVe,
            @RequestParam("gaDi") String gaDi,
            @RequestParam("gaDen") String gaDen,
            @RequestParam("ngayDi") String ngayDi,
            @RequestParam("ngayVe") String ngayDen) {

        model.addAttribute("loaiVe", loaiVe);
        model.addAttribute("gaDi", gaDi);
        model.addAttribute("gaDen", gaDen);
        model.addAttribute("ngayDi", ngayDi);
        model.addAttribute("ngayDen", ngayDen);

        List<TauEntity> taus = tauService.getTaus();
        model.addAttribute("taus", taus);
        return "chon-ve";
    }

    @RequestMapping(value = {"/thanh-toan"}, method = RequestMethod.GET)
    public String thanhToan(Model model, @RequestParam("vitri") String[] ghe, @RequestParam("tau") String tau, @RequestParam("toa") String toa) {
        if (ghe != null) {
            model.addAttribute("ghe", ghe);
            model.addAttribute("tau", tau);
            model.addAttribute("toa", toa);
            return "thanh-toan";
        }
        return "trang-chu";
    }

    @RequestMapping(value = {"/thanh-cong"}, method = RequestMethod.GET)
    public String thanhCong(Model model, HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        boolean checkCookie = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("code")) {
                    model.addAttribute("code", cookie.getValue());
                    checkCookie = true;
                }
            }
        }
        if (!checkCookie) {
            long code = (int) ((Math.random() * ((999999999 - 100000000) + 1)) + 100000000);
            Cookie ck = new Cookie("code", Long.toString(code));
            ck.setMaxAge(30 * 60);
            response.addCookie(ck);
            model.addAttribute("code", code);
        }
        return "thanh-cong";
    }

    @RequestMapping(value = {"/kiem-tra-ve"}, method = RequestMethod.GET)
    public String kiemTraVe(Model model) {
        List<TauEntity> tau = tauService.getTaus();
        model.addAttribute("tau", tau);
        return "kiem-tra-ve";
    }

    @RequestMapping(value = {"/ket-qua-kiem-tra"}, method = RequestMethod.GET)
    public String ketQuaKiemTra(Model model,
            @RequestParam("maVe") String maVe,
            @RequestParam("soGiayTo") String soGiayTo) {
        List<TauEntity> tau1 = tauService.getTaus();
        List<VeTauEntity> veTaus = veTauService.findAllTicketByCode(maVe);
        VeTauEntity ticketEntity = null;
        for (VeTauEntity ticket : veTaus) {
            if (ticket.getMaSoNhanThan().equalsIgnoreCase(soGiayTo)) {
                ticketEntity = ticket;
            }
        }
        if (ticketEntity == null) {
            model.addAttribute("errorMessages", "Vé Không Tồn Tại");
        }
        model.addAttribute("ticketEntity", ticketEntity);
        return "ket-qua-kiem-tra";
    }

    @RequestMapping(value = {"/gio-tau-gia-ve"}, method = RequestMethod.GET)
    public String gioTauGiaVe(Model model,
            @RequestParam(value = "trainName", required = false) String trainName) {
        List<TauEntity> trains = tauService.getTaus();
        TauEntity train = tauService.getTrain(trainName);
        LichTrinhEntity schedule = lichTrinhService.getSchedule(train);
        model.addAttribute("trains", trains);
        model.addAttribute("schedule", schedule);
        return "gio-tau-gia-ve";
    }

    @RequestMapping(value = {"/khuyen-mai"}, method = RequestMethod.GET)
    public String khuyenMai(Model model) {
        return "khuyen-mai";
    }

    @RequestMapping(value = {"/cac-qui-dinh"}, method = RequestMethod.GET)
    public String cacQuyDinh(Model model) {
        return "cac-qui-dinh";
    }

    @RequestMapping(value = {"/huong-dan"}, method = RequestMethod.GET)
    public String huongDan(Model model) {
        return "huong-dan";
    }

    @RequestMapping(value = {"lien-he"}, method = RequestMethod.GET)
    public String lienHe(Model model) {
        return "lien-he";
    }
}
