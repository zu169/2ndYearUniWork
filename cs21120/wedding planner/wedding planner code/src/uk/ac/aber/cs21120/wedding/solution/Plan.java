package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Plan implements IPlan {

    private ArrayList<Set<String>> tables = new ArrayList<>();
    private int seatspertable;
    private int numoftables;

    /**
     * Initialises each instance of a set for every table and assigns the parameters to variables
     * @param numoftables - number of tables in the venue
     * @param seatspertable - number of seats at each table
     */
    public Plan(int numoftables, int seatspertable) {
        this.seatspertable = seatspertable;
        this.numoftables = numoftables;
        for (int t = 0; t < numoftables; t++){
            tables.add(new HashSet<>(seatspertable));
        }

    }

    /**
     * return the number of seats per table. All tables have the same number of seats.
     * This doesn't change once the Plan has been created.
     * @return the number of seats, a positive non-zero integer
     */
    @Override
    public int getSeatsPerTable() {return seatspertable;}

    /**
     * Return the number of tables.
     * This doesn't change once the Plan has been created.
     * @return the number of tables, a positive non-zero integer
     */
    @Override
    public int getNumberOfTables() {
        return numoftables;
    }

    /**
     * Add a guest to a table. If the guest is already seated at any table it will
     * do nothing. If the table is already full (i.e. the number of guests at that table is
     * equal to getSeatsPerTable()) it will do nothing. If the table number is less than zero,
     * or greater or equal to than getNumberOfTables(), it will raise IndexOutOfBoundsException.
     * @param table the table number
     * @param guest the name of the guest
     */
    @Override
    public void addGuestToTable(int table, String guest) {
        if (table < 0 || table >= getNumberOfTables()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (isGuestPlaced(guest) == false && tables.get(table).size() < getSeatsPerTable()) {
                tables.get(table).add(guest);
            }
        }


    }

    /**
     * Remove a guest from any table they are sitting at. If the guest is not at any
     * table, it will do nothing.
     * @param guest the name of the guest
     */
    @Override
    public void removeGuestFromTable(String guest) {
        if (isGuestPlaced(guest) == true){
            for (int i = 0; i<tables.size(); i++){
                if(getGuestsAtTable(i).contains(guest) == true){
                    tables.get(i).remove(guest);
                }
            }
        }
    }

    /**
     * Return whether a guest is sitting at any table.
     * @param guest the name of the guest
     * @return true if the guest is at a table, false otherwise
     */
    @Override
    public boolean isGuestPlaced(String guest) {
        for (int i = 0; i < numoftables; i++){
            if (getGuestsAtTable(i).contains(guest) == true){
                return true;
            }
        }

        return false;
    }

    /**
     * Return a set of the guests seated at a particular table. If the
     * table number of out of range it will raise IndexOutOfBoundsException.
     * @param t the table number
     * @return a set of strings - the guests at that table
     */
    @Override
    public Set<String> getGuestsAtTable(int t) {return tables.get(t);}
}
