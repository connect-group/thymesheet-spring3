thymesheet-spring3
==================

Thymesheet integration module for Spring 3

# Maven

		<dependency>
			<groupId>com.connect-group</groupId>
			<artifactId>thymesheet-spring3</artifactId>
			<version>2.2.0</version>
		</dependency>

# Spring Configuration

    <bean id="templateEngine"
          class="com.connect_group.thymesheet.spring3.SpringThymesheetTemplateEngine">
      <property name="templateResolver" ref="templateResolver" />
      <property name="additionalDialects">
        <set>
            <bean class="com.connect_group.thymesheet.sample.dialect.SampleDialect"/>
        </set>
      </property>
    </bean>
