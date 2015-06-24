package com.drools.firealarm;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class FireAlarmRule {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();

        String[] names = { "kitchen", "bedroom", "office", "livingroom" };
        Map<String, Room> name2room = new HashMap<>();
        for (String name : names) {
            Room room = new Room(name);
            name2room.put(name, room);
            kSession.insert(room);
            Sprinkler sprinkler = new Sprinkler(room);
            kSession.insert(sprinkler);
        }

        Fire kitechFire = new Fire(name2room.get("kitchen"));
        FactHandle kitechFireHandle = kSession.insert(kitechFire);

        Fire officeFire = new Fire(name2room.get("office"));
        FactHandle officeFireHandle = kSession.insert(officeFire);

        kSession.fireAllRules();

        System.out.println("\nPut off all the fires\n");
        kSession.delete(kitechFireHandle);
        kSession.delete(officeFireHandle);
        kSession.fireAllRules();
    }
}
