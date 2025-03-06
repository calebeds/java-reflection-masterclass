package constructor.imagebuffer;

import static constructor.imagebuffer.ReflectiveFactory.createObject;

public class TestImageBuffer {
    public static void main(String[] args) throws Throwable {
        var imageBuffer = createObject(ImageBuffer.class);
        System.out.println(imageBuffer);
    }
}
