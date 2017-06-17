package Stepik;

import java.util.HashMap;

/**
 * Created by avg-m on 18/06/2017.
 */
public class Roles {
    public static void main(String[] args) {

    }
    private static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder result = new StringBuilder("");
        StringBuilder[] results = new StringBuilder[roles.length];
        int linesNumber = 1, positionOfColon, rolesIndex;
        HashMap hashMapByRoles = new HashMap();

        for (int rI = 0; rI < roles.length; rI++) {
            results[rI] = new StringBuilder(roles[rI].subSequence(0, roles[rI].length()));
            results[rI] = results[rI].append(":\n");
            hashMapByRoles.put(roles[rI], rI);
        }

        for (String textLine : textLines) {

            if (textLine.isEmpty()) {continue;}

            positionOfColon = textLine.indexOf(": ");
            String          roleInLine = textLine.substring(0, positionOfColon);
            StringBuilder   rolesTextInLine = new StringBuilder (textLine.substring(positionOfColon + 2));
            rolesIndex = (int)hashMapByRoles.get(roleInLine);
            results[rolesIndex] = results[rolesIndex].append(linesNumber +") ").append(rolesTextInLine).append("\n");
            linesNumber++;

        }

        for (StringBuilder rolesString : results) {

            result = result.append(rolesString).append("\n");

        }

        return result.toString();

    }
}
