package controller;

/**
 * Created by kennethhalim on 4/22/17.
 */
public class ImageLoader {
    private static ImageLoader ourInstance = new ImageLoader();

    public static ImageLoader getInstance() {
        return ourInstance;
    }

    private ImageLoader() {

    }
}
