package src.main.java.designPatterns.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List
;
public class YoutubeServiceImpl implements YoutubeService{
    private HashMap<String, Video> map = new HashMap<String, Video>();
    
    @Override
    public List<Video> listVideos() {
        List<Video> allVideos = new ArrayList<Video>();

        for(Video video : this.map.values()) {
            allVideos.add(video);
        }
        return allVideos;
    }

    @Override
    public Video getVideoInfo(String id) {
        System.out.println("Fetching video info for video Id :" + id);
        return this.map.get(id);
    }

    @Override
    public void uploadVideo(Video video) {
        map.put(video.getId(), video);
        System.out.println("Video " + video.getId() + " uploaded");
        return;
    }
}
