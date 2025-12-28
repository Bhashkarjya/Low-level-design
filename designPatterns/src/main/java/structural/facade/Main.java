package structural.facade;

import structural.facade.homeTheatreFacade.Facade;

public class Main {
    public static void main(String[] args) {
        Facade homeSystemfacade = new Facade();
        homeSystemfacade.watchMovie();
        homeSystemfacade.endMovie();
    }
}
