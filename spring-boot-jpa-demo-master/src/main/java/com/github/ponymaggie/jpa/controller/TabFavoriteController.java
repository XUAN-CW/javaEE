package com.github.ponymaggie.jpa.controller;

//import com.github.ponymaggie.jpa.repository.StudentRepository;
import com.github.ponymaggie.jpa.repository.TabFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author XUAN
 * @date 2020/11/1 - 1:18
 * @references
 * @purpose
 * @errors
 */
@RestController
public class TabFavoriteController {
    @Autowired
    private TabFavoriteRepository tabFavoriteRepository;
    // http://localhost:8081/getRidAndUid?rid=1&uid=1
    @RequestMapping(value = "/getRidAndUid")
    public boolean getRidAndUid(HttpServletResponse response,String rid, String uid) {
        System.out.println("rid:"+rid+" uid:"+uid+"\t"+new Date());
        boolean flag = true;
        if (null == tabFavoriteRepository.getRidAndUid(Integer.valueOf(rid),Integer.valueOf(uid))){
            flag=false;
        }
        response.setHeader("Access-Control-Allow-Origin","*");
        return flag;
    }
}
