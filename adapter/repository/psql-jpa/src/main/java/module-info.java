module asyraf.example.db.psql {
	exports com.asyraf.example.db.psql.component;
	exports com.asyraf.example.db.psql.configuration;

	exports com.asyraf.example.db.psql.repo;
	exports com.asyraf.example.db.psql.po;
	exports com.asyraf.example.db.psql.domain;

	requires asyraf.example.domain;
	requires asyraf.example.usecase;

	requires java.annotation;
	requires spring.context;
	requires spring.data.jpa;
	requires spring.data.commons;
	requires org.hibernate.orm.core;
	requires java.persistence;
	requires lombok;
	requires spring.beans;
	requires spring.tx;
	requires spring.core;
	requires guava;
	requires org.apache.commons.lang3;
	requires java.desktop;

}
