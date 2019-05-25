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

	exports com.asyraf.example.spring;
	exports com.asyraf.example.spring.config;
	opens com.asyraf.example.spring.config to spring.core;
}
