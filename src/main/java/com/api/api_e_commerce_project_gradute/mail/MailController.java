package com.api.api_e_commerce_project_gradute.mail;

import com.api.api_e_commerce_project_gradute.bill.BillService;
import com.api.api_e_commerce_project_gradute.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController

public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    BillService billService;

    @GetMapping("sendMailOrders")
    public void sendMailOrder(@RequestParam Long idBill, @RequestParam String email) {
        mailService.mailOrderProduct(billService.getBillById(idBill),email,"");
    }

}
