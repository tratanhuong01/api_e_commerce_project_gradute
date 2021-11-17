package com.api.api_e_commerce_project_gradute.line_product;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductMain;
import com.api.api_e_commerce_project_gradute.DTO.specification.line_product.LineProductCriteria;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import com.api.api_e_commerce_project_gradute.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class LineProductController {

  @Autowired
  LineProductService lineProductService;

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductService productService;

  // admin

  @GetMapping("lineProductFiltersAll")
  public List<LineProduct> filtersLineProductAll(String brand,String group,String keyword,
                                                 String timeCreatedFrom,String timeCreatedTo) {
    LineProductCriteria lineProductCriteria = LineProductCriteria.builder()
        .brand(brand)
        .group(group)
        .keyword(keyword)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .build();
    return lineProductService.filterLineProductsAll(lineProductCriteria);
  }

  @GetMapping("lineProductFilters")
  public List<LineProduct> filtersLineProductLimit(String brand,String group,String keyword,Integer offset,
                                                   Integer limit,String timeCreatedFrom,String timeCreatedTo) {
    LineProductCriteria lineProductCriteria = LineProductCriteria.builder()
        .brand(brand)
        .group(group)
        .keyword(keyword)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .offset(offset)
        .limit(limit)
        .build();
    return lineProductService.filterLineProductsLimit(lineProductCriteria);
  }

  @GetMapping("lineProductsAll/search/")
  public List<LineProduct> searchLineProductAll(@RequestParam(required = false) String keyword) {
    return lineProductService.searchLineProductAll(keyword);
  }

  @GetMapping("lineProducts/search/")
  public List<LineProduct> searchLineProductLimit(@RequestParam(required = false) String keyword, @RequestParam(required = false) int offset,
                                                    @RequestParam(required = false) int limit) {
    return lineProductService.searchLineProductLimit(keyword,offset,limit);
  }

  @DeleteMapping("lineProducts")
  public void deleteLineProduct(@RequestBody LineProduct lineProduct) {
    lineProductService.deleteLineProduct(lineProduct);
  }

  // user

  @GetMapping("lineProductsAll")
  public List<LineProduct> getAllLineProducts() {
    return lineProductService.getAllLineProducts();
  }

  @GetMapping("lineProducts")
  public List<LineProduct> getAllLineProductLimit() {
    return lineProductService.getAllLineProductLimit(0,10);
  }

  @GetMapping("lineProducts/{offset}/{limit}")
  public List<LineProduct> getAllLineProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return lineProductService.getAllLineProductLimit(offset, limit);
  }

  @GetMapping("lineProducts/{idLineProduct}")
  public Optional<LineProduct> getLineProductById(@PathVariable String idLineProduct) {
    return lineProductService.getLineProductById(idLineProduct);
  }

  @GetMapping("getLineProductsByGroup/{idGroup}")
  public List<LineProduct> getLineProductByIdGroupProduct(@PathVariable String idGroup) {
    return lineProductService.getLineProductByIdGroupProduct(idGroup);
  }

  @PostMapping("lineProducts")
  public LineProduct addLineProduct(@RequestBody LineProduct lineProduct) {
    return lineProductService.addLineProduct(lineProduct);
  }

  @PutMapping("lineProducts")
  public LineProduct updateLineProduct(@RequestBody LineProduct lineProduct) {
    return lineProductService.updateLineProduct(lineProduct);
  }

  @GetMapping("getProductByLineProductFirst")
  public ProductFull getProductByLineProductFirst(@RequestParam String idLineProduct) {
    ProductFull productFull = null;
    List<ProductMain> productMain = productRepository.getProductByIdProductFirst(idLineProduct);
    if (productMain.size() == 0) {
    }
    else {
      productFull = productService.getProductBySlug(productMain.get(0).getIdProduct(),
              -1);
    }
    return productFull;
  }

}
