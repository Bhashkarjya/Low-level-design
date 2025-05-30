package src.main.java.designPatterns.proxy;

import java.util.List;

public interface YoutubeService {
    public List<Video> listVideos();
    public Video getVideoInfo(String id);
    public void uploadVideo(Video video);
}
