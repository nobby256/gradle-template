package internal

import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.jvm.toolchain.JvmVendorSpec

class PropertyUtil {
	static final String KEY_CONFIG_DIR = 'configDir'
	static final String KEY_DEPLOYMENT_REPOSITORY = 'deploymentRepository'
	static final String KEY_JVM_VERSION = 'jvmVersion'
	static final String KEY_JVM_VENDOR = 'jvmVendor'
	static final String KEY_SPRING_BOOT_VERSION = 'springBootVersion'
	
	static final String DEFAULT_CONFIG_DIR = 'config'
	static final String DEFAULT_JVM_VERSION = '11'
	static final String DEFAULT_JVM_VENDOR = 'any'
	
	static String configDir(Project project) {
		def value = DEFAULT_CONFIG_DIR
		if (project.hasProperty(KEY_CONFIG_DIR)) {
			value = project.property(KEY_CONFIG_DIR)
		} else {
			value = "${project.rootDir}/${DEFAULT_CONFIG_DIR}"
		}
		return value
	}

	static Object deploymentRepository(Project project) {
		def value = null
		if (project.hasProperty(KEY_DEPLOYMENT_REPOSITORY)) {
			value = project.property(KEY_DEPLOYMENT_REPOSITORY)
		}
		return value
	}

	static JavaLanguageVersion jvmVersion(Project project) {
		JavaLanguageVersion version = null
		if (project.hasProperty(KEY_JVM_VERSION)) {
			def value = project.property(KEY_JVM_VERSION)
			version = JavaLanguageVersion.of(value)
		}
		return version
	}

	// https://github.com/gradle/gradle/tree/d528065a014f833d01cb45632bbd6cc381c3685e/subprojects/platform-jvm/src/main/java/org/gradle/jvm/toolchain
	static JvmVendorSpec jvmVendor(Project project) {
		JvmVendorSpec vendor = null
		if (project.hasProperty(KEY_JVM_VENDOR)) {
			def value = project.property(KEY_JVM_VENDOR)
			if (value instanceof JvmVendorSpec) {
				vendor = value
			} else if (!value.toString().isEmpty()) {
				vendor = JvmVendorSpec.matching(value.toString())
			}
		}
//		if (vendor == null) {
//			throw new MissingPropertyException("${KEY_JVM_VENDOR}が見つからないか、型がStringもしくはorg.gradle.jvm.toolchain.JvmVendorSpecではありません", KEY_JVM_VERSION, this.class)
//		}
		return vendor
	}

	static String springBootVersion(Project project) {
		return project.hasProperty(KEY_SPRING_BOOT_VERSION)
	}

}