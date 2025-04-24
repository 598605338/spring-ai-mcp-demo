package com.ciku.aidemo;

import com.ciku.aidemo.biz.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerCikuApplication {
    private static final Logger logger = LoggerFactory.getLogger(McpServerCikuApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(McpServerCikuApplication.class, args);
    }



}
