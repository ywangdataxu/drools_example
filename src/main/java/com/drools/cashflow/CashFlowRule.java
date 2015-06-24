package com.drools.cashflow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class CashFlowRule {
    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession kSession = kContainer.newStatelessKieSession();

        Account acc = new Account();
        acc.setAccountNum(123L);
        acc.setBalance(1.2);

        AccountPeriod ap = new AccountPeriod();

        ap.setStart(format.parse("05/01/2015"));
        ap.setEnd(format.parse("08/01/2015"));

        CashFlow cashFlow = new CashFlow();
        cashFlow.setAccountNum(123L);
        cashFlow.setAmount(2);
        cashFlow.setType(CashFlow.Type.CREDIT);
        cashFlow.setDate(format.parse("06/01/2015"));

        kSession.execute(Arrays.asList(new Object[] { acc, ap, cashFlow }));
    }
}
