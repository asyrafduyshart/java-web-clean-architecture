module asyraf.example.usecase {
	exports com.asyraf.example.usecase;
	exports com.asyraf.example.usecase.exception;
	exports com.asyraf.example.usecase.port;

	requires asyraf.example.domain;
	requires org.apache.commons.lang3;
}
