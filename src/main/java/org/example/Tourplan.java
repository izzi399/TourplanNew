package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Tourplan enthält eine Liste von Klienten, die
 * von der Pflegefachkfraft behandelt werden sollten.
 * Im Tourplan sollten keine redundanten Klientennamen
 * enthalten sein. Die Liste der Klienten wird in zwei
 * Diensten geführt.
 *
 */
public class Tourplan {
    private CentralClientFinder centralFinder;
    private SapService service;
    private String name;

    Tourplan(String name, CentralClientFinder f, SapService s) {

        // Wenn der Name nicht existiert oder nciht minsestens 3 ZEichen enthält wird eine ungeprüfte Exception geworfen
        // ansonsten, wenn die Anforderungen erfüllt sind wird der Name gesetzt.
        if(name == null || name.isEmpty() || name.length() <= 3 || name.length() >= 31) {
            throw new IllegalArgumentException("Name muss existieren und mindestens 3 Zeichen und maximal 31 Zeichen lang sein.");
        }


        this.name = name;


        centralFinder = f;
        service = s;
    }

    /**
     *
     * @return Liste der Klienten (ohne Duplikate)
     */
    public List<String>  getClients() {


        List<String> list = new ArrayList<String>();
        list.addAll(centralFinder.getClients(name));
        list = addWithoutDuplicates(list, service.getSapClientsForName(name));

        return(list); //Liste, der Klienten -> kann noch Dublikate enthalten


    }


    /**
     *
     * @param list erste Liste mit Klienten
     * @param l zweite Liste mit Klienten
     * @return bereinigte Liste der Klienten (keine Duplikate enthalten)
     */
    private List<String> addWithoutDuplicates(List<String> list, List<String> l) {

        // for- SChleife, um die Liste einmal durch zu gehen und nach Duplikanen zu prüfen
        for(int i = 0; i < list.size(); i++) {

            if(list.contains(i)) {




            }

        }


        return(l);
    }
}
