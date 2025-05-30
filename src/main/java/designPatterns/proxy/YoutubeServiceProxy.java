package src.main.java.designPatterns.proxy;

import java.util.HashMap;
import java.util.List;

public class YoutubeServiceProxy implements YoutubeService {
    YoutubeService youtubeService;

    private HashMap<String, Video> cache = new HashMap<String, Video>();

    public YoutubeServiceProxy(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }
    
    @Override 
    public List<Video> listVideos() {
        return youtubeService.listVideos();
    }

    @Override
    public Video getVideoInfo(String id) {
        Video video = this.cache.get(id);
        if(video == null) {
            System.out.println("Cache miss");
            video = youtubeService.getVideoInfo(id);
            this.cache.put(id, video);
            return video;
        }
        else {
            System.out.println("Video fetched from cache");
            return video;
        }
    }

    @Override
    public void uploadVideo(Video video) {
        this.cache.put(video.getId(), video);
        youtubeService.uploadVideo(video);
    }
}
