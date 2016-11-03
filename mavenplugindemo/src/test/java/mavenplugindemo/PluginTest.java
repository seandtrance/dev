package mavenplugindemo;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class PluginTest extends AbstractMojoTestCase
{
/**
 * @see junit.framework.TestCase#setUp()
 */
protected void setUp() throws Exception
{
    // required for mojo lookups to work
    super.setUp();
}

/**
 * @throws Exception
 */
public void testMojoGoal() throws Exception
{
    File testPom = new File( getBasedir(),
      "src/test/resources/pom.xml" );

    GreetingMojo mojo = (GreetingMojo) lookupMojo( "sayhi", testPom );

    assertNotNull( mojo );
}
}
