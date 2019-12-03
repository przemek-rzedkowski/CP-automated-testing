package testing.helpers;

import testing.models.User;
import static testing.helpers.PropertiesHelper.properties;

public class AuthenticationHelper {

    public User getSuperUser() {
        return new User(
             getSuperUserLogin(),
             getSuperUserPassword());
    }

    public String getSuperUserLogin() {
        return properties.getProperty("data.user.login");
    }

    public String getSuperUserPassword() {
        return properties.getProperty("data.user.password");
    }


}
