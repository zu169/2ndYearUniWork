package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;
import uk.ac.aber.cs21120.wedding.interfaces.IRules;

import java.util.*;

public class Rules implements IRules {

    ArrayList<Map<String, String>> together = new ArrayList<>();
    ArrayList<Map<String, String>> apart = new ArrayList<>();

    /**
     * Search the list of together rules for the rule where guest a is a key and guest b is a value.
     * @param a - a guest
     * @param b - another guest
     * @return boolean - true if the rule is found.
     */
    public boolean doesTogetherExist(String a, String b){
        for (int r = 0; r < together.size(); r++){
            if (together.get(r).containsKey(a) == true && together.get(r).containsValue(b) == true ){
                return true;
            }
        }
        return false;
    }

    /**
     * Search the list of apart rules for the rule where guest a is a key and guest b is a value.
     * @param a - a guest
     * @param b - another guest
     * @return boolean - true if the rule is found.
     */
    public boolean doesApartExist(String a, String b){
        for (int r = 0; r < apart.size(); r++){
            if (apart.get(r).containsKey(a) == true && apart.get(r).containsValue(b) == true ){
                return true;
            }
        }
        return false;
    }
    /**
     * Add a rule that two guests must be seated at the same table.
     * Make two rules so that both guests are stored as keys.
     * Adding the same rule twice has no effect.
     * @param a a guest
     * @param b another guest
     */

    @Override
    public void addMustBeTogether(String a, String b) {
        if (doesTogetherExist(a, b) == false){
            together.add(new HashMap<>());
            together.get(together.size() - 1).put(a, b);
            together.get(together.size() - 1).put(b, a);
        }
    }

    /**
     * Add a rule that two guests must never be seated at the same table.
     * Make two rules that both guests are stored as keys.
     * Adding the same rule twice has no effect.
     * @param a a guest
     * @param b another guest
     */
    @Override
    public void addMustBeApart(String a, String b) {
        if (doesApartExist(a, b) == false){
            apart.add(new HashMap<>());
            apart.get(apart.size() - 1).put(a, b);
            apart.get(apart.size() - 1).put(b, a);
        }
    }


    /**
     * Search the array of guests at each table.
     * If a rule is found with the current guest check whether the other guest is found in the current table.
     * Return true if the given plan does not break any of the stored rules.
     * @param p a plan
     * @return true if the plan is OK, false if it breaks rules.
     */
    @Override
    public boolean isPlanOK(IPlan p) {
        for (int t = 0; t < p.getNumberOfTables(); t++){
            Set<String> guests = p.getGuestsAtTable(t);
            Object[] guestsarr = guests.toArray();
            /***
             * for each guest check for each enemy if enemy contains key guest
             * check if enemy value is found in guest set
             * if enemy value found return false else do nothing
             ***/
            for (int g = 0; g < guestsarr.length; g++){
                for (int e = 0; e < apart.size(); e++){
                    if (apart.get(e).containsKey(guestsarr[g]) == true){
                        if (guests.contains(apart.get(e).get(guestsarr[g]))){
                            return false;
                        }

                    }
                }
                /***
                 * for each friend if friend contains key guest
                 * check if friend value is found in guest set
                 * if friend value not found return false else do nothing
                 ***/
                for (int f = 0; f < together.size(); f++){
                    if (together.get(f).containsKey(guestsarr[g]) == true){
                        if (guests.contains(together.get(f).get(guestsarr[g])) == false && guests.size() == p.getSeatsPerTable()){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}
