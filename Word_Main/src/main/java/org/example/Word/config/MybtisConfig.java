package org.example.Word.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"org.example.Word.mapper","org.example.Word.dao"})
public class MybtisConfig {
}
