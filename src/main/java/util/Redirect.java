package util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Redirect {
    public static void redirectToPreviousPage(HttpServletResponse response, String path) throws IOException {
        response.sendRedirect(path);
    }
}
