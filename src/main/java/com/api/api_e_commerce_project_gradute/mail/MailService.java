package com.api.api_e_commerce_project_gradute.mail;

import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillDetailFull;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.jwt.TokenJWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;

@Service
public class MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  public DataSendMail sendMail(DataSendMail dataSendMail) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
      messageHelper.setFrom("ShopHsmart");
      messageHelper.setTo(dataSendMail.getEmail());
      messageHelper.setSubject(dataSendMail.getTopic());
      messageHelper.setText(codeRegister(dataSendMail.getUser().getFirstName() + " " + dataSendMail
              .getUser().getLastName(),dataSendMail.getBody(),dataSendMail.getUser().getId()),true);
      javaMailSender.send(mimeMessage);
    } catch (Exception ex) {
    }
    return dataSendMail;
  }

  public void mailOrderProduct(BillFull billFull,String email,String topic) {
    String content = "";
    Integer total = 0;
    for (BillDetailFull billDetailFull: billFull.getBillDetailList()) {
      total += billDetailFull.getBillDetail().getPrice();
      content += "<div class=\"item\">\n" +
              "        <div class=\"item_index\">1</div>\n" +
              "        <img\n" +
              "          src='" + billDetailFull.getProductFull().getImage().getSrc() + "'" +
              "          alt=\"\"\n" +
              "          class=\"item-image\"\n" +
              "        />\n" +
              "        <div class=\"item_info\">\n" +
              "          <p style=\"font-weight: bold\">" + billDetailFull.getProductFull().getNameLineProduct() + "</p>\n" +
              "          <p style=\"font-weight: bold\">S??? l?????ng : " + new DecimalFormat("###,###,###").format(
                          billDetailFull.getBillDetail().getPrice()) + " x " + billDetailFull.getBillDetail().getAmount() + " </p>\n" +
              "          <p style=\"font-weight: bold\">M??u : " + billDetailFull.getProductFull().getImage().
                          getColorProduct().getDescription() + "</p>\n" +
              "        </div>\n" +
              "      </div>";
    }
    String main = orderProduct(content,billFull.getBill(),total);
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
      messageHelper.setFrom("ShopHsmart");
      messageHelper.setTo(email);
      messageHelper.setSubject(topic);
      messageHelper.setText(main,true);
      javaMailSender.send(mimeMessage);
    } catch (Exception ex) {
    }
  }

  public String codeRegister(String fullName,String code,String idUser) {
    StringBuilder string = new StringBuilder();
    string.append("<!DOCTYPE html>")
            .append("<html lang=\"en\">")
            .append("  <head>")
            .append("    <meta charset=\"UTF-8\" />")
            .append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />")
            .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />")
            .append("    <title>Document</title>")
            .append("    <style>")
            .append("      @media screen and (min-width: 800px) {")
            .append("        #content__main {")
            .append("          width: 55%;")
            .append("        }")
            .append("      }")
            .append("      #content__main {")
            .append("        width: 98%;")
            .append("      }")
            .append("    </style>")
            .append("  </head>")
            .append("  <body>")
            .append("    <div id=\"content__main\" style=\"margin: 20px auto; color: rgb(68, 67, 67)\">")
            .append("      <img")
            .append("        src=\"https://res.cloudinary.com/huongdev2k1/image/upload/v1633739150/E-Commerce/Config/logo.png\"")
            .append("        style=\"width: 160px; object-fit: cover; margin: auto\"")
            .append("        alt=\"\"")
            .append("      />")
            .append("      <div style=\"width: 100%; padding: 12px; border: 2px solid #f36438;box-sizing : border-box;\">")
            .append("        <br />")
            .append("        Hi " + fullName + " , <br /><br />")
            .append("        Thanks for signing up for Hsmart <br /><br />")
            .append("        To activate your account, please verify your email address: <br /><br />")
            .append("        <br />")
            .append("        <a")
            .append("          href=\"http://localhost:3000/verify/account/register?access_token="
                    + TokenJWTUtils.generateJwt(idUser) + "\"")
            .append("          style=\"")
            .append("            text-decoration: none;")
            .append("            outline: none;")
            .append("            background-color: white;")
            .append("            font-weight: bold;")
            .append("            border: 2px solid #f36438;")
            .append("            padding: 12px 24px;")
            .append("            color: #f36438;")
            .append("          \"")
            .append("        >")
            .append("          Verify your email")
            .append("        </a>")
            .append("        <br />")
            .append("        <br />")
            .append("        <br />")
            .append("        <b>Or</b>")
            .append("        <br />")
            .append("        <br />")
            .append("        Code : <b>" + code + "</b>")
            .append("      </div>")
            .append("    </div>")
            .append("  </body>")
            .append("</html>");

    return string.toString();

  }

  public String orderProduct(String contentAllItem, Bill bill,Integer total) {
    long EXPIRATION_TIME = 3_600; // 1 day
    StringBuilder string = new StringBuilder();
    string.append("<!DOCTYPE html>")
    .append("<html lang=\"en\">")
    .append("  <head>")
    .append("    <meta charset=\"UTF-8\" />")
    .append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />")
    .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />")
    .append("    <title>Document</title>")
    .append("")
    .append("    <style>")
    .append("        ")
    .append("      @media screen and (min-width: 700px) {")
    .append("        #content__main {")
    .append("          width: 50%;")
    .append("        }")
    .append("      }")
    .append("      * {")
    .append("        text-decoration: none;")
    .append("      }")
    .append("      #content__main {")
    .append("        width: 95%;")
    .append("      }")
    .append("      .item {")
    .append("        width: 100%;")
    .append("        display: flex;")
    .append("        padding: 5px 0px;")
    .append("        border-width: 2px;")
    .append("        border-bottom: solid;")
    .append("        border-top: solid;")
    .append("        border-color: rgb(194, 191, 191);")
    .append("      }")
    .append("      .item_index {")
    .append("        font-weight: bold;")
    .append("        display: flex;")
    .append("        padding: 0px 4px;")
    .append("        border-right: 2px solid rgb(194, 191, 191);")
    .append("        align-items: center;")
    .append("      }")
    .append("      .item-image {")
    .append("        margin-left: 8px;")
    .append("        width: 100px;")
    .append("        height: 100px;")
    .append("        object-fit: cover;")
    .append("        margin-right: 8px;")
    .append("      }")
    .append("      .item-info {")
    .append("        display: flex;")
    .append("        align-items: center;")
    .append("      }")
    .append("      .item-info p {")
    .append("        display: block;")
    .append("      }")
    .append("    </style>")
    .append("  </head>")
    .append("  <body>")
    .append("    <div id=\"content__main\" style=\"margin: 20px auto\">")
    .append("      <img")
    .append("        src=\"https://res.cloudinary.com/huongdev2k1/image/upload/v1633739150/E-Commerce/Config/logo.png\"")
    .append("        style=\"width: 160px; object-fit: cover; margin: auto\"")
    .append("        alt=\"\"")
    .append("      />")
    .append("      <div style=\"width: 100%; padding: 12px; box-sizing: border-box\">")
    .append("        Xin ch??o " + bill.getFullName())
    .append("        <br />")
    .append("        <br />")
    .append("        ????n h??ng c???a b???n ???? ?????t v??o l??c " + bill.getTimeCreated())
    .append("        <br />")
    .append("        <br />")
    .append("        Vui l??ng ki???m tra th??ng tin ????n h??ng b??n d?????i v?? b???m x??c nh???n ????n h??ng")
    .append("        <br />")
    .append("        <br />")
    .append("      </div>")
    .append("      <hr />")
    .append("      <br />")
    .append("      <b>TH??NG TIN ????N H??NG - D??NH CHO NG?????I MUA</b>")
    .append("      <br />")
    .append("      <br />")
    .append("      M?? ????n h??ng : #" + bill.getId())
    .append("      <br /><br />")
    .append("      Ng??y ?????t h??ng : " + bill.getTimeCreated())
    .append("      <br /><br />")
    .append("      Th???i gian giao h??ng d??? ki???n : " + bill.getTimeIntend())
    .append("      <br />")
    .append("      <hr />")
    .append("      <br />")
    .append(contentAllItem)
    .append("      <div>")
    .append("        <p>T???ng ti???n : " + new DecimalFormat("###,###,###").format(total) + "??</p>")
    .append("        <p>Ph?? v???n chuy???n : " + new DecimalFormat("###,###,###").format(bill.getFee()) + "??</p>")
    .append("        <p>Gi???m gi?? : " + new DecimalFormat("###,###,###").format(bill.getSale()) + "??</p>")
    .append("        <p>T???ng thanh to??n : " + new DecimalFormat("###,###,###").format(bill.getTotal()) + "</p>")
    .append("")
    .append("        <di style=\"display: flex; justify-content: center;\">")
    .append("          <a href='http://localhost:3000/verify/bill/customer?access_token=" + TokenJWTUtils.generateJwtByTime(
            String.valueOf(bill.getId()),EXPIRATION_TIME) + "&type="+ TokenJWTUtils.generateJwtByTime(String.valueOf(-1),EXPIRATION_TIME)
            + "' style=\"padding: 12px 24px;border: 2px solid gray;color: white;background-color : gray; font-weight: bold; margin: 0px 10px;\">")
    .append("            H???y ????n h??ng")
    .append("          </a>")
    .append("          <a href='http://localhost:3000/verify/bill/customer?access_token=" + TokenJWTUtils.generateJwtByTime(
                       String.valueOf(bill.getId()),EXPIRATION_TIME) + "&type=" +
            TokenJWTUtils.generateJwtByTime(String.valueOf(0),EXPIRATION_TIME) +"'" +
            " style=\"padding: 12px 24px;border: 2px solid #f36438;background-color: white; color:  #f36438;font-weight: bold; margin: 0px 10px;\">")
    .append("            X??c nh???n ????n h??ng")
    .append("          </a>")
    .append("        </div>")
    .append("")
    .append("        <p>Tr??n tr???ng</p>")
    .append("        <p>?????i ng??? HSmart</p>")
    .append("      </div>")
    .append("    </div>")
    .append("  </body>")
    .append("</html>");
    return string.toString();
  }

  public void sendMailContact(DataMail dataMail) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
      messageHelper.setFrom("ServicesHsmart");
      messageHelper.setTo(dataMail.getEmail());
      messageHelper.setSubject(dataMail.getTopic());
      messageHelper.setText(dataMail.getContent(),true);
      javaMailSender.send(mimeMessage);
    } catch (Exception ex) {
    }
  }

}
