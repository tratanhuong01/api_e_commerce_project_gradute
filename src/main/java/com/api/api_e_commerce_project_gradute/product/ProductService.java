package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.DTO.product.*;
import com.api.api_e_commerce_project_gradute.DTO.specification.product.ProductAdminCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.product.ProductAdminSpecification;
import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.brand.BrandRepository;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProductRepository;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.color.ColorRepository;
import com.api.api_e_commerce_project_gradute.group_product.GroupProductRepository;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.image.ImageRepository;
import com.api.api_e_commerce_project_gradute.info_product.InfoProductRepository;
import com.api.api_e_commerce_project_gradute.line_product.LineProductRepository;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.memory.MemoryRepository;
import com.api.api_e_commerce_project_gradute.news.News;
import com.api.api_e_commerce_project_gradute.news.NewsRepository;
import com.api.api_e_commerce_project_gradute.ram.Ram;
import com.api.api_e_commerce_project_gradute.ram.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service

public class ProductService{

  @Autowired
  ProductRepository productRepository;
  @Autowired
  ColorRepository colorRepository;
  @Autowired
  MemoryRepository memoryRepository;
  @Autowired
  ImageRepository imageRepository;
  @Autowired
  BrandRepository brandRepository;
  @Autowired
  CategoryProductRepository categoryProductRepository;
  @Autowired
  GroupProductRepository groupProductRepository;
  @Autowired
  NewsRepository newsRepository;
  @Autowired
  RamRepository ramRepository;
  @Autowired
  LineProductRepository lineProductRepository;
  @Autowired
  InfoProductRepository infoProductRepository;

  public Product getProductByIdMain(String id) {
    return productRepository.getProductById(id);
  }

  public List<ProductFull> getAllProducts() {
    List<ProductFull> productFullList = new ArrayList<>();
    List<Product> productList = productRepository.findAll();
    for (Product product: productList)
      productFullList.add(getProductBySlug(product.getId(),-1));
    return productFullList;
  }

