package behavioral.state.context;

import behavioral.state.states.PauseState;
import behavioral.state.states.PlayState;
import behavioral.state.states.PlayerState;

public class MediaPlayer {
    private PlayerState playingState;
    private PlayerState pausedState;
    private PlayerState currentState;
    public MediaPlayer() {
        this.playingState = new PlayState(this);
        this.pausedState = new PauseState(this);
        this.currentState = new PauseState(this);
    }
    public void setState(PlayerState state) {
        this.currentState = state;
    }

    public PlayerState getPlayingState() {
        return this.playingState;
    }

    public PlayerState getPausedState() {
        return this.pausedState;
    }

    public void play() {
        this.currentState.play();
    }

    public void pause() {
        this.currentState.pause();
    }
}
