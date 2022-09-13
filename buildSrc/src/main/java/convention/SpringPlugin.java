package convention;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.PluginManager;

public class SpringPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		PluginManager manager = project.getPluginManager();
		manager.apply("");
		
	}
	
/*
    void apply(Project project) {
        project.task('hello') {
            doLast {
                println 'Hello from the GreetingPlugin'
            }
        }
    }
*/
}