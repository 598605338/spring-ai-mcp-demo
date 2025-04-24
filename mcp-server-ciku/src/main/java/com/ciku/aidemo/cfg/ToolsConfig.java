package com.ciku.aidemo.cfg;

import com.ciku.aidemo.biz.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.mcp.SyncMcpToolCallback;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @description:
 * @author: ciku
 * @create: 2025-04-24 18:49
 **/
@Configuration
public class ToolsConfig {

    @Bean
    public ToolCallbackProvider weatherTools(BookService bookService) {
        return MethodToolCallbackProvider.builder().toolObjects(bookService).build();
    }

    @Bean
    public List<McpServerFeatures.SyncResourceSpecification> myResources() {
        var systemInfoResource = new McpSchema.Resource("/Users/lixinling/Downloads", "oms.md", "提供一个OMS接口文档", "application/json", null);
        var resourceSpecification = new McpServerFeatures.SyncResourceSpecification(systemInfoResource, (exchange, request) -> {
            try {
                var systemInfo = Map.of("oms", "Hello World");
                String jsonContent = new ObjectMapper().writeValueAsString(systemInfo);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), "application/json", jsonContent)));
            }
            catch (Exception e) {
                throw new RuntimeException("Failed to generate system info", e);
            }
        });

        return List.of(resourceSpecification);
    }


    @Bean
    public BiConsumer<McpSyncServerExchange, List<McpSchema.Root>> rootsChangeHandler() {
        return (exchange, roots) -> {
            System.out.println("Registering root changed");
        };
    }
}
