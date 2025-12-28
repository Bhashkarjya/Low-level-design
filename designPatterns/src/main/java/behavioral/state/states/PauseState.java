package behavioral.state.states;

import behavioral.state.context.MediaPlayer;

public class PauseState implements PlayerState{
    private MediaPlayer mediaPlayer;
    public PauseState(MediaPlayer player) {
        this.mediaPlayer = player;
    }
    @Override
    public void play() {
        System.out.println("Starting the media player");
        this.mediaPlayer.setState(this.mediaPlayer.getPlayingState());
    }

    @Override
    public void pause() {
        System.out.println("Media player is already paused");
    }
}
