package com.example.studyspringboot.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MayiController {
    private static final Logger logger = LoggerFactory.getLogger(MayiController.class);

    private volatile TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    /**
     * 存储用户上传的数据
     *
     * @param list
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    @ResponseBody
    public void insertBatch(@RequestBody ArrayList<String> list) {
        logger.info("insert start list = {}", JSON.toJSONString(list));
        list.forEach(word -> {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        });

    }

    /**
     * 查询出现频率最高的前一百个单词及出现个数
     *
     * @return
     */
    @RequestMapping(value = "/selectLimit100")
    @ResponseBody
    public Map<String, Integer> selectLimit100() {
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        logger.info("排序后的list list={}", JSON.toJSONString(list));

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }

        return map;
    }
}
