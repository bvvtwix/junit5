package tryExtention;

public class MainService implements SiteService {
    @Override
    public String say() {
        return "Welcome to heisenbugs";
    }
}
