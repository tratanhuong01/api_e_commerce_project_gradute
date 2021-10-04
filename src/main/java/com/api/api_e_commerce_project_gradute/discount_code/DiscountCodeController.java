package com.api.api_e_commerce_project_gradute.discount_code;

import com.api.api_e_commerce_project_gradute.DTO.specification.discount_code.DiscountCodeCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DiscountCodeController {

  @Autowired
  DiscountCodeService discountCodeService;

  @GetMapping("discountCodeFiltersAll")
  public Integer getDiscountCodeFiltersAll( Integer typeDiscountCode,String keyword, String expired, String newBestSorter,
                                            String percentSorter, String maxSorter, String minSorter) {
    DiscountCodeCriteria discountCodeCriteria = DiscountCodeCriteria.builder()
        .typeDiscountCode(typeDiscountCode)
        .keyword(keyword)
        .expired(expired)
        .newBestSorter(newBestSorter)
        .percentSorter(percentSorter)
        .maxSorter(maxSorter)
        .minSorter(minSorter)
        .build();
    return discountCodeService.filterDiscountCodeAll(discountCodeCriteria);
  }

  @GetMapping("discountCodeFilters")
  public List<DiscountCode> getDiscountCodeFiltersLimit( Integer typeDiscountCode,String keyword, String expired, String newBestSorter,
                                            String percentSorter, String maxSorter, String minSorter, Integer offset,
                                            Integer limit) {
    DiscountCodeCriteria discountCodeCriteria = DiscountCodeCriteria.builder()
        .typeDiscountCode(typeDiscountCode)
        .keyword(keyword)
        .expired(expired)
        .newBestSorter(newBestSorter)
        .percentSorter(percentSorter)
        .maxSorter(maxSorter)
        .minSorter(minSorter)
        .offset(offset)
        .limit(limit)
        .build();
    return discountCodeService.filterDiscountCodeLimit(discountCodeCriteria);
  }

  @GetMapping("discountCodes")
  public List<DiscountCode> getDiscountCodes() {
    return discountCodeService.getDiscountCodes();
  }

  @PostMapping("discountCodes")
  public DiscountCode addDiscountCode(@RequestBody DiscountCode discountCode) {
    return discountCodeService.addDiscountCode(discountCode);
  }

  @PutMapping("discountCodes")
  public DiscountCode updateDiscountCode(@RequestBody DiscountCode discountCode) {
    return discountCodeService.updateDiscountCode(discountCode);
  }

  @GetMapping("discountCodes/check/isUsed/")
  public DiscountCode checkUserIsUsed(@RequestParam(required = false) String code,
                                      @RequestParam(required = false) String idUser,
                                      @RequestParam(required = false) int isUsed) {
    return discountCodeService.checkUserIsUsed(code,idUser,isUsed);
  }

  @GetMapping("discountCodes/check/valid/")
  public DiscountCode checkDiscountCodeIsValid(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeValid(code);
  }

  @GetMapping("discountCodes/check/expired/")
  public DiscountCode checkDiscountCodeStillExpired(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeStillExpired(code);
  }

}
