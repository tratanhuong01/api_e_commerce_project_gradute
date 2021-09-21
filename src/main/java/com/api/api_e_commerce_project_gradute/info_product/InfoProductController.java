package com.api.api_e_commerce_project_gradute.info_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class InfoProductController {

  @Autowired
  InfoProductService infoProductService;

  @GetMapping("infoProductsAll")
  public List<InfoProduct> getInfoProductAll() {
    return infoProductService.getAllInfoProduct();
  }

  @PostMapping("infoProducts")
  public InfoProduct addInfoProduct(@RequestParam(required = false) String idProduct,
                                    @RequestBody InfoProduct infoProduct) {
    return infoProductService.addInfoProduct(infoProduct,idProduct);
  }

  @PutMapping("infoProducts")
  public InfoProduct updateInfoProduct(@RequestBody InfoProduct infoProduct) {
    return infoProductService.addInfoProduct(infoProduct);
  }

  @GetMapping("infoProducts/itemCurrent/")
  public int getItemCurrentProductById(@RequestParam(required = false) String idProduct) {
    return infoProductService.getItemCurrentProductById(idProduct);
  }

  @GetMapping("infoProducts/update/")
  public int updateItemCurrentAndItemSold(@RequestParam(required = false) int amount,
                                          @RequestParam(required = false) String idProduct) {
    return infoProductService.updateItemCurrentAndItemSolid(amount, idProduct);
  }

  @PutMapping("infoProducts/review/update/")
  public int updateReviewProduct(@RequestParam(required = false) int review , @RequestParam(required = false) String idProduct) {
    return infoProductService.updateReviewProduct(review, idProduct);
  }

}
