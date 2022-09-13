package internal

import org.gradle.api.Project

class SpringBootPluginUtil {

	static final String PLUGIN_ID_SPRING_BOOT = 'org.springframework.boot'
	static final String PLUGIN_ID_DEPENDENCY_MANAGEMENT = 'io.spring.dependency-management'

	private static final String DEPENDENCY_MANAGEMENT_GRADLE = 'dependency.gradle'

	static void applySpringBoot(Project project) {
		project.apply plugin: PLUGIN_ID_SPRING_BOOT
	}

	static void applyDependencyManagement(Project project) {
		project.apply plugin: PLUGIN_ID_DEPENDENCY_MANAGEMENT

		def script = "${project.rootDir}/${DEPENDENCY_MANAGEMENT_GRADLE}"
		project.apply from: script
	}

}