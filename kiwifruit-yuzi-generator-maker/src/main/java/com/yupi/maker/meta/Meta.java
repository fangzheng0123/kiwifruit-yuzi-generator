package com.yupi.maker.meta;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author fang
 * @Date 2024/11/8 11:28
 * @注释
 */
@NoArgsConstructor
@Data
public class Meta {


    private String name;
    private String description;
    private String basePackage;
    private String version;
    private String author;
    private String createTime;
    private FileConfigDTO fileConfig;
    private ModelConfigDTO modelConfig;

    @NoArgsConstructor
    @Data
    public static class FileConfigDTO {
        private String inputRootPath;
        private String outputRootPath;
        private String type;
        private List<FilesInfo> files;

        @NoArgsConstructor
        @Data
        public static class FilesInfo {
            private String inputPath;
            private String outputPath;
            private String type;
            private String generateType;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ModelConfigDTO {
        private List<ModelsInfo> models;

        @NoArgsConstructor
        @Data
        public static class ModelsInfo {
            private String fieldName;
            private String type;
            private String description;
            private Object defaultValue;
            private String abbr;
        }
    }
}
