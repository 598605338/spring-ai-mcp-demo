package com.ciku.aidemo.biz;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: ciku
 * @create: 2025-04-24 18:51
 **/
@Service
public class BookService {

    @Tool(name = "getBook", description = "根据书名获取图书")
    public String getBook(String bookName) {
        System.out.println("getBook:" + bookName);
        return "《" + bookName + "》";
    }

    @Tool(name = "getByAuthor", description = "根据作者名获取图书")
    public List<String> getByAuthor(String author) {
        System.out.println("getByAuthor:" + author);
        return List.of("《仙逆》","《求魔》","《一念永恒》");
    }
}
