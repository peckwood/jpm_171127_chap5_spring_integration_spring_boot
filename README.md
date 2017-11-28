My Steps:

1. created pom.xml
2. created applicationContext.xml with STS as a Spring bean definition file
3. added beans, aop, context, p, tx, mybatis-spring
4. and so on

Notable files:

1. test file: `/src/test/java/com/raidencentral/service/StudentServiceImplTest.java`
   1. `testSeletStudentById` shows the setup works
   2. `testInsertStudent` shows how the transanction manager rollbacks the transanction when a runtime exception or Error occurs inside method `insertStudent` of `StudentServiceImpl`
2. applicationContext-mixed.xml
   1. shows you that you can put mybatis configuration inside spring configuration file
3. applicationContext-minimum.xml
   1. put as minimal mybatis configuration as possible inside spring configuration.
   2. annotation transanction set up
4. applicationContext-minimum-with-trans.xml and applicationContext-trans.xml
   1. writing aspects in xml to manage transanctions instead of @Transanction
   2. had to add `spring-boot-starter-aop` using Spring Initializer since we are writing custom aspects

### type handlers

you can put in the `sqlSessionFactory` bean

```xml
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="typeHandlersPackage" value="com.raidencentral.app.type_handlers"></property>
		<!-- 加载mybatis的全局配置文件 -->
		<property name="configLocation" value="classpath:mybatis-config.xml" />
	</bean>
```

or inside mybatis-config.xml:

```xml
<configuration>
	<typeHandlers>
		<typeHandler handler="com.raidencentral.app.type_handlers.PhoneNumberTypeHandler"/>
		<package name="com.raidencentral.app.type_handlers"/>
	</typeHandlers>
</configuration>
```

### Mappers:

1. in applicationContext.xml:

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  <property name="dataSource" ref="dataSource" />
  <property name="mapperLocations" value="classpath*:sample/config/mappers/**/*.xml" />
</bean>
```

2. mybatis-spring:scan base-package="com.raidencentral.app.mappers"/>`
3. in mybatis-config.xml

```xml
<mappers>
	<package name="com.raidencentral.app.mappers"/>
</mappers>
```

4. Using the @MapperScan annotation (requires Spring 3.1+) if you are configuring mybatis with Java annotations

### Transanction

```xml
<bean name="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	<property name="dataSource" ref="dataSource"></property>
</bean>
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
<tx:annotation-driven transaction-manager="transactionManager"/>
```

The method `insertStudent` is annotated with `@Transanctional`

tx:annotation-driven is only for annotation based @Transanctional

#### @Transactional

- Seems to work without `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>`or `<tx:annotation-driven transaction-manager="transactionManager"/>`
- have to put on each method/class needed
- runtime exception must be inside the transanctional method

#### writing aspects

- Seems to work without `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>`
- can apply to multiple classes with wildcards
- runtime exception must be inside the transanctional method

Note: I had to use `jdbc.username` instead of `username` because it will use the PC login username to log in if `username` is used :crying_cat_face:

> [official documentation: SqlSessionFactoryBean](http://www.mybatis.org/spring/factorybean.html)
>
> project: jpm_171127_chap5_spring_integration



