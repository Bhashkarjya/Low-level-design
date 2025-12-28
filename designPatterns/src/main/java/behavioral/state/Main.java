package behavioral.state;

import behavioral.state.context.MediaPlayer;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        player.play();
        player.play();
        player.pause();
        player.pause();
    }
}
