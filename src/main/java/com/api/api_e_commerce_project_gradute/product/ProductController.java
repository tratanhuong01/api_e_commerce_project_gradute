package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.DTO.product.*;
import com.api.api_e_commerce_project_gradute.DTO.specification.product.ProductAdminCriteria;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.news.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping("productFiltersAll")
  public Integer filterProductAll(String group,Long color,Long ram,Long rom,String brand,Integer priceFrom,
                                  Integer priceTo,Integer typeProduct, String category,Integer status,
                                  String priceOutputSorter,String priceInputSorter,String productSoldSorter,
                                  String saleSorter,String keyword,String timeCreatedFrom,String timeCreatedTo,
                                  String timeCreatedSorter) {
    ProductAdminCriteria productAdminCriteria = ProductAdminCriteria.builder()
        .group(group)
        .category(category)
        .color(color)
        .brand(brand)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .ram(ram)
        .rom(rom)
        .priceFrom(priceFrom)
        .priceTo(priceTo)
        .typeProduct(typeProduct)
        .saleSorter(saleSorter)
        .productSoldSorter(productSoldSorter)
        .priceOutputSorter(priceOutputSorter)
        .priceInputSorter(priceInputSorter)
        .status(status)
        .keyword(keyword)
        .timeCreatedSorter(timeCreatedSorter)
        .build();
    return productService.filterProductAdminAll(productAdminCriteria);
  }

  @GetMapping("productFilters")
  public List<ProductFull> filterProductLimit(String group,Long color,Long ram,Long rom,String brand,Integer priceFrom,
                                              Integer priceTo,Integer typeProduct, String category,Integer status,
                                              String priceOutputSorter,String priceInputSorter,String productSoldSorter,
                                              String saleSorter,Integer offset,Integer limit,String keyword,
                                              String timeCreatedFrom,String timeCreatedTo,String timeCreatedSorter) {
    ProductAdminCriteria productAdminCriteria = ProductAdminCriteria.builder()
        .category(category)
        .group(group)
        .color(color)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .brand(brand)
        .ram(ram)
        .rom(rom)
        .priceFrom(priceFrom)
        .priceTo(priceTo)
        .typeProduct(typeProduct)
        .saleSorter(saleSorter)
        .productSoldSorter(productSoldSorter)
        .priceOutputSorter(priceOutputSorter)
        .priceInputSorter(priceInputSorter)
        .status(status)
        .offset(offset)
        .limit(limit)
        .keyword(keyword)
        .timeCreatedSorter(timeCreatedSorter)
        .build();
    return productService.filterProductAdminLimit(productAdminCriteria);
  }

  @GetMapping("productsFilterAll")
  public Integer filterProductAll(@RequestParam(name="feature", required = false) Set<Long> feature,
                                         @RequestParam(name="slugGroupProduct", required = false) String slugGroupProduct,
                                         @RequestParam(name="color", required = false) Set<Long> color,
                                         @RequestParam(name="ram", required = false) Set<Long> ram,
                                         @RequestParam(name="rom", required = false) Set<Long> rom,
                                         @RequestParam(name="brand", required = false) Set<String> brand,
                                         @RequestParam(name="priceFrom", required = false) Integer priceFrom,
                                         @RequestParam(name="priceTo", required = false) Integer priceTo,
                                         @RequestParam(name = "sorter",required = false) String sorter,
                                         @RequestParam(name = "typeProduct",required = false) Set<Integer> typeProduct) {
    ProductCriteria productCriteria = ProductCriteria.builder().
        slugGroupProduct(slugGroupProduct).
        feature(feature).
        rom(rom).
        ram(ram).
        brand(brand).
        color(color).
        priceFrom(priceFrom).
        priceTo(priceTo).
        sorter(sorter).
        typeProduct(typeProduct).
        build();
    return productService.filterProductMainCustomerAll(productCriteria);
  }
  @GetMapping("productsFilter")
  public List<ProductFull> filterProductLimit(@RequestParam(name="feature", required = false) Set<Long> feature,
                                         @RequestParam(name="slugGroupProduct", required = false) String slugGroupProduct,
                                         @RequestParam(name="color", required = false) Set<Long> color,
                                         @RequestParam(name="ram", required = false) Set<Long> ram,
                                         @RequestParam(name="rom", required = false) Set<Long> rom,
                                         @RequestParam(name="brand", required = false) Set<String> brand,
                                         @RequestParam(name="priceFrom", required = false) Integer priceFrom,
                                         @RequestParam(name="priceTo", required = false) Integer priceTo,
                                         @RequestParam(name = "sorter",required = false) String sorter,
                                         @RequestParam(name = "typeProduct",required = false) Set<Integer> typeProduct,
                                         @RequestParam(name = "offset",required = false) Integer offset,
                                         @RequestParam(name = "limit",required = false) Integer limit) {
    ProductCriteria productCriteria = ProductCriteria.builder().
        slugGroupProduct(slugGroupProduct).
        feature(feature).
        rom(rom).
        ram(ram).
        brand(brand).
        color(color).
        priceFrom(priceFrom).
        priceTo(priceTo).
        sorter(sorter).
        typeProduct(typeProduct).
        offset(offset).
        limit(limit).
        build();
    return productService.filterProductMainCustomer(productCriteria);
  }
  @GetMapping("products/{offset}/{limit}")
  public List<ProductFull> getProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return productService.getAllProductLimit(offset, limit);
  }

  @GetMapping("productsAll")
  public List<ProductFull> getAll() {
    return productService.getAllProducts();
  }

  @GetMapping("products")
  public List<ProductFull> getAllProducts() {
    return productService.getAllProductLimit(0,10);
  }

  @GetMapping("products/search/")
  public List<ProductFull> searchProduct(@RequestParam(required = false) String keyword,
                                         @RequestParam(required = false) String slug,
                                         @RequestParam(required = false) Integer offset,
                                         @RequestParam(required = false) Integer limit,
                                         @RequestParam(required = false) Integer type) {
    return productService.searchProduct(keyword,slug,offset,limit,type);
  }
  @GetMapping("products/search/page/all/")
  public Integer searchProductPageAll(@RequestParam(required = false) String keyword,
                                      @RequestParam(required = false) String slug) {
    return productService.searchProductPageAll(keyword,slug);
  }

  @GetMapping("getImageByIdLineProduct")
  public List<Image> getImageByIdLIneProduct(@RequestParam String idLineProduct) {
    return productService.getImageByIdLineProduct(idLineProduct);
  }

  @GetMapping("getMemoryByIdLineProduct")
  public List<Memory> getMemoryByIdLineProduct(@RequestParam String idLineProduct) {
    return productService.getMemoryByIdLineProduct(idLineProduct);
  }

  @GetMapping("products/search/page/limit/")
  public List<ProductFull> searchProductPageLimit(@RequestParam(required = false) String keyword,
                                                @RequestParam(required = false) String slug,
                                                @RequestParam(required = false) Integer offset,
                                                @RequestParam(required = false) Integer limit) {
    return productService.searchProductPageLimit(keyword,slug,offset,limit);
  }

  @GetMapping("products/{idProduct}")
  public Product getProductById(@PathVariable String idProduct) {
    return productService.getProductByIdMain(idProduct);
  }

  @PostMapping("products")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @PutMapping("products")
  public Product updateProduct(@RequestBody Product product) {
    return productService.updateProduct(product);
  }

  @GetMapping("getIdBestNew")
  public Product getIdBestNew() {
    return productService.getIdBestNew();
  }

  @GetMapping("getAllProductFull")
  public List<ProductFull> getAllProductFull() {
    return productService.getAllProductFull();
  }

  @GetMapping("getProductByCategory/{category}")
  public List<ProductFull> getAllProductFull(@PathVariable String category) {
    return productService.getProductByCategory(category);
  }

  @GetMapping("getProductByCategoryAll/{category}")
  public Integer getAllProductFullAll(@PathVariable String category) {
    return productService.getProductByCategory(category).size();
  }

  @GetMapping("getProductByCategoryLimit/{category}/")
  public List<ProductFull> getAllProductFullLimit(@PathVariable String category,@RequestParam(required = false) Integer offset,
                                                  @RequestParam(required = false) Integer limit) {
    return productService.getProductByCategory(category);
  }

  @GetMapping("getProductByCategoryIndex")
  public List<ProductByCategory> getProductByCategoryIndex() {
    return productService.getProductByCategory();
  }
  @GetMapping("getCategoryByGroupProduct")
  public List<CategoryByGroupProduct> getCategoryByGroupProduct() {
    return productService.getCategoryByGroupProduct();
  }
  @GetMapping("getProductSaleToday")
  public List<ProductFull> getProductSaleToday() {
    return productService.getProductSaleToday();
  }
  @GetMapping("getProductTopSell")
  public ProductFull getProductTopSell() {
    return productService.getProductTopSell();
  }
  @GetMapping("getNewsIndex")
  public List<News> getNewsIndex() {
    return productService.getNewsIndex();
  }


  @GetMapping("getProductIndex")
  public ProductIndex getProductIndex() {
    return new ProductIndex();
  }

  @PostMapping("getProductBySlug")
  public ProductFull getProductBySlug(@RequestParam String slug) {
    return productService.getProductBySlug(slug,0);
  }

  @GetMapping("products/full/{id}")
  public ProductFull getProductByIdProduct(@PathVariable String id) {
    return productService.getProductBySlug(id,1);
  }

  @PostMapping("getSlug")
  public String getSlugByColorAndMemory(@RequestParam String idColor,@RequestParam String idMemory,
                                        @RequestParam String idLineProduct) {
    return productService.getSlugByColorAndMemory(idColor,idMemory,idLineProduct);
  }

  @PostMapping("getProductBySlugCategory")
  public List<ProductFull> getProductBySlugCategory(@RequestParam String slugCategoryProduct) {
    return productService.getProductBySlugCategory(slugCategoryProduct);
  }

  @PostMapping("getProductBySlugCategoryAndSlugGroup")
  public List<ProductFull> getProductBySlugCategoryAndSlugGroup(@RequestParam String slugCategoryProduct,
                                                            @RequestParam String slugGroupProduct) {
    return productService.getProductBySlugCategoryAndSlugGroup(slugCategoryProduct,slugGroupProduct);
  }

  @GetMapping("getCategoryByGroupProducts")
  public List<CategoryByGroupProduct> getCategoryByGroupProducts() {
    return productService.getCategoryByGroupProducts();
  }

  @GetMapping("productsAll/main/limit/")
  public List<ProductFull> getProductAllMain(@RequestParam(required = false) int offset,
                                             @RequestParam(required = false) int limit) {
    return productService.getProductAllMain(offset, limit);
  }

  @GetMapping("productsAll/main/all/")
  public Integer getProductAllMain() {
    return productService.getProductAllMain();
  }

  @GetMapping("products/combine/")
  public CombineProductInfoProduct getCombineProductInfoProduct(String idProduct) {
    return productService.getCombineProductInfoProduct(idProduct);
  }
  @DeleteMapping("deleteProductMain")
  public void deleteProductMain(@RequestParam String id) {
    productService.deleteProductMain(id);
  }

  @GetMapping("getProductSame")
  public List<ProductFull> getProductSame(@RequestParam String idProduct,@RequestParam String idGroupProduct) {
    return productService.getProductSame(idProduct, idGroupProduct);
  }

}
