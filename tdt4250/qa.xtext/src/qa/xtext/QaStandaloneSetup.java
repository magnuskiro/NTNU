
package qa.xtext;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QaStandaloneSetup extends QaStandaloneSetupGenerated{

	public static void doSetup() {
		new QaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

