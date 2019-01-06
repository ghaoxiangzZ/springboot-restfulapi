    /*
     * 文件名: com.dundunmonster.springbootrestfulapi.web
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
    package com.dundunmonster.springbootrestfulapi.web;

    import com.dundunmonster.springbootrestfulapi.domain.User;
    import org.springframework.web.bind.annotation.*;

    import java.util.*;

    /**
     * @author ghaoxiang
     * @version V1.0
     * @Title UserController
     * @Description
     * @date 2019年01月06日 20:41
     * @since V1.0
     */

    @RestController
    @RequestMapping(value="/users")
    public class UserController {

        // 创建线程安全的Map
        static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

        @RequestMapping(value="/", method= RequestMethod.GET)
        public List<User> getUserList() {
            // 处理"/users/"的GET请求，用来获取用户列表
            // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
            List<User> userList = new ArrayList<>(users.values());
            return userList;
        }

        @RequestMapping(value="/", method=RequestMethod.POST)
        public String postUser(@ModelAttribute User user) {
            // 处理"/users/"的POST请求，用来创建User
            // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
            users.put(user.getId(), user);
            return "success";
        }

        @RequestMapping(value="/{id}", method=RequestMethod.GET)
        public User getUser(@PathVariable Long id) {
            // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
            // url中的id可通过@PathVariable绑定到函数的参数中
            return users.get(id);
        }

        @RequestMapping(value="/{id}", method=RequestMethod.PUT)
        public String putUser(@PathVariable Long id, @ModelAttribute User user) {
            // 处理"/users/{id}"的PUT请求，用来更新User信息
            User u = users.get(id);
            u.setName(user.getName());
            u.setAge(user.getAge());
            users.put(id, u);
            return "success";
        }

        @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
        public String deleteUser(@PathVariable Long id) {
            // 处理"/users/{id}"的DELETE请求，用来删除User
            users.remove(id);
            return "success";
        }
    }
