package com.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @Author fang
 * @Date 2024/11/8 11:35
 * @注释
 */
public class MetaManager {
//    public static void main(String[] args) {
//        String metaJson = ResourceUtil.readUtf8Str("meta.json");
//        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
//        System.out.println(newMeta);
//    }

    private static volatile Meta meta;
    private MetaManager(){

    }
    public static Meta getMetaObject(){
        if (meta == null){
            synchronized (MetaManager.class){
                if (meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfigDTO fileConfig = newMeta.getFileConfig();
        return newMeta;
    }
}
