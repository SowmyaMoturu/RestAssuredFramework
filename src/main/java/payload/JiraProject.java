package payload;

public class JiraProject {

    private String key;
    private String name;
    private String projectTypeKey;
    private String projectTemplateKey;

    private String description;

    private String url;
    private String assigneeType;
    private int avatarId;
    private String issueSecurityScheme;
    private String permissionScheme;
    private String notificationScheme;
    private String categoryId;
    private String leadAccountId;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public String getProjectTemplateKey() {
        return projectTemplateKey;
    }

    public String getDescription() {
        return description;
    }



    public String getUrl() {
        return url;
    }

    public String getAssigneeType() {
        return assigneeType;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public String getIssueSecurityScheme() {
        return issueSecurityScheme;
    }

    public String getPermissionScheme() {
        return permissionScheme;
    }

    public String getNotificationScheme() {
        return notificationScheme;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getLeadAccountId() {
        return leadAccountId;
    }



    public JiraProject() {
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public void setProjectTemplateKey(String projectTemplateKey) {
        this.projectTemplateKey = projectTemplateKey;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public void setIssueSecurityScheme(String issueSecurityScheme) {
        this.issueSecurityScheme = issueSecurityScheme;
    }

    public void setPermissionScheme(String permissionScheme) {
        this.permissionScheme = permissionScheme;
    }

    public void setNotificationScheme(String notificationScheme) {
        this.notificationScheme = notificationScheme;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setLeadAccountId(String leadAccountId) {
        this.leadAccountId = leadAccountId;
    }

    public void setDefaultValues() {
        this.setAssigneeType("PROJECT_LEAD");
        this.setAvatarId(10318);
        this.setDescription("This is a Project created by Rest Assured Framework");
        this.setUrl("https://sowmyamoturu.atlassian.net/");
        this.setProjectTypeKey("business");
        this.setLeadAccountId("5ee46df9775ca80ac02dfaf9");
        this.setProjectTemplateKey("com.atlassian.jira-core-project-templates:jira-core-simplified-process-control");

    }
}
