1. Don't forget `converter.setTypeIdPropertyName("User");` on message converter
2. Please start apache-activemq-5.15.0\bin\win64\activemq.bat before running main method
3. Run `jms.SenderTest.java`
4. Go to http://localhost:8161/admin/queues.jsp to see the queue, default login is admin/admin
5. Run `jms.ReceiverTest.java`