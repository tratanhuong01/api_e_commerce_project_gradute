package com.api.api_e_commerce_project_gradute.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class NotifyController {

  @Autowired
  NotifyService notifyService;

  @GetMapping("notifies")
  public List<Notify> getNotifyByIdUserAll(@RequestParam(required = false) String idUser,
                                    @RequestParam(required = false)  Integer offset,
                                    @RequestParam(required = false) Integer limit) {
    return notifyService.getNotifyByIdUser(idUser,offset,limit);
  }

  @PostMapping("notifies")
  public Notify addNotify(@RequestBody Notify notify) {
    return notifyService.addNotify(notify);
  }

  @PutMapping("notifies")
  public Notify updateNotify(@RequestBody Notify notify) {
    return notifyService.updateNotify(notify);
  }

  @DeleteMapping("notifies")
  public void deleteNotify(@RequestBody Notify notify) {
    notifyService.deleteNotify(notify);
  }

}
