import src.main.java.designPatterns.proxy.Video;
import src.main.java.designPatterns.proxy.YoutubeService;
import src.main.java.designPatterns.proxy.YoutubeServiceImpl;
import src.main.java.designPatterns.proxy.YoutubeServiceProxy;

import java.util.List;

public class ProxyClient {
    public static void main(String[] args) {
        YoutubeService youtubeService = new YoutubeServiceImpl();
        YoutubeService youtubeProxy = new YoutubeServiceProxy(youtubeService);

        Video video1 = new Video("1", "Elon Musk beats Trump");
        Video video2 = new Video("2", "Ronaldo joins Inter Miami");

        youtubeProxy.uploadVideo(video1);
        youtubeProxy.uploadVideo(video2);

        List<Video> allVideos = youtubeProxy.listVideos();
        for(Video video : allVideos) {
            System.out.println(video.getTitle() + ":" + video.getData());
        }
    }
}