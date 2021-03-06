package com.pivotal.cloudfoundry.monitoring.hyperic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.junit.Before;
import org.junit.Test;

import com.pivotal.cloudfoundry.monitoring.hyperic.services.CFService;

public class JMXClientTest {
	
	private String jmxURL = "service:jmx:rmi:///jndi/rmi://10.68.45.123:44444/jmxrmi";
	private String user = "admin";
	private String password = "password";
	private JMXClient client = null;

	@Before
	public void JMXClient()
	{
		client = JMXClient.getInstance();
	}
	
	@Test
	public void testGetInstance() {
		JMXClient client = JMXClient.getInstance();
		assertNotNull(getClass());
	}
	
	@Test
	public void testdecomposeQueryString()
	{
		MBeanTuple tuple = client.decomposeQueryString("org.cloudfoundry:deployment=cf,job=doppler-partition-8e8c707a80736630e880,index=0,ip=10.68.45.30:UpTime");
		assertTrue(tuple.getName().equalsIgnoreCase("org.cloudfoundry:deployment=cf,job=doppler-partition-8e8c707a80736630e880,index=0,ip=10.68.45.30"));
		assertTrue(tuple.getProperty().equalsIgnoreCase("UpTime"));
	}

//	@Test
//	public void testGetPropertyValue() {
//		Double propertyValue = 0d;
//		try {
//			propertyValue = client.getPropertyValue("org.cloudfoundry:deployment=cf,job=doppler-partition-*,index=0,ip=10.68.45.30:opentsdb.nozzle.DopplerServer.dropsondeListener.receivedMessageCount");
//		} catch (AttributeNotFoundException | InstanceNotFoundException
//				| MalformedObjectNameException | MBeanException
//				| ReflectionException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertTrue(propertyValue > 1);
//	}
//
//	@Test
//	public void testConnect() {
//		try
//		{
//			client.connect(this.jmxURL, this.user, this.password);
//		}
//		catch (Exception ex)
//		{
//			fail("Exception throw connecting to JMX endpoint. Validate endpoint is correct");
//		}
//	}
//
//	@Test
//	public void testIsConnected() {
//		try
//		{
//			client.connect(this.jmxURL, this.user, this.password);
//		}
//		catch (Exception ex)
//		{
//			fail("Exception throw connecting to JMX endpoint. Validate endpoint is correct");
//		}
//		assertTrue(client.isConnected());
//	}
//	
//	@Test
//	public void testGetMBeans()
//	{
//		try
//		{
//			client.connect(this.jmxURL, this.user, this.password);
//			Set<ObjectName> names = client.getMBeans();
//			Map<String, ObjectName> mBeans = new HashMap<String, ObjectName>();
//			for(ObjectName obj : names)
//			{
//				mBeans.put(obj.getKeyProperty("job"), obj);
//			}
//			
//			//Assert these mBean components exist. The will change over time.
//			//assertTrue(mBeans.containsKey("CloudController"));
//			//assertTrue(mBeans.containsKey("DEA"));
//			assertTrue(mBeans.containsKey("doppler-partition-8e8c707a80736630e880"));
////			assertTrue(mBeans.containsKey("HM9000"));
////			assertTrue(mBeans.containsKey("LoggregatorTrafficcontroller"));
////			assertTrue(mBeans.containsKey("MetronAgent"));
////			assertTrue(mBeans.containsKey("Router"));
////			assertTrue(mBeans.containsKey("collector"));
////			assertTrue(mBeans.containsKey("etcd"));
////			assertTrue(mBeans.containsKey("uaa"));
//		}
//		catch(Exception ex)
//		{
//			fail("Excption thrown connecting to JMX endpoint, Validate endpoint is correct and accessible.");
//		}
//		
//	}
//	
//	@Test
//	public void testCreateCFServiceList()
//	{
//		try
//		{
//			client.connect(this.jmxURL, this.user, this.password);
//			List<CFService> services = client.createCFServiceList(client.getMBeans());
//			
//		}
//		catch (Exception ex)
//		{
//			fail("Exception thrown connecting to JMX endpoint, validate endpoint is correct and accessible");
//		}
//	}
//	
//
//	@Test
//	public void testGetServices() {
//		try{
//			client.connect(this.jmxURL, this.user, this.password);
//		}
//		catch (Exception e)
//		{
//			fail("unable to connect to JMX endpoint");
//		}
//		List services = client.getServices();
//		assertTrue(services.size() > 0);
//	}

}
