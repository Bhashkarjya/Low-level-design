package structural.facade.homeTheatreFacade;

import structural.facade.homeTheatreSystems.DvdPlayer;
import structural.facade.homeTheatreSystems.Lights;
import structural.facade.homeTheatreSystems.Projector;
import structural.facade.homeTheatreSystems.SoundSystem;

public class Facade {
    private final DvdPlayer dvd;
    private final Projector projector;
    private final SoundSystem sound;
    private final Lights lights;
    public Facade() {
        this.dvd = new DvdPlayer();
        this.projector = new Projector();
        this.sound = new SoundSystem();
        this.lights = new Lights();
    }

    public void watchMovie() {
        this.lights.dim();
        this.projector.on();
        this.projector.wideScreenMode();
        this.sound.on();
        this.sound.setVolume(10);
        this.dvd.on();
        this.dvd.play();
    }

    public void endMovie() {
        this.dvd.off();
        this.sound.off();
        this.projector.off();
        this.lights.on();
    }
}