  public List<ProductFull> getAllProductLimit(int offset,int limit) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<Product> productList = productRepository.getProductLimit(offset,limit);
    for (Product product: productList)
      productFullList.add(getProductBySlug(product.getId(),-1));
    return productFullList;
  }

  public Product addProduct(Product product) {
    product.setTimeCreated(new Timestamp(new Date().getTime()));
    return productRepository.save(product);
  }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public Product getIdBestNew() {
    return productRepository.getIdBestNew();
  }

  public List<ProductFull> getAllProductFull() {
    List<String> stringList = productRepository.getDistinctIdLineProduct();
    return returnListProductFull(stringList);
  }

  public List<ProductFull> getProductByCategory(String idCategory) {
    List<String> stringList = productRepository.getDistinctIdLineProductByIdCategory(idCategory);
    return returnListProductFull(stringList);
  }

  public List<ProductFull> returnListProductFull(List<String> stringList) {
    List<ProductFull> productFullList = new ArrayList<>();
    for (String string: stringList) {
      ProductMain productMain = productRepository.getProductByIdLineProductOnce(string);
      productFullList.add(returnProductFull(productMain));
    }
    return productFullList;
  }

  public List<ProductFull> getProductBySlugCategory(String slugCategory) {
    List<String> stringList = productRepository.getDistinctIdLineProductBySlugCategoryProduct(slugCategory);
    return returnListProductFull(stringList);
  }

  public List<ProductFull> getProductBySlugCategoryAndSlugGroup(String slugCategory,String slugGroup) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<Product> productList = productRepository.getDistinctIdLineProductBySlugCategoryAndSlugGroupProduct(slugCategory,slugGroup);
    for (Product product: productList)
      productFullList.add(getProductBySlug(product.getId(),-1));
    return productFullList;
  }

  public List<CategoryByGroupProduct> getCategoryByGroupProduct() {
    List<CategoryProduct> categoryProductList = categoryProductRepository.findAll();
    List<CategoryByGroupProduct> categoryByGroupProductList = new ArrayList<>();
    for (CategoryProduct categoryProduct: categoryProductList) {
      CategoryByGroupProduct categoryByGroupProduct = new CategoryByGroupProduct();
      categoryByGroupProduct.setCategoryProduct(categoryProduct);
      categoryByGroupProduct.setGroupProductList(groupProductRepository.getGroupProductByIdCategoryProduct(
              categoryProduct.getId()));
      categoryByGroupProductList.add(categoryByGroupProduct);
    }
    return categoryByGroupProductList;
  }

  public List<ProductByCategory> getProductByCategory() {
    List<ProductByCategory> productByCategoryList = new ArrayList<>();
    List<CategoryProduct> categoryProductList = categoryProductRepository.findAll();

    for (CategoryProduct categoryProduct: categoryProductList) {
      ProductByCategory productByCategory = new ProductByCategory();
      productByCategory.setIdCategoryProduct(categoryProduct.getId());
      productByCategory.setNameCategoryProduct(categoryProduct.getNameCategoryProduct());
      productByCategory.setSlugCategoryProduct(categoryProduct.getSlugCategoryProduct());
      List<String> stringList = productRepository.getDistinctIdLineProductByIdCategoryLimit(
              categoryProduct.getId(),0,12);
      List<ProductFull> productFullList = new ArrayList<>();
      for (String string: stringList) {
        ProductMain productMain = productRepository.getProductByIdLineProductOnce(string);
        productFullList.add(returnProductFull(productMain));
      }
      productByCategory.setListProductCategory(productFullList);
      productByCategoryList.add(productByCategory);
    }

    return productByCategoryList;
  }

  public List<News> getNewsIndex() {
    return newsRepository.getBestNewsIndex();
  }

  public ProductFull getProductTopSell() {
    return getProductBySlug(productRepository.getProductTopSell().getIdProduct(),-1);
  }

  public List<ProductFull> getProductSaleToday() {
    List<ProductFull> listProductSaleToday = new ArrayList<>();
    for (Product product: productRepository.getProductSaleToday())
      listProductSaleToday.add(getProductBySlug(product.getId(),-1));
    return listProductSaleToday;
  }

  public ProductFull returnProductFull(ProductMain productMains) {
    if (productMains != null) {
      Product product = productRepository.getProductById(productMains.getIdProduct());
      Image image = product.getImageProduct();
      Color color = product.getImageProduct().getColorProduct();
      Memory memory = product.getMemoryProduct();
      Ram ram = product.getRamProduct();
      Brand brand = product.getLineProduct().getBrandProduct();
      return new ProductFull(productMains.getIdProduct(),productMains.getIdProduct(),productMains.getIdCategoryProduct(),
              productMains.getNameCategoryProduct(),productMains.getIdGroupProduct(),productMains.getNameGroupProduct(),
              productMains.getIdLineProduct(),productMains.getNameLineProduct(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),
              productMains.getSlug(),productMains.getPriceInput(),productMains.getPriceOutput(),productMains.getSale(),image,
              color,memory,ram,brand,productMains.getDescribeProduct(),productMains.getTypeProduct(),productMains.getReview(),
              productMains.getItemCurrent(),productMains.getItemSold());
    }
    return null;
  }

  public ProductFull returnProductFullByProductMaster(Product product) {
    ProductMain productMain = productRepository.getProductByIdProduct(product.getId());
    return new ProductFull(product.getId(),product.getId(),
            productMain.getIdCategoryProduct(),productMain.getNameCategoryProduct(), productMain.getIdGroupProduct(),
            productMain.getNameGroupProduct(), productMain.getIdLineProduct(),productMain.getNameLineProduct(),
            new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),
            product.getSlug(),productMain.getPriceInput(),productMain.getPriceOutput(),productMain.getSale(),product.getImageProduct(),
            product.getImageProduct().getColorProduct(), product.getMemoryProduct(),product.getRamProduct(),product.getLineProduct().getBrandProduct(),
            productMain.getDescribeProduct(),productMain.getTypeProduct(),productMain.getReview(),
            productMain.getItemCurrent(),productMain.getItemSold());
  }

  public ProductFull getProductBySlug(String slug, int type) {
    ProductMain productMains = null;
    if (type == 0)
      productMains = productRepository.getProductBySlug(slug);
    else
      productMains = productRepository.getProductByIdProduct(slug);
    if (productMains != null)
      return returnProductFull(productMains);
    return null;
  }

  public String getSlugByColorAndMemory(String idColor,String idMemory,String idLineProduct) {
    String string = "";
    if (idMemory.equals(""))
      string = productRepository.getSlugByColorAndNotMemory(idColor,idLineProduct);
    else if (idColor.equals(""))
      string =  productRepository.getSlugByNotColorAndMemory(idMemory,idLineProduct);
    else
      string = productRepository.getSlugByColorAndMemory(idColor,idMemory,idLineProduct);

    return string;
  }

  public List<CategoryByGroupProduct> getCategoryByGroupProducts() {
    List<CategoryByGroupProduct> categoryByGroupProductList = new ArrayList<>();
    List<CategoryProduct> categoryProductList = categoryProductRepository.findAll();
    for (CategoryProduct categoryProduct: categoryProductList) {
      CategoryByGroupProduct categoryByGroupProduct = new CategoryByGroupProduct();
      categoryByGroupProduct.setCategoryProduct(categoryProduct);
      categoryByGroupProduct.setGroupProductList(groupProductRepository.getGroupProductByIdCategoryProduct(
          categoryProduct.getId()));
      categoryByGroupProductList.add(categoryByGroupProduct);
    }
    return categoryByGroupProductList;
  }

  public Integer filterProductMainCustomerAll(ProductCriteria productCriteria) {
    Specification<Product> productSpecification = ProductSpecifications.createProductSpecifications(productCriteria);
    return productRepository.findAll(productSpecification).size();
  }

  public List<ProductFull> filterProductMainCustomer(ProductCriteria productCriteria) {
    Specification<Product> productSpecification = ProductSpecifications.createProductSpecifications(productCriteria);
    Pageable pageable = PageRequest.of(productCriteria.getOffset(),productCriteria.getLimit());
    List<ProductFull> productFullList = new ArrayList<>();
    Page<Product> productPage = productRepository.findAll(productSpecification,pageable);
    for (Product product:productPage.getContent())
      productFullList.add(returnProductFullByProductMaster(product));
    return productFullList;
  }

  public List<ProductFull> searchProduct(String keyword,String slug,Integer offset,Integer limit,Integer type) {
    List<String> stringList =  null;
    if (type == 0)
      stringList = lineProductRepository.searchProduct(keyword,slug);
    else
      stringList = lineProductRepository.searchProductLimit(keyword,slug,offset,limit);
    return returnListProductFull(stringList);
  }

  public Integer searchProductPageAll(String keyword,String slug) {
    return productRepository.searchProductPageAll(keyword,slug).size();
  }

  public List<ProductFull> searchProductPageLimit(String keyword,String slug,Integer offset,Integer limit) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<ProductMain> productList = productRepository.searchProductPageLimit(keyword,slug,offset,limit);
    for (ProductMain product:productList) {
      productFullList.add(getProductBySlug(product.getIdProduct(),-1));
    }
    return productFullList;
  }

  public List<ProductFull> getProductAllMain(int offset,int limit) {
    Pageable pageable = PageRequest.of(offset,limit);
    Page<Product> productPage = productRepository.findAll(pageable);
    List<ProductFull> productFullList = new ArrayList<>();
    for (Product product: productPage.getContent()) {
      productFullList.add(getProductBySlug(product.getId(),-1));
    }
    return productFullList;
  }

  public Integer getProductAllMain() {
    List<Product> productList = productRepository.findAll();
    return productList.size();
  }

  //admin

  public Integer filterProductAdminAll(ProductAdminCriteria productAdminCriteria) {
    Specification<Product> productSpecification = ProductAdminSpecification.createProductSpecification(
        productAdminCriteria
    );
    return productRepository.findAll(productSpecification).size();
  }

  public List<ProductFull>  filterProductAdminLimit(ProductAdminCriteria productAdminCriteria) {
    Specification<Product> productSpecification = ProductAdminSpecification.createProductSpecification(
        productAdminCriteria
    );
    Pageable pageable = PageRequest.of(productAdminCriteria.getOffset(),productAdminCriteria.getLimit());
    Page<Product> productPage = productRepository.findAll(productSpecification,pageable);
    List<ProductFull> productFullList = new ArrayList<>();
    for (Product product:productPage)
      productFullList.add(getProductBySlug(product.getId(),-1));
    return productFullList;
  }

  public CombineProductInfoProduct getCombineProductInfoProduct(String idProduct) {
    CombineProductInfoProduct combineProductInfoProduct = new CombineProductInfoProduct();
    combineProductInfoProduct.setProduct(productRepository.getProductById(idProduct));
    combineProductInfoProduct.setInfoProduct(infoProductRepository.getInfoProductByIdProduct(idProduct));
    return combineProductInfoProduct;
  }

  public void deleteProductMain(String id) {
    infoProductRepository.deleteInfoProduct(id);
    productRepository.deleteProductMain(id);
  }

}
