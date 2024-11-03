package util;

import model.Persons;

import java.util.Comparator;

public class RoleComparator implements Comparator<Persons> {
    @Override
    public int compare(Persons p1, Persons p2) {
        if (p1.getRole().equals(p2.getRole())) {
            return 0;
        } else if (p1.getRole().equals("Teacher")) {
            return -1;
        } else if (p1.getRole().equals("Senior Student")) {
            return p2.getRole().equals("Teacher") ? 1 : -1;
        } else {
            return 1;
        }
    }
}
