package com.tianyuge.tools.bean.image;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tianyuge.tools.bean.tool.Tool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Description: description
 * @author: GuoqingChen
 * @Time: 2023/03/14 22:24
 * @Email: guoqing.chen01@hand-china.com
 */
@ApiModel("工具图像")
@Entity
@Table(name = "t_tool_image")
@Data
public class ToolImage {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "主键", required = true)
    @Column(name = "tool_image_id", unique = true)
    private Integer toolImageId;

    @ApiModelProperty(value = "工具图像编码", allowEmptyValue = true)
    @Column(name = "tool_image_code", unique = true)
    private String toolImageCode;

    @ApiModelProperty(value = "工具图像名称", allowEmptyValue = true)
    @Column(name = "tool_image_name", unique = true)
    private String toolImageName;

    @ApiModelProperty(value = "工具图像简述", allowEmptyValue = true)
    @Column(name = "tool_image_desc")
    private String toolImageDesc;

    @ApiModelProperty(value = "工具图像描述", allowEmptyValue = true)
    @Column(name = "tool_image_description")
    private String toolImageDescription;

    @ApiModelProperty(value = "工具图像Url", allowEmptyValue = true)
    @Column(name = "tool_image_url")
    private String toolImageUrl;

    @ManyToOne
    @JoinColumn(name = "tool_f_id")
    @JsonBackReference
    private Tool tool;
}
