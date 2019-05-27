package com.asyraf.example.db.psql.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.asyraf.example.db.psql.*"})
public class PSQLConfiguration { }
