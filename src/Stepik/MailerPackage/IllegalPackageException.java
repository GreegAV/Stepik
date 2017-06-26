package Stepik.MailerPackage;

/**
 * Created by avg-m on 25/06/2017.
 */
public class IllegalPackageException extends RuntimeException {

    public IllegalPackageException () {
        super("In the package discovered forbidden content.");
    }

}
