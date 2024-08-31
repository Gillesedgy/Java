plugins {
	id 'java'
	id 'org.springframework.boot' version '3.3.3'
	id 'io.spring.dependency-management' version '1.1.6'
}

group = 'com.bank'
version = '0.0.1-SNAPSHOT'

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	runtimeOnly 'org.postgresql:postgresql'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
	//?
//	implementation 'jakarta.validation:jakarta.validation-api:3.0.2'
//	implementation 'org.hibernate.validator:hibernate-validator:7.0.1.Final'
//	implementation 'org.glassfish:jakarta.el:3.0.4'


	//! Found Online
	annotationProcessor 'org.projectlombok:lombok'
	compileOnly 'org.projectlombok:lombok'
}

tasks.named('test') {
	useJUnitPlatform()
}
