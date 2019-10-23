package com.mycompany.datvetau.controller;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import com.mycompany.datvetau.entities.NhaGaEntity;
import com.mycompany.datvetau.service.LichTrinhService;
import com.mycompany.datvetau.service.NhaGaService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private LichTrinhService lichTrinhService;

    @Autowired
    private NhaGaService nhaGaService;

    @RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "trang-chu";
    }

    @RequestMapping(value = {"/thong-tin-dat-cho"}, method = RequestMethod.GET)
    public String thongTinDatCho(Model model) {
        return "thong-tin-dat-cho";
    }

    @RequestMapping(value = {"/kiem-tra-ve"}, method = RequestMethod.GET)
    public String kiemTraVe(Model model) {
        return "kiem-tra-ve";
    }

    @RequestMapping(value = {"/gio-tau-gia-ve"}, method = RequestMethod.GET)
    public String gioTauGiaVe(Model model) {
        List<LichTrinhEntity> lichTrinh = lichTrinhService.getLichTrinhs();
        List<NhaGaEntity> nhaGa = nhaGaService.getNhaGas();

        List<NhaGaEntity> nhaGaHaNoi = nhaGa;
        List<NhaGaEntity> nhaGaSaiGon = nhaGa;

        List<LichTrinhEntity> lichTrinhHaNoi = new ArrayList<LichTrinhEntity>();
        List<LichTrinhEntity> lichTrinhSaiGon = new ArrayList<LichTrinhEntity>();
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
            } else {
                lichTrinhSaiGon.add(lichTrinhEntity);
            }
            check = 0;

        }

        model.addAttribute("nhaGaHaNoi", nhaGaHaNoi);
        model.addAttribute("lichTrinhHaNoi", lichTrinhHaNoi);

        model.addAttribute("nhaGaSaiGon", nhaGaSaiGon);
        model.addAttribute("lichTrinhHaNoi", lichTrinhSaiGon);

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
