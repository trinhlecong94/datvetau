package com.mycompany.datvetau.controller;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import com.mycompany.datvetau.entities.NhaGaEntity;
import com.mycompany.datvetau.entities.TauEntity;
import com.mycompany.datvetau.service.LichTrinhService;
import com.mycompany.datvetau.service.NhaGaService;
import com.mycompany.datvetau.service.TauService;
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

    @RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "trang-chu";
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

    @RequestMapping(value = {"/chon-ve"}, method = RequestMethod.GET)
    public String homeChonVe(Model model) {

        List<TauEntity> taus = tauService.getTaus();
        model.addAttribute("taus", taus);
        return "chon-ve";
    }

    @RequestMapping(value = {"/kiem-tra-ve"}, method = RequestMethod.GET)
    public String kiemTraVe(Model model) {
        List<NhaGaEntity> nhaGa = nhaGaService.getNhaGas();
        List<TauEntity> tau = tauService.getTaus();
        
        model.addAttribute("nhaGa", nhaGa);
        model.addAttribute("tau", tau);
        return "kiem-tra-ve";
    }

    @RequestMapping(value = {"/gio-tau-gia-ve"}, method = RequestMethod.GET)
    public String gioTauGiaVe(Model model) {
        List<LichTrinhEntity> lichTrinh = lichTrinhService.getLichTrinhs();
        List<NhaGaEntity> nhaGa = nhaGaService.getNhaGas();
        List<NhaGaEntity> nhaGaHaNoi = nhaGa;
        List<NhaGaEntity> nhaGaSaiGon = nhaGa;
        List<LichTrinhEntity> lichTrinhHaNoi = new ArrayList<>();
        List<LichTrinhEntity> lichTrinhSaiGon = new ArrayList<>();
        int check = 0;
        for (LichTrinhEntity lichTrinhEntity : lichTrinh) {
            String cString = lichTrinhEntity.getTau().getTenTau();
            for (int i = 0; i < cString.length(); i++) {
                if ((cString.charAt(i) <= '9') && (cString.charAt(i) >= '0')) {
                    check = check * 10 + cString.charAt(i) - 48;
                }
            }
            if (check % 2 == 0) {
                lichTrinhHaNoi.add(lichTrinhEntity);
                System.out.println("Ha Noi");
            } else {
                lichTrinhSaiGon.add(lichTrinhEntity);
            }
            check = 0;
        }
        model.addAttribute("nhaGaHaNoi", nhaGaHaNoi);
        model.addAttribute("lichTrinhHaNoi", lichTrinhHaNoi);
        model.addAttribute("nhaGaSaiGon", nhaGaSaiGon);
        model.addAttribute("lichTrinhSaiGon", lichTrinhSaiGon);
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
