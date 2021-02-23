package android.eservices.jobs.data.api.model;


public class Job {

    public static final String TAG = Job.class.getName();

    private String id;
    private String type;
    private String url;
    private String company;
    private String location;
    private String title;
    private String description;
    private String company_logo;

    public Job(String id, String type, String url,
                   String company, String location, String title, String description) {
        this.id = id;
        this.type = type;
        this.url = url;
        this.company = company;
        this.location = location;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
