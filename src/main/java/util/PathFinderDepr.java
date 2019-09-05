package util;

public class PathFinderDepr {
    private static final String servletAddrRegex = "/[\\w]+";
    private static final String servletItemAddrRegex = "/[\\w]+/[\\w]+/[0-9]+";
    private static final String servletItemSubmissionRegex = servletItemAddrRegex + "/itemSubmission";
    private static final String servletItemCancelRegex = servletItemAddrRegex + "/itemCancel";
    private static final String servletItemFormSubmission = servletItemAddrRegex + "/[\\w]+";

    public static String findPath(String path) {
        if (path.matches(servletAddrRegex)) {
            return "servlet";
        }
        else if (path.matches(servletItemAddrRegex)) {
            return "servletItem";
        }
        else if (path.matches(servletItemSubmissionRegex)) {
            return "itemSubmission";
        }
        else if (path.matches(servletItemCancelRegex)) {
            return "itemCancel";
        }
        else if (path.matches(servletItemFormSubmission)) {
            return "formSubmission";
        }
        else if (path.matches("/[\\w]+/[\\w]+/[\\w]+")) {
            return "repreg";
        }
        else
        return "servlet";
    }
}
