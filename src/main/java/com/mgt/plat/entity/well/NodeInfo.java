package com.mgt.plat.entity.well;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "node_info")
public class NodeInfo {

  @ApiModelProperty(value = "节点id")
  private String nodeId;

  @ApiModelProperty(value = "节点name")
  private String nodeName;

  @ApiModelProperty(value = "节点图片url")
  private String nodePicture;

  @ApiModelProperty(value = "节点备注")
  private String nodeRemark;

  @ApiModelProperty(value = "节点创建时间")
  private String nodeCreate;

  @ApiModelProperty(value = "节点修改时间")
  private String nodeUpdate;

  @ApiModelProperty(value = "主线id")
  private String  wellId;

  @ApiModelProperty(value = "主线name")
  private String wellName;

  @ApiModelProperty(value = "节点编号")
  private Integer nodeNum;

  @ApiModelProperty(value = "节点状态")
  private Integer nodeState;





}
