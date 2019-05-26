module asyraf.example.spring {
	requires asyraf.example.config;
	requires asyraf.example.usecase;
	requires asyraf.example.controller;
	requires spring.web;
	requires spring.beans;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;
	requires spring.data.jpa;
	requires tomcat.embed.core;
	requires java.validation;
	requires lombok;
	requires slf4j.api;
	requires org.apache.commons.lang3;
	requires spring.core;
	requires spring.webmvc;
	requires specification.arg.resolver;
	requires java.annotation;
	requires spring.data.redis;
	requires spring.security.core;
	requires spring.security.web;
	requires asyraf.example.db.psql;

	exports com.asyraf.example.spring;
	exports com.asyraf.example.spring.config;

	opens com.asyraf.example.spring.config to spring.core;
}
