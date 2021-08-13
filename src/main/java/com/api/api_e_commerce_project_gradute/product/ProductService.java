package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductByCategory;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductIndex;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductMain;
import com.api.api_e_commerce_project_gradute.brand.BrandRepository;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProductRepository;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.color.ColorRepository;
import com.api.api_e_commerce_project_gradute.group_product.GroupProductRepository;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.image.ImageRepository;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.memory.MemoryRepository;
import com.api.api_e_commerce_project_gradute.size.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

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

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(String idProduct) {
    return productRepository.findById(idProduct);
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public Product getIdBestNew() {
    return productRepository.getIdBestNew();
  }

  public List<ProductFull> getAllProductFull() {
    List<ProductFull> productFullList = new ArrayList<>();
    List<String> stringList = productRepository.getDistinctIdLineProduct();
    for (String string: stringList) {
      List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
      List<Color> colorList = new ArrayList<>();
      List<Image> imageList = new ArrayList<>();
      List<Memory> memoryList = new ArrayList<>();
      for (ProductMain productMain: productMainList) {
        if (productMain.getIdColor() != null) {
          int count = 0;
          for (Color color : colorList) {
            if (color.getId().equals(productMain.getIdColor())) {
              count++;
            }
          }
          if (count == 0)
            colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Image image : imageList) {
            if (image.getId().equals(productMain.getIdImage())) {
              count++;
            }
          }
          if (count == 0)
            imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Memory memory : memoryList) {
            if (memory.getId().equals(productMain.getIdMemory())) {
              count++;
            }
          }
          if (count == 0)
            memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
        }
      }
      ProductFull productFull = new ProductFull(productMainList.get(0).getIdProduct(),productMainList.get(0).getIdCategoryProduct(),
          productMainList.get(0).getNameCategoryProduct(),productMainList.get(0).getIdGroupProduct(),productMainList.get(0).getNameGroupProduct(),
          productMainList.get(0).getIdLineProduct(),productMainList.get(0).getNameLineProduct(),colorList,memoryList,imageList,
          productMainList.get(0).getSlug(),productMainList.get(0).getPriceInput(),productMainList.get(0).getPriceOutput(),
          productMainList.get(0).getSale(), imageRepository.getImageByIdImage(productMainList.get(0).getIdImage()),
          colorRepository.getColorByIdColor(productMainList.get(0).getIdColor()),
          memoryRepository.getMemoryByIdMemory(productMainList.get(0).getIdMemory()),
          brandRepository.getBrandByIdBrand(productMainList.get(0).getIdBrand()),
          productMainList.get(0).getDescribeProduct());
      productFullList.add(productFull);
    }
    return productFullList;
  }

  public List<ProductFull> getProductByCategory(String idCategory) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<String> stringList = productRepository.getDistinctIdLineProduct(idCategory);
    for (String string: stringList) {
      List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
      List<Color> colorList = new ArrayList<>();
      List<Image> imageList = new ArrayList<>();
      List<Memory> memoryList = new ArrayList<>();
      for (ProductMain productMain: productMainList) {
        if (productMain.getIdColor() != null) {
          int count = 0;
          for (Color color : colorList) {
            if (color.getId().equals(productMain.getIdColor())) {
              count++;
            }
          }
          if (count == 0)
            colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Image image : imageList) {
            if (image.getId().equals(productMain.getIdImage())) {
              count++;
            }
          }
          if (count == 0)
            imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Memory memory : memoryList) {
            if (memory.getId().equals(productMain.getIdMemory())) {
              count++;
            }
          }
          if (count == 0)
            memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
        }
      }
      ProductFull productFull = new ProductFull(productMainList.get(0).getIdProduct(),productMainList.get(0).getIdCategoryProduct(),
          productMainList.get(0).getNameCategoryProduct(),productMainList.get(0).getIdGroupProduct(),productMainList.get(0).getNameGroupProduct(),
          productMainList.get(0).getIdLineProduct(),productMainList.get(0).getNameLineProduct(),colorList,memoryList,imageList,
          productMainList.get(0).getSlug(),productMainList.get(0).getPriceInput(),productMainList.get(0).getPriceOutput(),
          productMainList.get(0).getSale(), imageRepository.getImageByIdImage(productMainList.get(0).getIdImage()),
          colorRepository.getColorByIdColor(productMainList.get(0).getIdColor()),
          memoryRepository.getMemoryByIdMemory(productMainList.get(0).getIdMemory()),
          brandRepository.getBrandByIdBrand(productMainList.get(0).getIdBrand()),
          productMainList.get(0).getDescribeProduct());
      productFullList.add(productFull);
    }
    return productFullList;
  }

  public List<ProductFull> getProductBySlugCategory(String slugCategory) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<String> stringList = productRepository.getDistinctIdLineProducts(slugCategory);
    for (String string: stringList) {
      List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
      List<Color> colorList = new ArrayList<>();
      List<Image> imageList = new ArrayList<>();
      List<Memory> memoryList = new ArrayList<>();
      for (ProductMain productMain: productMainList) {
        if (productMain.getIdColor() != null) {
          int count = 0;
          for (Color color : colorList) {
            if (color.getId().equals(productMain.getIdColor())) {
              count++;
            }
          }
          if (count == 0)
            colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Image image : imageList) {
            if (image.getId().equals(productMain.getIdImage())) {
              count++;
            }
          }
          if (count == 0)
            imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Memory memory : memoryList) {
            if (memory.getId().equals(productMain.getIdMemory())) {
              count++;
            }
          }
          if (count == 0)
            memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
        }
      }
      ProductFull productFull = new ProductFull(productMainList.get(0).getIdProduct(),productMainList.get(0).getIdCategoryProduct(),
          productMainList.get(0).getNameCategoryProduct(),productMainList.get(0).getIdGroupProduct(),productMainList.get(0).getNameGroupProduct(),
          productMainList.get(0).getIdLineProduct(),productMainList.get(0).getNameLineProduct(),colorList,memoryList,imageList,
          productMainList.get(0).getSlug(),productMainList.get(0).getPriceInput(),productMainList.get(0).getPriceOutput(),
          productMainList.get(0).getSale(), imageRepository.getImageByIdImage(productMainList.get(0).getIdImage()),
          colorRepository.getColorByIdColor(productMainList.get(0).getIdColor()),
          memoryRepository.getMemoryByIdMemory(productMainList.get(0).getIdMemory()),
          brandRepository.getBrandByIdBrand(productMainList.get(0).getIdBrand()),
          productMainList.get(0).getDescribeProduct());
      productFullList.add(productFull);
    }
    return productFullList;
  }

  public List<ProductFull> getProductBySlugCategoryAndSlugGroup(String slugCategory,String slugGroup) {
    List<ProductFull> productFullList = new ArrayList<>();
    List<String> stringList = productRepository.getDistinctIdLineProduct(slugCategory,slugGroup);
    for (String string: stringList) {
      List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
      List<Color> colorList = new ArrayList<>();
      List<Image> imageList = new ArrayList<>();
      List<Memory> memoryList = new ArrayList<>();
      for (ProductMain productMain: productMainList) {
        if (productMain.getIdColor() != null) {
          int count = 0;
          for (Color color : colorList) {
            if (color.getId().equals(productMain.getIdColor())) {
              count++;
            }
          }
          if (count == 0)
            colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Image image : imageList) {
            if (image.getId().equals(productMain.getIdImage())) {
              count++;
            }
          }
          if (count == 0)
            imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
        }
        if (productMain.getIdMemory() != null) {
          int count = 0;
          for (Memory memory : memoryList) {
            if (memory.getId().equals(productMain.getIdMemory())) {
              count++;
            }
          }
          if (count == 0)
            memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
        }
      }
      ProductFull productFull = new ProductFull(productMainList.get(0).getIdProduct(),productMainList.get(0).getIdCategoryProduct(),
          productMainList.get(0).getNameCategoryProduct(),productMainList.get(0).getIdGroupProduct(),productMainList.get(0).getNameGroupProduct(),
          productMainList.get(0).getIdLineProduct(),productMainList.get(0).getNameLineProduct(),colorList,memoryList,imageList,
          productMainList.get(0).getSlug(),productMainList.get(0).getPriceInput(),productMainList.get(0).getPriceOutput(),
          productMainList.get(0).getSale(), imageRepository.getImageByIdImage(productMainList.get(0).getIdImage()),
          colorRepository.getColorByIdColor(productMainList.get(0).getIdColor()),
          memoryRepository.getMemoryByIdMemory(productMainList.get(0).getIdMemory()),
          brandRepository.getBrandByIdBrand(productMainList.get(0).getIdBrand()),
          productMainList.get(0).getDescribeProduct());
      productFullList.add(productFull);
    }
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
      productByCategory.setSlugCategoryProduct("");
      List<String> stringList = productRepository.getDistinctIdLineProduct(categoryProduct.getId());
      List<ProductFull> productFullList = new ArrayList<>();
      for (String string: stringList) {
        List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(string);
        List<Color> colorList = new ArrayList<>();
        List<Image> imageList = new ArrayList<>();
        List<Memory> memoryList = new ArrayList<>();
        for (ProductMain productMain: productMainList) {
          if (productMain.getIdColor() != null) {
            int count = 0;
            for (Color color : colorList) {
              if (color.getId().equals(productMain.getIdColor())) {
                count++;
              }
            }
            if (count == 0)
              colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
          }
          if (productMain.getIdMemory() != null) {
            int count = 0;
            for (Image image : imageList) {
              if (image.getId().equals(productMain.getIdImage())) {
                count++;
              }
            }
            if (count == 0)
              imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
          }
          if (productMain.getIdMemory() != null) {
            int count = 0;
            for (Memory memory : memoryList) {
              if (memory.getId().equals(productMain.getIdMemory())) {
                count++;
              }
            }
            if (count == 0)
              memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
          }
        }
        ProductFull productFull = new ProductFull(productMainList.get(0).getIdProduct(),productMainList.get(0).getIdCategoryProduct(),
            productMainList.get(0).getNameCategoryProduct(),productMainList.get(0).getIdGroupProduct(),productMainList.get(0).getNameGroupProduct(),
            productMainList.get(0).getIdLineProduct(),productMainList.get(0).getNameLineProduct(),colorList,memoryList,imageList,
            productMainList.get(0).getSlug(),productMainList.get(0).getPriceInput(),productMainList.get(0).getPriceOutput(),
            productMainList.get(0).getSale(), imageRepository.getImageByIdImage(productMainList.get(0).getIdImage()),
            colorRepository.getColorByIdColor(productMainList.get(0).getIdColor()),
            memoryRepository.getMemoryByIdMemory(productMainList.get(0).getIdMemory()),
            brandRepository.getBrandByIdBrand(productMainList.get(0).getIdBrand()),
            productMainList.get(0).getDescribeProduct());
        productFullList.add(productFull);
      }
      productByCategory.setListProductCategory(productFullList);
      productByCategoryList.add(productByCategory);
    }
    productIndex.setListCategoryByGroupProduct(categoryByGroupProductList);
    productIndex.setListProductByCategory(productByCategoryList);
    return productIndex;
  }

  public ProductFull getProductBySlug(String slug, int type) {
    ProductMain productMains = null;
    if (type == 0)
      productMains = productRepository.getProductBySlug(slug);
    else
      productMains = productRepository.getProductByIdProduct(slug);

    List<ProductMain> productMainList = productRepository.getProductByIdLineProduct(productMains.getIdLineProduct());
    List<Color> colorList = new ArrayList<>();
    List<Image> imageList = new ArrayList<>();
    List<Memory> memoryList = new ArrayList<>();
    ProductFull productFull = null;
    for (ProductMain productMain: productMainList) {
      if (productMain.getIdColor() != null) {
        int count = 0;
        for (Color color : colorList) {
          if (color.getId().equals(productMain.getIdColor())) {
            count++;
          }
        }
        if (count == 0)
          colorList.add(colorRepository.getColorByIdColor(productMain.getIdColor()));
      }
      if (productMain.getIdImage() != null) {
        int count = 0;
        for (Image image : imageList) {
          if (image.getId().equals(productMain.getIdImage())) {
            count++;
          }
        }
        if (count == 0)
          imageList.add(imageRepository.getImageByIdImage(productMain.getIdImage()));
      }
      if (productMain.getIdMemory() != null) {
        int count = 0;
        for (Memory memory : memoryList) {
          if (memory.getId().equals(productMain.getIdMemory())) {
            count++;
          }
        }
        if (count == 0)
          memoryList.add(memoryRepository.getMemoryByIdMemory(productMain.getIdMemory()));
      }
    }
    productFull = new ProductFull(productMains.getIdProduct(),productMains.getIdCategoryProduct(),
        productMains.getNameCategoryProduct(),productMains.getIdGroupProduct(),productMains.getNameGroupProduct(),
        productMains.getIdLineProduct(),productMains.getNameLineProduct(),colorList,memoryList,imageList,
        productMains.getSlug(),productMains.getPriceInput(),productMains.getPriceOutput(),
        productMains.getSale(),imageRepository.getImageByIdImage(productMains.getIdImage()),
        colorRepository.getColorByIdColor(productMains.getIdColor()),
        memoryRepository.getMemoryByIdMemory(productMains.getIdMemory()),
        brandRepository.getBrandByIdBrand(productMains.getIdBrand()),
        productMains.getDescribeProduct());
    return productFull;
  }

  public String getSlugByColorAndMemory(String idColor,String idMemory,String idLineProduct) {
    return productRepository.getSlugByColorAndMemory(idColor,idMemory,idLineProduct);
  }

}
