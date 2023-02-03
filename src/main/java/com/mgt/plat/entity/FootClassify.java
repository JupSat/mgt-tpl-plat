package com.mgt.plat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食品分类实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootClassify {

  private Long footId;
  private String footCategory;
  private String footCode;
  private String footRedundancy;


  public Long getFootId() {
    return footId;
  }

  public void setFootId(Long footId) {
    this.footId = footId;
  }


  public String getFootCategory() {
    return footCategory;
  }

  public void setFootCategory(String footCategory) {
    this.footCategory = footCategory;
  }


  public String getFootCode() {
    return footCode;
  }

  public void setFootCode(String footCode) {
    this.footCode = footCode;
  }

  public String getFootRedundancy() {
    return footRedundancy;
  }

  public void setFootRedundancy(String footRedundancy) {
    this.footRedundancy = footRedundancy;
  }
}
