package yahoo;
import java.util.Scanner;
import java.util.ArrayList;
public class c2021 {
    private static final String TYPE_DOC = "doc";
    private static final String TYPE_IMAGE = "img";
    private static final String OUT_DOC= "document";
    private static final String OUT_IMAGE = "image";
    private static final String OUT_PRESENTATION = "presentation";
    private static final String OUT_OTHER = "other";

    public static void main(String[] args) {
        String[] lines = getStdin();
        if (lines.length < 1) { return; }

        String fileName = lines[0];
        boolean isDoc = fileName.indexOf(TYPE_DOC) >= 0;
        boolean isImage = fileName.indexOf(TYPE_IMAGE) >= 0;
        String output = OUT_OTHER;
        if (isDoc && isImage) {
            output = OUT_PRESENTATION;
        } else if (isDoc) {
            output = OUT_DOC;
        } else if (isImage) {
            output = OUT_IMAGE;
        }
        System.out.println(output);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

}
