package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import internal.SpringBootPluginUtil

class SpringBootApplicationPlugin implements Plugin<Project> {

	void apply(Project project) {
		SpringBootPluginUtil.enablePluginForSpringBootApplication(project)
/*
println '1'
		project.buildscript {
println '2'
			repositories {
				gradlePluginPortal()
			}
			dependencies {
println '3'
				classpath "org.springframework.boot:spring-boot-gradle-plugin:2.7.3"
println '4'
//				classpath "io.spring.gradle:dependency-management-plugin:1.0.13.RELEASE"
			}
		}
println "pluginManager.findPlugin=" +		project.pluginManager.findPlugin('org.springframework.boot')
		project.apply plugin: 'org.springframework.boot'
println "pluginManager.findPlugin=" +		project.pluginManager.findPlugin('org.springframework.boot')
*/
	}
}