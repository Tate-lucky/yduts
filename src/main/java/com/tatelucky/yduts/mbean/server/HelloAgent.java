package com.tatelucky.yduts.mbean.server;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.IOException;

/**
 * @author tangsheng
 * @since 2019-07-15
 */
public class HelloAgent {

    public static void main(String[] args)
            throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, IOException {

//        int rmiPort = 1089;
//        String jmxServerName = "testJMXServer";
//
//        Registry registry = LocateRegistry.createRegistry(rmiPort);
//        MBeanServer mbs = MBeanServerFactory.createMBeanServer(jmxServerName);
//
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        ObjectName adapterName;
//        adapterName = new ObjectName(jmxServerName + ":name=" + "htmladapter");
//        adapter.setPort(8082);
//        adapter.start();
//        mbs.registerMBean(adapter, adapterName);
//
//        ObjectName objName = new ObjectName(jmxServerName + ":name=" + "HelloWorld");
//        mbs.registerMBean(new Hello(), objName);
//
//        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + jmxServerName);
//        System.out.println("JMXServiceURL: " + jmxServiceURL.toString());
//        JMXConnectorServer jmxConnServer = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, mbs);
//        jmxConnServer.start();

    }
}
