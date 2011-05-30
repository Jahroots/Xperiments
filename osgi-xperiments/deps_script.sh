#!/bin/sh

# --------------------------------------------------------------------
# Add Repositories
# --------------------------------------------------------------------
#pax-add-repository -i com.springsource.repository.bundles.release -u http://repository.springsource.com/maven/bundles/release
#pax-add-repository -i com.springsource.repository.bundles.external -u http://repository.springsource.com/maven/bundles/external
#pax-add-repository -i spring-maven-milestone -u http://maven.springframework.org/milestone
#pax-add-repository -i ops4j.releasees -u http://repository.ops4j.org/maven2/
#pax-add-repository -i ops4j.mvn-snapshots -u http://repository.ops4j.org/mvn-snapshots/
#pax-add-repository -i jboss.repo -u http://repository.jboss.org/maven2/

# --------------------------------------------------------------------
# Add Commun Deps
# --------------------------------------------------------------------
#pax-import-bundle -g org.apache.commons -a com.springsource.org.apache.commons.logging -v 1.1.1
#pax-import-bundle -g org.aopalliance -a com.springsource.org.aopalliance -v 1.0.0
#pax-import-bundle -g org.aspectj -a com.springsource.org.aspectj.tools -v 1.6.8.RELEASE
#pax-import-bundle -g javax.jms -a com.springsource.javax.jms -v 1.1.0
#pax-import-bundle -g javax.xml.stream -a com.springsource.javax.xml.stream -v 1.0.1
#pax-import-bundle -g edu.emory.mathcs.backport -a com.springsource.edu.emory.mathcs.backport -v 3.1.0
#pax-import-bundle -g com.sun.enterprise -a com.springsource.com.sun.enterprise.loader -v 1.0.0
#pax-import-bundle -g javax.activation -a com.springsource.javax.activation -v 1.1.0
#pax-import-bundle -g javax.persistence -a com.springsource.javax.persistence -v 1.0.0
#pax-import-bundle -g javax.portlet -a com.springsource.javax.portlet -v 1.0.0
#pax-import-bundle -g javax.servlet -a com.springsource.javax.servlet -v 2.4.0
#pax-import-bundle -g javax.servlet -a com.springsource.javax.servlet.jsp -v 2.1.0
#pax-import-bundle -g javax.transaction -a com.springsource.javax.transaction -v 1.1.0

#pax-import-bundle -g org.osgi -a org.osgi.core -v 4.2.0
#pax-import-bundle -g org.osgi -a org.osgi.compendium -v 4.2.0
#pax-import-bundle -g javax.el -a com.springsource.javax.el -v 1.0.0

# --------------------------------------------------------------------
# Add Spring OSGi Deps
# --------------------------------------------------------------------
# [INFO] Ignoring non-bundle dependency com.oracle.oc4j:com.springsource.oracle.classloader:jar:10.1.3.1
# [INFO] Importing Unnamed - com.sun.enterprise:com.springsource.com.sun.enterprise.loader:jar:1.0.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.activation:com.springsource.javax.activation:jar:1.1.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.persistence:com.springsource.javax.persistence:jar:1.0.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.portlet:com.springsource.javax.portlet:jar:1.0.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.servlet:com.springsource.javax.servlet:jar:2.4.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.servlet:com.springsource.javax.servlet.jsp:jar:2.1.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.jms:com.springsource.javax.jms:jar:1.1.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
# [INFO] Importing Unnamed - javax.transaction:com.springsource.javax.transaction:jar:1.1.0 to fr.jahroots.xperiments.osgi.xperiments.build:provision:pom:1.0
#pax-import-bundle -g org.springframework.osgi -a spring-osgi-extender -v 1.2.1  -- -DimportTransitive -DwidenScope


springOsgiVerion=1.2.1
#pax-import-bundle -g org.springframework.osgi -a spring-osgi-io -v $springOsgiVerion
#pax-import-bundle -g org.springframework.osgi -a spring-osgi-core -v $springOsgiVerion
#pax-import-bundle -g org.springframework.osgi -a org.springframework.osgi.core -v $springOsgiVerion

# --------------------------------------------------------------------
# Add Spring Deps
# --------------------------------------------------------------------
sprinVersion=3.0.5.RELEASE
#pax-import-bundle -g org.springframework -a org.springframework.core -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.aop -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.asm -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.beans -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.aspects -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.context -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.context.support -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.expression -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.transaction -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.jdbc -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.jms -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.orm -v $sprinVersion
#pax-import-bundle -g org.springframework -a org.springframework.oxm -v $sprinVersion

# --------------------------------------------------------------------
# Add Logging Deps
# --------------------------------------------------------------------
paxLoggingVersion=1.6.2
#pax-import-bundle -g org.ops4j.pax.logging -a pax-logging-api -v $paxLoggingVersion
#pax-import-bundle -g org.ops4j.pax.logging -a pax-logging-service -v $paxLoggingVersion

# --------------------------------------------------------------------
# Add Aries Deps
# --------------------------------------------------------------------
ariesVersion=0.3.1
#pax-import-bundle -g org.apache.aries.blueprint -a org.apache.aries.blueprint -v $ariesVersion
#pax-import-bundle -g org.apache.aries.blueprint -a org.apache.aries.blueprint.cm -v $ariesVersion
#pax-import-bundle -g org.apache.aries.blueprint -a org.apache.aries.blueprint.core -v $ariesVersion
#pax-import-bundle -g org.apache.aries.blueprint -a org.apache.aries.blueprint.annotation.api -v $ariesVersion
#pax-import-bundle -g org.apache.aries.blueprint -a org.apache.aries.blueprint.api -v $ariesVersion

ariesJpaVersion=0.3
#pax-import-bundle -g org.apache.aries.jpa -a org.apache.aries.jpa.blueprint.aries -v $ariesJpaVersion
#pax-import-bundle -g org.apache.aries.jpa -a org.apache.aries.jpa.container.itest  -v $ariesJpaVersion
#pax-import-bundle -g org.apache.aries.jpa -a org.apache.aries.jpa.container.context -v $ariesJpaVersion
#pax-import-bundle -g org.apache.aries.proxy -a org.apache.aries.proxy.api -v $ariesJpaVersion
#pax-import-bundle -g org.apache.aries -a org.apache.aries.util -v $ariesJpaVersion