module asyraf.example.config {
	exports com.asyraf.config;

	requires asyraf.example.usecase;
	requires asyraf.example.domain;
	requires asyraf.example.jug;
	requires asyraf.example.uuid;
	requires asyraf.example.db.simple;
	requires asyraf.example.db.hazelcast;
	requires asyraf.example.encoder;
}
