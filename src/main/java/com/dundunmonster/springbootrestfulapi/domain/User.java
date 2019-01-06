    /*
     * 文件名: com.dundunmonster.springbootrestfulapi.domain
     * 文件编号:
     * 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
     * 描述:
     * 创建人: ghaoxiang
     * 创建时间: 2019年01月06日 20:41
     * 修改人:
     * 修改时间: 2019年01月06日 20:41
     * 修改变更号:
     * 修改内容:
     */
    package com.dundunmonster.springbootrestfulapi.domain;

    /**
     * @author ghaoxiang
     * @version V1.0
     * @Title User
     * @Description
     * @date 2019年01月06日 20:41
     * @since V1.0
     */
    public class User {
        private Long id;

        private String name;

        private Integer age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
