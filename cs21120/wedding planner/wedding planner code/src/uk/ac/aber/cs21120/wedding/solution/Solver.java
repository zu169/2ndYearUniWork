package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;
import uk.ac.aber.cs21120.wedding.interfaces.IRules;
import uk.ac.aber.cs21120.wedding.interfaces.ISolver;

import java.util.Set;

public class Solver implements ISolver {
    private String[] guests;
    private IPlan p;
    private IRules r;

    /**
     * sets all parameters to local variable
     * @param guests - list of guests that need to be seated
     * @param p - instance of Plan class
     * @param r - instance of Rules class
     */
    public Solver(String[] guests, IPlan p, IRules r) {
        this.guests = guests;
        this.p = p;
        this.r = r;
    }

    /**
     * Attempt to solve the plan with the rules and guests provided in
     * the constructor. Will recurse.
     * @return true if a solution was found, false if no solution was found.
     */
    @Override
    public boolean solve() {
        boolean result;

        for (int t = 0; t < p.getNumberOfTables(); t++){
            int unfilledseats = p.getSeatsPerTable() - p.getGuestsAtTable(t).size();
            for (int s = 0; s < unfilledseats; s++){
                for (String guest: guests){
                    if (p.isGuestPlaced(guest) == false){
                        p.addGuestToTable(t, guest);
                        if (r.isPlanOK(p) == true) {
                            result = solve();
                            if (result == true){
                                return true;
                            }

                        }
                        p.removeGuestFromTable(guest);
                    }
                }
                return false;
            }
        }
        return true;
    }
}
