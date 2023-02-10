package com.mgt.plat.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package name：com.mgt.plat.entity
 * description：食品名称实体类
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMonicker {
  private Long id;
  private Long catalogId;
  private String ingredientName;
  private String ingredientImg;
  private String ingredientDesc;
  private String ingredientRedundancy;
}
