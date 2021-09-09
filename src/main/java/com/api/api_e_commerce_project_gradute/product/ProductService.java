package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.DTO.product.*;
import com.api.api_e_commerce_project_gradute.brand.BrandRepository;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProductRepository;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.color.ColorRepository;
import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProductRepository;
import com.api.api_e_commerce_project_gradute.group_product.GroupProductRepository;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.image.ImageRepository;
import com.api.api_e_commerce_project_gradute.line_product.LineProductRepository;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.memory.MemoryRepository;
import com.api.api_e_commerce_project_gradute.news.NewsRepository;
import com.api.api_e_commerce_project_gradute.ram.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
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
  DetailFunctionProductRepository detailFunctionProductRepository;
  @Autowired
  LineProductRepository lineProductRepository;

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
      List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
      List<Color> colorList = checkListColor(productMainList);
      List<Image> imageList = checkListImage(productMainList);
      List<Memory> memoryList = checkListMemory(productMainList);
      productFullList.add(returnProductFull(productMainList.get(0),colorList,memoryList,imageList,productMainList));
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

  public ProductIndex getProductIndex() {
    ProductIndex productIndex = new ProductIndex();
    productIndex.setListProductSaleToday(new ArrayList<>());
    productIndex.setListProductTopSell(new ArrayList<>());

    List<ProductByCategory> productByCategoryList = new ArrayList<>();
    List<CategoryProduct> categoryProductList = categoryProductRepository.findAll();
    List<CategoryByGroupProduct> categoryByGroupProductList = new ArrayList<>();

    for (CategoryProduct categoryProduct: categoryProductList) {
      CategoryByGroupProduct categoryByGroupProduct = new CategoryByGroupProduct();
      categoryByGroupProduct.setCategoryProduct(categoryProduct);
      categoryByGroupProduct.setGroupProductList(groupProductRepository.getGroupProductByIdCategoryProduct(
          categoryProduct.getId()));
      categoryByGroupProductList.add(categoryByGroupProduct);
      ProductByCategory productByCategory = new ProductByCategory();
      productByCategory.setIdCategoryProduct(categoryProduct.getId());
      productByCategory.setNameCategoryProduct(categoryProduct.getNameCategoryProduct());
      productByCategory.setSlugCategoryProduct(categoryProduct.getSlugCategoryProduct());
      List<String> stringList = productRepository.getDistinctIdLineProductByIdCategoryLimit(
          categoryProduct.getId(),0,12);
      List<ProductFull> productFullList = new ArrayList<>();
      for (String string: stringList) {
        List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
        List<Color> colorList = checkListColor(productMainList);
        List<Image> imageList = checkListImage(productMainList);
        List<Memory> memoryList = checkListMemory(productMainList);
        productFullList.add(returnProductFull(productMainList.get(0),colorList,memoryList,imageList,productMainList));
      }
      productByCategory.setListProductCategory(productFullList);
      productByCategoryList.add(productByCategory);
    }

    productIndex.setNewsList(newsRepository.getBestNewsIndex());
    productIndex.setListCategoryByGroupProduct(categoryByGroupProductList);
    productIndex.setListProductByCategory(productByCategoryList);

    List<ProductFull> listProductSaleToday = new ArrayList<>();
    for (Product product: productRepository.getProductSaleToday())
      listProductSaleToday.add(getProductBySlug(product.getId(),-1));
    productIndex.setListProductSaleToday(listProductSaleToday);

    return productIndex;
  }

  public List<Color> checkListColor(List<ProductMain> productMainList) {
    List<Color> colorList = new ArrayList<>();
    for (ProductMain productMain: productMainList) {
      if (productMain.getIdColor() != null) {
        int count = 0;
        for (Color color : colorList)
          if (color.getId().equals(productMain.getIdColor()))
            count++;
        if (count == 0)
          colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
      }
    }
    return colorList;
  }

  public List<Image> checkListImage(List<ProductMain> productMainList) {
    List<Image> imageList = new ArrayList<>();
    for (ProductMain productMain: productMainList) {
      if (productMain.getIdImage() != null) {
        int count = 0;
        for (Image image : imageList)
          if (image.getId().equals(productMain.getIdImage()))
            count++;
        if (count == 0)
          imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
      }
    }
    return imageList;
  }

  public List<Memory> checkListMemory(List<ProductMain> productMainList) {
    List<Memory> memoryList = new ArrayList<>();
    for (ProductMain productMain: productMainList) {
      if (productMain.getIdMemory() != null) {
        int count = 0;
        for (Memory memory : memoryList)
          if (memory.getId().equals(productMain.getIdMemory()))
            count++;
        if (count == 0)
          memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
      }
    }
    return memoryList;
  }

  public ProductFull returnProductFull(ProductMain productMains,List<Color> colorList,List<Memory> memoryList,
                                       List<Image> imageList,List<ProductMain> productMainList) {
    return new ProductFull(productMains.getIdProduct(),productMains.getIdCategoryProduct(),
        productMains.getNameCategoryProduct(),productMains.getIdGroupProduct(),productMains.getNameGroupProduct(),
        productMains.getIdLineProduct(),productMains.getNameLineProduct(),colorList,memoryList,imageList,
        productMains.getSlug(),productMains.getPriceInput(),productMains.getPriceOutput(),
        productMains.getSale(),imageRepository.getImageByIdImage(productMains.getIdImage()),
        colorRepository.getColorByIdColor(productMains.getIdColor()),
        memoryRepository.getMemoryByIdMemory(productMains.getIdMemory()),
        ramRepository.getRamByIdRam(productMainList.get(0).getIdRam()),
        brandRepository.getBrandByIdBrand(productMains.getIdBrand()),
        productMains.getDescribeProduct());
  }

  public ProductFull getProductBySlug(String slug, int type) {
    ProductMain productMains = null;
    if (type == 0)
      productMains = productRepository.getProductBySlug(slug);
    else
      productMains = productRepository.getProductByIdProduct(slug);
    List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(productMains.getIdLineProduct());
    List<Color> colorList = checkListColor(productMainList);
    List<Image> imageList = checkListImage(productMainList);
    List<Memory> memoryList = checkListMemory(productMainList);
    return returnProductFull(productMains,colorList,memoryList,imageList,productMainList);
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

  public List<ProductFull> filterProduct(ProductCriteria productCriteria) {
    Specification<Product> productSpecification = ProductSpecifications.createProductSpecifications(productCriteria);
    List<Product> productList = productRepository.findAll(productSpecification);
    List<ProductFull> productFullList = new ArrayList<>();
    List<String> lineProductId = new ArrayList<>();

    for (Product product: productList){
      int count = 0;
      for (String string :lineProductId)
        if (string.equals(product.getLineProduct().getId())) count++;
      if (count == 0) lineProductId.add(product.getLineProduct().getId());
    }

    for (String string:lineProductId) {
      int countFeature = 0;
      int countTypeProduct = 0;
      if (productCriteria.getFeature() != null) {
        for (Long longData : productCriteria.getFeature()) {
          DetailFunctionProduct detailFunctionProduct = detailFunctionProductRepository.getDetailFunctionProduct(longData,string);
          if (detailFunctionProduct != null) {
            if (detailFunctionProduct.getFunctionProductDetail().getTypeFunctionProduct() == 1 &&
                productCriteria.getFeature().size() == 1){
            }
            else
              countFeature++;
            if (detailFunctionProduct.getFunctionProductDetail().getTypeFunctionProduct() == 1) countTypeProduct++;
          }
        }
        if (countFeature == productCriteria.getFeature().size() - countTypeProduct) {
          List<Product> list = (productRepository.getFirstProductByIdLineProduct(string));
          if (list.size() > 0 || countTypeProduct > 0)
            productFullList.add(getProductBySlug(list.get(0).getId(),-1));
        }
      }
      else {
        List<Product> list = (productRepository.getFirstProductByIdLineProduct(string));
        if (list.size() > 0)
          productFullList.add(getProductBySlug(list.get(0).getId(),-1));
      }
    }

    return productFullList;
  }

  public List<ProductFull> searchProduct(String keyword,String slug) {
    List<String> stringList = lineProductRepository.searchProduct(keyword,slug);
    return returnListProductFull(stringList);
  }

}
