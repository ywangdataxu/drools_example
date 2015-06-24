package com.drools.cashflow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class CashFlowRule {
    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();

        Account acc = new Account();
        acc.setAccountNum(123L);
        acc.setBalance(1.2);

        AccountPeriod ap = new AccountPeriod();

        ap.setStart(format.parse("05/01/2015"));
        ap.setEnd(format.parse("08/01/2015"));

        CashFlow creditCashFlow = new CashFlow();
        creditCashFlow.setAccountNum(123L);
        creditCashFlow.setAmount(2);
        creditCashFlow.setType(CashFlow.Type.CREDIT);
        creditCashFlow.setDate(format.parse("06/01/2015"));

        CashFlow debitCashFlow = new CashFlow();
        debitCashFlow.setAccountNum(123L);
        debitCashFlow.setAmount(1);
        debitCashFlow.setType(CashFlow.Type.DEBIT);
        debitCashFlow.setDate(format.parse("06/01/2015"));

        // kSession.execute(Arrays.asList(new Object[] { acc, ap, creditCashFlow, debitCashFlow }));
        kSession.insert(acc);
        kSession.insert(ap);
        kSession.insert(creditCashFlow);
        kSession.insert(debitCashFlow);

        Agenda agenda = kSession.getAgenda();
        agenda.getAgendaGroup("report").setFocus();
        agenda.getAgendaGroup("calculation").setFocus();
        kSession.fireAllRules();
    }
}
