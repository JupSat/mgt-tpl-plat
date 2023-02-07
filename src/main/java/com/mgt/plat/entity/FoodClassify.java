package com.mgt.plat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package name：com.mgt.plat.entity
 * description：食品分类实体类
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodClassify {
  private Long id;
  private String ingredientCategory;
  private String code;
  private String redundancy;

}
