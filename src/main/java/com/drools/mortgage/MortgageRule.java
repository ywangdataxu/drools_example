package com.drools.mortgage;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class MortgageRule {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession kSession = kContainer.newStatelessKieSession();
        Applicant applicant = new Applicant("Name", 16);

        System.out.println(applicant.isValid());
        kSession.execute(applicant);
        System.out.println(applicant.isValid());
    }
}
