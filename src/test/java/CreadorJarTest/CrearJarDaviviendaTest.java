package CreadorJarTest;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import dxc.util.DXCUtil;

public class CrearJarDaviviendaTest {

	// NOTA: DEJAR EN EL JAVA BUILD PATH SÓLO LOS PROYECTOS [DXCBase], [DXCUtil] Y EL REQUERIDO POR EL JAR A GENERAR
	
	@SuppressWarnings("rawtypes")
	static Class[] launchers = {
			// Añadir el proyecto [DAV_ApiRiesgo] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchApiRiesgo.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_AppEmpresas] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchAppEmp_MotorRiesgo.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_AppPersonas] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchAppPer_MotorRiesgo.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_As400] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchAs400_Credito.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_C360] al "Java Build Path" y descomentarear la clase requerida
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_Davicom] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchDavi_Pagos.class
			//launchTest.LaunchDavi_MotorRiesgo.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_MbaasDXC] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchMBaasDXC_AprobacionTC.class
//-----------------------------------------------------------------------------------------------------------------------
			// Añadir el proyecto [DAV_PortalPymes] al "Java Build Path" y descomentarear la clase requerida
			//launchTest.LaunchPymes_MotorRiesgo.class
//-----------------------------------------------------------------------------------------------------------------------
	};
//***********************************************************************************************************************
	public static void main(String[] args) {
		// POR DEFECTO [DXCUtil.PATH_RESOURCES] ESTÁ EN VACÍO - PARA EJECUCIÓN EN ECLIPSE COMENTAREAR LA SIGUIENTE LINEA
		DXCUtil.PATH_RESOURCES = "/resources";
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(launchers);
		testng.addListener(tla);
		testng.run();
	}
//***********************************************************************************************************************
}