package behavioral.state.states;

import behavioral.state.context.MediaPlayer;

public class PlayState implements PlayerState {
    private MediaPlayer mediaPlayer;
    public PlayState(MediaPlayer player) {
        this.mediaPlayer = player;
    }
    @Override
    public void play() {
        System.out.println("Media player is already in playing state");
    }

    @Override
    public void pause() {
        System.out.println("Pausing the media player");
        this.mediaPlayer.setState(this.mediaPlayer.getPausedState());
    }
}
