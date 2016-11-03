package mavenplugindemo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
 
/**
 * Says "Hi" to the user.
 *
 */
@Mojo( name = "sayhi")
public class GreetingMojo extends AbstractMojo
{
    public void execute() throws MojoExecutionException
    {
    	int sum = 0;
    	for(int i = 1; i <10;i++) {
    		sum+=i;
    	}
        getLog().info( "Calculated sum:" + sum);
    }
}
