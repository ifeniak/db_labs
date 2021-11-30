package ua.lviv.iot.view;

public final class Menu {

    private Menu() {}

    public static void displayMenu() {
        System.out.println("""
                  Table                                |   Method
                ---------------------------------------|------------
                  1: model                             |   1: GET ALL \s
                  2: country                           |   2: GET     \s
                  3: airline                           |   3: CREATE  \s
                  4: plane                             |   4: UPDATE  \s
                  5: city                              |   5: DELETE  \s
                  6: airport                           |              \s
                  7: flight                            |              \s
                  8: route                             |              \s
                  9: nongovernmental_territories       |              \s
                  10: location                         |              \s
                  11: plane_flight_history             |              \s
                """
        );
    }
}
