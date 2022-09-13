package internal

import org.gradle.api.Project

class SpringBootPluginUtil {

	private static final String DEPENDENCY_MANAGEMENT_GRADLE = 'dependency.gradle'

	static void enablePluginForSpringBootApplication(Project project) {
		loadSpringBootPlugin(project, true)
		applyDependencyManagement(project)
	}

	static void enablePluginForSpringBootLibrary(Project project) {
		loadSpringBootPlugin(project, false)
		applyDependencyManagement(project)
	}

	static void loadSpringBootPlugin(Project project, boolean apply) {
		def version = PropertyUtil.springBootVersion(project)
		loadPlugin(project, "org.springframework.boot:spring-boot-gradle-plugin:${version}")
		if (apply) {
			project.apply plugin: 'org.springframework.boot'
		}
	}

	static void applyDependencyManagement(Project project) {
		loadPlugin(project, 'io.spring.gradle:dependency-management-plugin:1.0.13.RELEASE')
		project.apply plugin: 'io.spring.dependency-management'

		def script = "${project.rootDir}/${DEPENDENCY_MANAGEMENT_GRADLE}"
		project.apply from: script
	}

	static void loadPlugin(Project project, String pluginClasspath) {
		project.buildscript {
			repositories {
				gradlePluginPortal()
			}
			dependencies {
				classpath pluginClasspath
			}
		}
	}

}