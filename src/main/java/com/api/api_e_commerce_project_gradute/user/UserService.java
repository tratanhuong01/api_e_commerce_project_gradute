package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.DTO.AccountLogin;
import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import com.api.api_e_commerce_project_gradute.DTO.SendPhone;
import com.api.api_e_commerce_project_gradute.DTO.UserDetail;
import com.api.api_e_commerce_project_gradute.DTO.specification.user.UserCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.user.UserFull;
import com.api.api_e_commerce_project_gradute.DTO.specification.user.UserSpecifications;
import com.api.api_e_commerce_project_gradute.config.Config;
import com.api.api_e_commerce_project_gradute.jwt.TokenJWTUtils;
import com.api.api_e_commerce_project_gradute.mail.MailService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MailService mailService;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(String idUser) {
    return userRepository.getUserByIdUser(idUser);
  }

  public User addUser(User user) {
    if (user.getId() != null) {
    }
    else {
      User userBestNew = userRepository.getIdBestNew();
      int id = Config.ID_USER_DEFAULT;
      if (userBestNew == null) {
      }
      else {
        id = Integer.parseInt(userBestNew.getId());
        id++;
      }
      user.setId(String.valueOf(id));
      if (user.getPassword() != null)
        user.setPassword(DigestUtils.md5Hex(user.getPassword()).toUpperCase());
      user.setTimeCreated((new Timestamp(new Date().getTime())));
    }
    return userRepository.save(user);
  }

  public List<User> getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  public List<User> getUserByPhone(String phone) {
    return userRepository.getUserByPhone(phone);
  }

  public User checkLogin(AccountLogin accountLogin) {
    return userRepository.checkLogin(accountLogin.getEmailOrPhone(),
            DigestUtils.md5Hex(accountLogin.getPassword()).toUpperCase());
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  public UserDetail checkLoginJWT(AccountLogin accountLogin) {
    User user = userRepository.checkLogin(accountLogin.getEmailOrPhone(),
            DigestUtils.md5Hex(accountLogin.getPassword()).toUpperCase());
    return returnUserDetailByUser(user);
  }

  public UserDetail verifyAccountJWT(AccountLogin accountLogin) {
    User user = userRepository.checkLogin(accountLogin.getEmailOrPhone(),
            accountLogin.getPassword());
    UserDetail userDetail = new UserDetail();
    if (user != null) {
      userDetail.setUser(user);
      userDetail.setToken(TokenJWTUtils.generateJwt(user.getId()));
      userDetail.setMessage("Success");
    }
    return userDetail;
  }

  public UserDetail returnUserDetailByUser(User user) {
    UserDetail userDetail = new UserDetail();
    if (user != null) {
      switch (user.getStatus()) {
        case 0 :
          if (user.getIsVerifyEmail() == 0 && user.getIsVerifyPhone() == 0) {
            userDetail.setUser(user);
            userDetail.setToken(null);
            userDetail.setMessage("Vui lòng xác minh tài khoản");
            userDetail.setStatus(201);
          }
          else {
            userDetail.setUser(user);
            userDetail.setToken(TokenJWTUtils.generateJwt(user.getId()));
            userDetail.setMessage("Success");
            userDetail.setStatus(200);
          }
          break;
        case 1 :
          userDetail.setUser(null);
          userDetail.setToken(null);
          userDetail.setMessage("Tài khoản của bạn đã bị tạm khóa.. Vui lòng thử lại sau..");
          userDetail.setStatus(202);
          break;
        case 2 :
          userDetail.setUser(null);
          userDetail.setToken(null);
          userDetail.setMessage("Tài khoản của bạn đã bị  khóa vĩnh viễn .. ");
          userDetail.setStatus(201);
          break;
        default:
          userDetail.setUser(null);
          userDetail.setToken(null);
          userDetail.setMessage("Thông tin đăng nhập không chinh xác !");
          break;
      }
      return userDetail;
    }
    else {
      userDetail.setUser(null);
      userDetail.setToken(null);
      userDetail.setMessage("Thông tin đăng nhập không chinh xác !");
    }
    return userDetail;
  }

  public User searchUserByEmailOrPhone(String emailOrPhone) {
    return userRepository.searchUserByEmailOrPhone(emailOrPhone);
  }

  public UserDetail adminCheckLoginJWT(AccountLogin accountLogin) {
    User user = userRepository.adminCheckLogin(accountLogin.getEmailOrPhone(),
            DigestUtils.md5Hex(accountLogin.getPassword()).toUpperCase());
    if (user != null) {
      UserDetail userDetail = new UserDetail();
      userDetail.setUser(user);
      userDetail.setToken(TokenJWTUtils.generateJwt(user.getId()));
      userDetail.setMessage("Success");
      return userDetail;
    }
    return null;
  }

  public UserDetail getUserFromJWT(String token) {
    if (token != null) {
      String idUser = TokenJWTUtils.parseTokenJWT(token);
      User user = userRepository.getUserByIdUser(idUser);
      UserDetail userDetail = new UserDetail();
      userDetail.setUser(user);
      userDetail.setToken(TokenJWTUtils.generateJwt(user.getId()));
      userDetail.setMessage("Success");
      return userDetail;
    }
    return null;
  }

  public String checkPasswordUser(String idUser,String password) {
    return userRepository.checkPasswordUser(idUser,DigestUtils.md5Hex(password).toUpperCase());
  }

  public String updateCodeEmail(User user) {
    DataSendMail dataSendMail = new DataSendMail();
    Random rnd = new Random();
    int number = rnd.nextInt(9999999);
    dataSendMail.setEmail(user.getEmail());
    dataSendMail.setBody(String.valueOf(number));
    dataSendMail.setTopic("Verify Account Register In Website");
    dataSendMail.setUser(user);
    mailService.sendMail(dataSendMail);
    userRepository.updateCodeEmail(String.valueOf(number),user.getId());
    return String.valueOf(number);
  }

  public String updateCodePhone(User user) {
    Random rnd = new Random();
    int number = rnd.nextInt(9999999);
    new SendPhone().sendCodePhone(user.getPhone());
    userRepository.updatePhone(String.valueOf(number),user.getId());
    return String.valueOf(number);
  }

  public List<User> getAllUsersLimit(int type,int offset,int limit) {
    return userRepository.getAllUsersLimit(type,offset, limit);
  }

  public int updatePasswordUser(String password,String idUser) {
    return userRepository.updatePasswordUser(DigestUtils.md5Hex(password),idUser);
  }

  public User getTeleSupport() {
    List<User> userList = userRepository.getTeleSupport();
    if (userList.size() == 0)
      return null;
    else
      return userList.get(0 + (int)(Math.random() * (((userList.size() - 1) - 0) + 1)));
  }

  public List<User> getUserByTypeLimit(String idRole,int offset,int limit) {
    return userRepository.getUserByTypeLimit(idRole,offset,limit);
  }

  public Integer filterUserAll(UserCriteria userCriteria) {
    Specification<User> userSpecification = UserSpecifications.createUserSpecification(userCriteria);
    List<User> userList = userRepository.findAll(userSpecification);
    return userList.size();
  }

  public List<UserFull> filterUserLimit(UserCriteria userCriteria) {
    Specification<User> userSpecification = UserSpecifications.createUserSpecification(userCriteria);
    Pageable pageable = PageRequest.of(userCriteria.getOffset(),userCriteria.getLimit());
    Page<User> userList = userRepository.findAll(userSpecification,pageable);
    List<UserFull> userFullList = new ArrayList<>();
    for (User user : userList) {
      UserFull userFull = new UserFull();
      userFull.setId(user.getId());
      userFull.setFirstName(user.getFirstName());
      userFull.setLastName(user.getLastName());
      userFull.setAvatar(user.getAvatar());
      userFull.setBirthday(user.getBirthday());
      userFull.setCodeEmail(user.getCodeEmail());
      userFull.setCodePhone(user.getCodePhone());
      userFull.setIsVerifyEmail(user.getIsVerifyEmail());
      userFull.setIsVerifyPhone(user.getIsVerifyPhone());
      userFull.setType(user.getType());
      userFull.setTimeCreated(user.getTimeCreated());
      userFull.setSex(user.getSex());
      userFull.setPassword(user.getPassword());
      userFull.setPhone(user.getPhone());
      userFull.setEmail(user.getEmail());
      userFull.setStatus(user.getStatus());
      userFull.setAmountProduct(userRepository.countProductBuyByUser(user.getId()));
      userFull.setAmountOrder(userRepository.countBillByUser(user.getId()));
      userFull.setIsRegister(user.getIsRegister());
      userFull.setUserRole(user.getUserRole());
      userFullList.add(userFull);
    }
    return userFullList;
  }
  //

  public int updateStatusUser(Integer status,String id) {
    return userRepository.updateStatusUser(status,id);
  }

  public List<User> getUserByIdRole(String role) {
    return userRepository.getUserByIdRole(role);
  }

  public UserDetail checkEmailHave(String email) {
    UserDetail userDetail = null;
    User user = userRepository.checkEmailHave(email);
    if (user != null) {
      userDetail = new UserDetail();
      userDetail.setUser(user);
      userDetail.setStatus(200);
      userDetail.setToken(TokenJWTUtils.generateJwt(user.getId()));
    }
    return userDetail;
  }

  public User checkPassword(String password,String idUser) {
    return userRepository.checkPassword(DigestUtils.md5Hex(password).toUpperCase(),idUser);
  }

  public int updatePhone(String phone,String idUser) {
    return userRepository.updatePhone(phone, idUser);
  }

  public int updateEmail(String email,String idUser) {
    return userRepository.updatePhone(email, idUser);
  }

}
