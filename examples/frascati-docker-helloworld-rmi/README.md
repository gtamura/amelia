# FraSCAti helloworld-rmi (Docker)

This example runs FraSCAti 1.4 on docker and compiles and executes the helloworld-rmi project from the FraSCAti distribution. It requires specifying the following parameters:

- __host__: the host name to install docker and run the container
- __privileged-user__: a privileged user to install Docker
- __unprivileged-user__: an unprivileged user to run the container

By default, the project pom defines these parameters as follow:

- host = localhost
- privileged-user = root
- unprivileged-user = ${user.name} # the user running maven

To run the example:

1. [Package and install the language artefacts](/README.md#compiling-from-sources)
2. Execute the Java application generated by the Amelia compiler:

```bash
mvn exec:java -Dhost=... # specify here the rest of the parameters
```

If everything ran correctly, you should see the following message:

```
Compiling ...
client/src
client

Library client.jar created!
Running OW2 FraSCAti ...

OW2 FraSCAti Standalone Runtime
CLIENT created
CLIENT initialized
Call the service...
Call done!
Exiting OW2 FraSCAti ...
```
