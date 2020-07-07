package com.kpmk.market.controller;


import com.kpmk.market.form.ItemForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    //private final ItemService itemService;

    @GetMapping("/item")
    public String createItem(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("itemForm", new ItemForm());
        return "createItem";
    }

    @PostMapping("/item")
    public String itemReg(@RequestParam("itemimg") List<MultipartFile> files, ItemForm form) throws Exception {
        String baseDir = "C:\\Users\\Kioni\\Downloads";
        String filePath;
        for(MultipartFile i : files){
            filePath = baseDir + "\\" + i.getOriginalFilename();
            i.transferTo(new File(filePath));
        }
        return "createItem";
    }
}
