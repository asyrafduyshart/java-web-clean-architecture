module asyraf.example.db.psql {
	exports com.asyraf.example.db.psql;
	requires java.annotation;
	requires asyraf.example.domain;
	requires asyraf.example.usecase;
	requires spring.data.jpa;
	requires spring.data.commons;
	requires org.hibernate.orm.core;
	requires java.persistence;
	requires lombok;
	requires spring.context;
	requires spring.beans;
}
