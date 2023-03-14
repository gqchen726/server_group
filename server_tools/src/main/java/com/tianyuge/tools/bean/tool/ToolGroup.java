package com.tianyuge.tools.bean.tool;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: guoqing.chen01@hand-china.com 2022-03-11 08:25
 **/

@ApiModel("对象信息")
@Entity
@Table(name = "t_tool_group")
@Data
public class ToolGroup {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "主键", required = true)
    @Column(name = "tool_group_id", unique = true)
    private Integer toolGroupId;

    @ApiModelProperty(value = "工具分组编码", allowEmptyValue = true)
    @Column(name = "tool_group_code")
    private String toolGroupCode;

    @ApiModelProperty(value = "工具分组名称", allowEmptyValue = true)
    @Column(name = "tool_group_name")
    private String toolGroupName;

    @ApiModelProperty(value = "工具分组名称", allowEmptyValue = true)
    @OneToMany(targetEntity = Tool.class, mappedBy = "toolGroup")
    private List<Tool> tools;
}
