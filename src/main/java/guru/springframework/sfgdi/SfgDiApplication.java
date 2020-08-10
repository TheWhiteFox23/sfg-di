package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"guru.springframework.sfgdi.controllers", "guru.springframework.sfgdi.services"})
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println(myController.sayHello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).getGreeting());
		System.out.println(ctx.getBean(SetterInjectedController.class).getGreeting());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).getGreeting());

		FakeDataSource fakeDataSource = (FakeDataSource)ctx.getBean(FakeDataSource.class);
		System.out.println("// User : " + fakeDataSource.getUser() +
				"\n// Password : " + fakeDataSource.getPassword() +
				"\n// URL : " + fakeDataSource.getUrl());
	}

}
