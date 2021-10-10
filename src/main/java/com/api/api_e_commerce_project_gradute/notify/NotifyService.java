package com.api.api_e_commerce_project_gradute.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class NotifyService {

  @Autowired
  NotifyRepository notifyRepository;

  public List<Notify> getNotifyByIdUser(String idUser,Integer offset,Integer limit) {
    if (offset != null && limit != null)
      return notifyRepository.getNotifyByIdUserLimit(idUser,offset,limit);
    else
      return notifyRepository.getNotifyByIdUserAll(idUser);
  }

  public Notify addNotify(Notify notify) {
    notify.setTimeCreated(new Timestamp(new Date().getTime()));
    return notifyRepository.save(notify);
  }

  public Notify updateNotify(Notify notify) {
    return notifyRepository.save(notify);
  }

  public void deleteNotify(Notify notify) {
    notifyRepository.delete(notify);
  }

}
