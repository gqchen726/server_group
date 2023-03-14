package com.tianyuge.tools.bean.tool;

import com.tianyuge.tools.bean.image.ToolImage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: guoqing.chen01@hand-china.com 2022-03-11 08:25
 **/

@ApiModel("工具")
@Entity
@Table(name = "t_tool")
@Data
public class Tool {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "主键", required = true)
    @Column(name = "tool_id", unique = true)
    private Integer toolId;

    @ApiModelProperty(value = "工具编码", allowEmptyValue = true)
    @Column(name = "tool_code")
    private String toolCode;

    @ApiModelProperty(value = "工具名称", allowEmptyValue = true)
    @Column(name = "tool_code")
    private String toolName;

    @ApiModelProperty(value = "工具简述", allowEmptyValue = true)
    @Column(name = "tool_desc")
    private String toolDesc;

    @ApiModelProperty(value = "工具描述", allowEmptyValue = true)
    @Column(name = "tool_code")
    private String toolDescription;

    @ApiModelProperty(value = "工具地址", allowEmptyValue = true)
    @Column(name = "tool_url")
    private String toolUrl;

    @ApiModelProperty(value = "工具图像", allowEmptyValue = true)
    @OneToMany(targetEntity = ToolImage.class, mappedBy = "tool")
    private List<ToolImage> toolImages;

    @ApiModelProperty(value = "工具图像", allowEmptyValue = true)
    @ManyToOne
    @JoinColumn(name = "tool_group_id")
    private ToolGroup toolGroup;
}
