package structural.facade.homeTheatreSystems;

public class SoundSystem {
    public void on() { System.out.println("Sound System ON"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
    public void off() { System.out.println("Sound System OFF"); }
}
