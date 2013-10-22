thymesheet-spring3
==================

Thymesheet integration module for Spring 3


    <bean id="templateEngine"
          class="com.connect_group.thymesheet.spring3.SpringThymesheetTemplateEngine">
      <property name="templateResolver" ref="templateResolver" />
      <property name="additionalDialects">
        <set>
            <bean class="com.connect_group.thymesheet.sample.dialect.SampleDialect"/>
        </set>
      </property>
    </bean>
