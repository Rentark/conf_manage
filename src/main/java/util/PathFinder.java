package util;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;

public class PathFinder {
    private static final EnumSet<Paths> paths = EnumSet.allOf(Paths.class);

    public static String selectAction(HttpServletRequest request, String path) {
        return (request.getParameter("btnAction") != null && !request.getParameter("btnAction").isEmpty()) ? request.getParameter("btnAction") : path;
    }

    public static String findPath(String path) {
        return paths.stream().filter(x -> path.matches(x.getRegex())).findFirst().get().name();
    }
}
