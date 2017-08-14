1. Don't forget `converter.setTypeIdPropertyName("User");` on message converter or exception shows
2. Please start apache-activemq-5.15.0\bin\win64\activemq.bat before running main method
3. Run `jms.JavaConfigSenderTest.java`
4. Go to http://localhost:8161/admin/queues.jsp to see the queue, default login is admin/admin
5. Run `jms.JavaConfigReceiverTest.java`

Or, try XML configuration

1. Please start apache-activemq-5.15.0\bin\win64\activemq.bat before running main method
2. Run `jms.XMLConfigTest`

XML configuration:

1.  2 versions: <bean> and <amq>
2. Has listener so no need to start a receiver
3. I cannot deploy a custom message converter in neither version