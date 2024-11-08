package com.yupi.model;

import lombok.Data;

@Data
public class DataModel {
    /*
    * 是否生成循环
    * false
    */
    private boolean loop = false;
    /*
    * 作者注释
    * "yupi"
    */
    private String author = "yupi";
    /*
    * 输出信息
    * "sum = "
    */
    private String outputText = "sum = ";

}
