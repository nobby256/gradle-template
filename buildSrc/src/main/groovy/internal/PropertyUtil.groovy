package internal

import org.gradle.api.Project

class PropertyUtil {
	static final String KEY_CONFIG_DIR = 'configDir'
	static final String DEFAULT_CONFIG_DIR = 'config'

	static final String KEY_DEPLOYMENT_REPOSITORY = 'deploymentRepository'

	static String configDir(Project project) {
		def value = DEFAULT_CONFIG_DIR
		if (project.hasProperty(KEY_CONFIG_DIR)) {
			value = project.property(KEY_CONFIG_DIR)
		}
		return "${project.rootDir}/${value}"
	}

	static Object deploymentRepository(Project project) {
		def value = null
		if (project.hasProperty(KEY_DEPLOYMENT_REPOSITORY)) {
			value = project.property(KEY_DEPLOYMENT_REPOSITORY)
		}
		return value
	}

}