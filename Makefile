make: common/ client/ bank/
	javac common/*.java
	javac client/*.java
	javac bank/*.java

clean:
	rm bank/*.class
	rm client/*.class
	rm common/*.class

setup: 
	rmiregistry 1234 &

runServer: 
	java bank.RemoteAccount

runClient: 
	java client.AccountClient
