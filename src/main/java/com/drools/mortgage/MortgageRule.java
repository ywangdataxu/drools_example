package com.drools.mortgage;

import java.util.Arrays;
import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class MortgageRule {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession kSession = kContainer.newStatelessKieSession();
        Applicant applicant = new Applicant("Name", 20);
        Application application = new Application(new Date());

        System.out.println("Before rules: application.valid? " + application.isValid());
        kSession.execute(Arrays.asList(new Object[] { application, applicant }));

        System.out.println("After rules: application.valid? " + application.isValid());
    }
}
